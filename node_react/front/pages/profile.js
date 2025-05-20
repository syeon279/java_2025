import React from 'react';
import AppLayout from '../components/AppLayout';
//import 'antd/dist/antd.css'
import Head from 'next/head';
import NicknameForm from '../components/NicknameForm';
import FollowList from '../components/FollowList';

const Profile = () => {
    ////////////////// code
    const data = [{ nickname: 'Title1' }, { nickname: 'Title2' }, { nickname: 'Title3' }, { nickname: 'Title4' }];
    console.log(data);

    ////////////////// view
    return (
        <>
            <Head>
                <meta charSet="utf-8"></meta>
                <title>Profile | TheJoa </title>
            </Head>
            <AppLayout>
                <NicknameForm />
                <FollowList header='팔로잉' data={data} />
                <FollowList header='팔로워' data={data} />
            </AppLayout>
        </>
    );
};

export default Profile;