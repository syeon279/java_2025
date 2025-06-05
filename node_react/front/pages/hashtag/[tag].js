import React, { useEffect, useState } from "react";
import { useRouter } from "next/router";
import { useDispatch, useSelector } from "react-redux";

import { LOAD_HASHTAG_POSTS_REQUEST } from '../../reducers/post';
import { LOAD_MY_INFO_REQUEST, } from '../../reducers/user';

import wrapper from '../../store/configureStore';
import { END } from 'redux-saga';
import axios from 'axios';

import AppLayout from "../../components/AppLayout";
import PostCard from "../../components/PostCard";

const Hashtag = () => {
    // ................. code
    const router = useRouter();
    const dispatch = useDispatch;

    const { tag } = router.query;
    const { mainPosts, hasMorePosts, loadPostsLading } = useSelector(state => state.post);
    // const [mainPosts, setMainPosts] = useState([]);
    // const [hasMorePosts, setHasMorPosts] = useState(true);
    // const [loading, setLoading] = useState(true);
    // const [error, setError] = useState(null);

    /*
    useEffect(() => {
        const fetchPosts = async () => {
            try {
                setLoading(true);
                const reponse = await axios.get(
                    `http://localhost:3065/hashtag/${tag}`, { withCredentials: true }
                );
                setMainPosts(reponse.data);
                setHasMorPosts(reponse.data.length > 0);
            } catch (error) {
                setError(error);
                console.log('🚨 err: ', error);
            } finally {
                setLoading(false);
            }
        };
        if (tag) { fetchPosts(); }
    }, [tag]);
    */

    // ................. scroll
    useEffect(() => {
        function onScroll() {
            if (window.pageYOffset + document.documentElement.clientHeight > document.documentElement.scrollHeight - 200) {
                if (hasMorePosts && !loadPostsLading) {
                    dispatch({
                        type: LOAD_HASHTAG_POST_REQUEST,
                        lastId: mainPosts[mainPosts.length - 1]?.id,
                        data: tag
                    });
                    /*
                    axios.get(`http://localhost:3065/hashtag/${tag}?listId=${mainPosts[mainPosts.length - 1]?.id}`, { withCredentials: true })
                        .then((response) => {
                            setMainPosts((prev) => [...prev, ...response.data]);
                            setHasMorPosts(response.data.length > 0);
                        }).catch((err) => setError(err));
                    */
                }
            }
        }
        window.addEventListener('scroll', onScroll);
        return () => {
            window.removeEventListener('scroll', onScroll);  //스크롤했으면 스크롤했던거 remove, 메모리에 쌓임
        }
    }, [mainPosts.length, hasMorePosts, tag, loadPostsLading]);

    if (loadPostsLading) { return <div>해쉬태그 게시글 ing... </div> }

    // ................. view
    return (<AppLayout>
        {mainPosts.map((c) => { return (<PostCard post={c} key={c.id} />); })}
    </AppLayout>);
};
//////////////////////////////////////////////////////////////////////////
export const getServerSideProps = wrapper.getServerSideProps(async (context) => {
    // 1. cookie 설정
    const cookie = context.req ? context.req.headers.cookie : '';
    //const cookie = context.req ?? '';
    axios.defaults.headers.Cookie = '';

    if (context.req && cookie) { axios.defaults.headers.Cookie = cookie; }

    // 2. redux 액션
    context.store.dispatch({ type: LOAD_MY_INFO_REQUEST });
    context.store.dispatch({ type: LOAD_HASHTAG_POSTS_REQUEST, data: context.params.tag });
    context.store.dispatch(END);

    await context.store.sagaTask.toPromise();
});
//////////////////////////////////////////////////////////////////////////

export default Hashtag;