import React, { useEffect, useState } from 'react';
import AppLayout from '../../components/AppLayout';
import Head from 'next/head';
import PostCard from '../../components/PostCard';
import { Avatar, Card } from 'antd';

import { useDispatch, useSelector } from 'react-redux';
import { END } from 'redux-saga';
import { useRouter } from 'next/router';
import axios from 'axios';
import wrapper from '../../store/configureStore';
import { LOAD_USER_POSTS_REQUEST } from '../../reducers/post';
import { LOAD_MY_INFO_REQUEST, LOAD_USER_REQUEST } from '../../reducers/user';



const User = () => {
    const dispatch = useDispatch();
    ////////////////////////// code      GET    /user/1
    // 유저정보
    const router = useRouter();
    const { id } = router.query;
    const { user, userInfo } = useSelector(state => state.user);
    const { mainPosts, hasMorePosts, loadPostsLoading } = useSelector(state => state.post);
    /*const [userInfo, setUserInfo] = useState(null);
      const [mainPosts, setMainPosts] = useState([]);
      const [hasMorePosts, setHasMorePosts] = useState(true);
      const [loading, setLoading] = useState(true);
      const [error, setError] = useState(null);
    
      // 유저정보 불러오기
      useEffect(() => {
        //////////  axios
        const fetchData = async () => {
          try {
            setLoading(true);
            const userResponse = await axios.get(`http://localhost:3065/user/${id}`, { withCredentials: true });
            const postsResponse = await axios.get(`http://localhost:3065/user/${id}/posts`, { withCredentials: true });
    
            setUserInfo(userResponse.data);
            setMainPosts(postsResponse.data);
            setHasMorePosts(postsResponse.data.length > 0);
          } catch (err) {
            setError(err);
          } finally {
            setLoading(false);
          }
        };
        if (id) { fetchData(); }
      }, [id]);
    */
    // 스크롤처리

    //## 스크롤내려서 맨끝에서 다시 로딩
    useEffect(() => {
        function onScroll() {
            console.log(window.pageYOffset, document.documentElement.clientHeight, document.documentElement.scrollHeight)
            if (window.pageYOffset + document.documentElement.clientHeight > document.documentElement.scrollHeight - 200) {
                if (hasMorePosts && !loadPostsLoading) {  //##
                    dispatch({
                        type: LOAD_USER_POSTS_REQUEST,
                        lastId: mainPosts[mainPosts.length - 1] && mainPosts[mainPosts.length - 1].id,
                        data: id
                    })
                    /*
                    axios.get(`http://localhost:3065/user/${id}/posts?lastId=${mainPosts[mainPosts.length - 1]?.id}`, { withCredentials: true })
                      .then(response => {
                        setMainPosts(prev => [...prev, ...response.data]);
                        setHasMorePosts(response.data.length > 0);
                      })
                      .catch(err => setError(err));
                    */
                }
            }
        }
        window.addEventListener('scroll', onScroll);
        return () => {
            window.removeEventListener('scroll', onScroll);  //스크롤했으면 스크롤했던거 remove, 메모리에 쌓임
        }
    }, [mainPosts.length, hasMorePosts, id, loadPostsLoading]); //##

    // if (loading) { return <div>정보 ing....</div> }
    // if (error) { return <div>error</div> }
    ////////////////////////// view
    return (
        <AppLayout>
            {userInfo && (
                <Head>
                    <title> {userInfo.nickname}님의 글</title>
                    <meta name="description" content={`${userInfo.nickname}님의 게시글`} />
                </Head>
            )}
            {userInfo
                ? (
                    <Card actions={[
                        <div key="post">게시글<br /> {userInfo.Posts.length}</div>,
                        <div key="followings">팔로잉<br /> {userInfo.Followings.length}</div>,
                        <div key="followers">팔로워<br /> {userInfo.Followers.length}</div>,
                    ]}>
                        <Card.Meta
                            avatar={<Avatar>{userInfo.nickname[0]}</Avatar>}
                            title={userInfo.nickname}
                        />
                    </Card>
                )
                : null}
            {mainPosts.map((c) => (
                <PostCard key={c.id} post={c} />
            ))}
        </AppLayout>);
};
///////////////////////////////////////////////////////////
export const getServerSideProps = wrapper.getServerSideProps(async (context) => {
    //1. cookie 설정
    const cookie = context.req ? context.req.headers.cookie : '';
    axios.defaults.headers.Cookie = '';

    if (context.req && cookie) { axios.defaults.headers.Cookie = cookie; }

    //2. redux 액션
    context.store.dispatch({ type: LOAD_MY_INFO_REQUEST });
    context.store.dispatch({
        type: LOAD_USER_POSTS_REQUEST
        , data: context.params.id,
    });
    context.store.dispatch({
        type: LOAD_USER_REQUEST,
        data: context.params.id,
    });
    context.store.dispatch(END);

    await context.store.sagaTask.toPromise();
});
///////////////////////////////////////////////////////////
export default User;