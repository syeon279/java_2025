import React from 'react';
import AppLayout from '../components/AppLayout';
//import 'antd/dist/antd.css'
import Head from 'next/head';

const Profile = () => {
    return (
        <>
            <Head>
                <meta charSet="utf-8"></meta>
                <title>Profile | TheJoa </title>
            </Head>
            <AppLayout>내 프로필</AppLayout>
        </>
    );
};

export default Profile;