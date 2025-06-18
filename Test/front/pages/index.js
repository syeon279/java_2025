import React, { useEffect } from 'react';  //##
import { useDispatch, useSelector } from 'react-redux';  //##

import AppLayout from '../components/AppLayout'
import PostForm from '../components/PostForm';
import PostCard from '../components/PostCard';

import { LOAD_POSTS_REQUEST } from '../reducers/post';
import { LOAD_MY_INFO_REQUEST } from '../reducers/user';

import wrapper from '../store/configureStore';
import { END } from 'redux-saga';
import axios from 'axios';


const Home = () => {
    const dispatch = useDispatch();  //##
    const { user } = useSelector(state => state.user);
    const { mainPosts, loadPostsLoading } = useSelector(state => state.post);

    useEffect(() => {
        function onScroll() {
            if (window.screenY + document.documentElement.clientHeight > document.documentElement.scrollHeight - 200) {
                if (hasMorePosts && !loadPostsLoading) {
                    dispatch({ type: LOAD_POSTS_REQUEST, data: mainPosts[mainPosts.length - 1]?.id, })
                }
            }
        }
        window.addEventListener('scroll', onScroll);
        return () => {
            window.removeEventListener('scroll', onScroll);
        }
    }, [mainPosts, loadPostsLoading]);

    useEffect(() => {
        dispatch({ type: LOAD_MY_INFO_REQUEST });
        dispatch({ type: LOAD_POSTS_REQUEST });
    }, [dispatch]);

    return (
        <AppLayout>
            {user && <PostForm />}

            {mainPosts.map((c) => {
                return (
                    <PostCard post={c} key={c.id} />
                );
            })}

        </AppLayout>);
}

//////////////////////////////////////////////////////////////////////////
export const getServerSideProps = wrapper.getServerSideProps(async (context) => {
    const cookie = context.req ? context.req.headers.cookie : '';
    axios.defaults.headers.Cookie = '';

    if (context.req && cookie) { axios.defaults.headers.Cookie = cookie; }

    context.store.dispatch({ type: LOAD_MY_INFO_REQUEST });
    context.store.dispatch({ type: LOAD_POSTS_REQUEST });
    context.store.dispatch(END);

    await context.store.sagaTask.toPromise();
});
//////////////////////////////////////////////////////////////////////////

export default Home;