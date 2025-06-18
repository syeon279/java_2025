import React, { useState, useCallback, useEffect, useMemo } from 'react';
import Head from 'next/head';
import { useSelector, useDispatch } from 'react-redux';
import Router from 'next/router';

import { LOAD_MY_INFO_REQUEST } from '../reducers/user';

import wrapper from '../store/configureStore';
import { END } from 'redux-saga';
import axios from 'axios';

import { Card, Avatar, Button } from 'antd';
import AppLayout from '../components/AppLayout'
import { LOAD_POSTS_REQUEST } from '../reducers/post';
import PostCard from '../components/PostCard';

const Profile = () => {
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch({ type: LOAD_MY_INFO_REQUEST });
        dispatch({ type: LOAD_POSTS_REQUEST });
    }, [dispatch]);

    const { user } = useSelector((state) => state.user);
    const { mainPosts, loadPostsLoading } = useSelector(state => state.post);
    console.log(user);

    useEffect(() => { if (!(user && user.id)) { Router.push('/'); } }, [user && user.id]);

    const myBox = useMemo(() => ({
        fontSize: 24,
        padding: '3%',
        borderRadius: '20px',
        fontFamily: 'Ycomputer-Regular',
        border: '2px solid rgb(112, 112, 112)',
        boxShadow: '6px 6px 6px rgb(0, 0, 0)',
    }), []);

    const styleAvatar = useMemo(() => ({
        width: 64,
        height: 64,
        fontSize: 24,
        border: '2px solid rgb(112, 112, 112)',
    }), []);

    const styleButton = useMemo(() => ({

        padding: '0 5%',
        margin: '4%',
        borderRadius: '16px',
        background: 'linear-gradient(to bottom, #ffffff, #a4ff9f)',
        boxShadow: '0px 3px 5px rgba(0, 0, 0, 0.3)',
        fontFamily: 'Ycomputer-Regular',
        textAlign: 'center',
        fontSize: '20px',
        border: 'none',
        color: '#000',
    }), []);

    const [showPosts, setShowPosts] = useState(false);

    const togglePosts = useCallback(() => {
        setShowPosts((prev) => !prev);
    }, []);

    return (
        <>
            <Head>
                <meta charSet="utf-8" />
                <title> Profile | TEST </title>
            </Head>
            <AppLayout>
                <div style={myBox}>
                    <Card style={{ border: 'none' }}>
                        <div style={{ display: 'flex', alignItems: 'center', gap: '12px' }}>
                            <Avatar
                                src="https://img3.tmon.kr/cdn4/deals/2024/06/25/27116047158/front_7cf4c_jujyg.jpg"
                                style={styleAvatar}
                            >
                                {user?.nickname[0]}
                            </Avatar>
                            <div style={{ fontSize: '18px', fontWeight: 'bold', marginLeft: '3%' }}>{user?.nickname}</div>
                        </div>
                    </Card>
                </div >
                <div>
                    <Button style={styleButton} onClick={togglePosts}>
                        {showPosts ? '닫기' : '내가 쓴 글'}
                    </Button>
                    {showPosts && mainPosts
                        .filter((post) => post.User?.id === user?.id)
                        .map((post) => (
                            <PostCard post={post} key={post.id} />
                        ))}
                </div>
            </AppLayout >
        </>
    );
}

//////////////////////////////////////////////////////////////////////////
export const getServerSideProps = wrapper.getServerSideProps(async (context) => {
    const cookie = context.req ? context.req.headers.cookie : '';
    axios.defaults.headers.Cookie = '';

    if (context.req && cookie) { axios.defaults.headers.Cookie = cookie; }

    context.store.dispatch({ type: LOAD_MY_INFO_REQUEST });
    context.store.dispatch(END);

    await context.store.sagaTask.toPromise();
});
//////////////////////////////////////////////////////////////////////////

export default Profile;
