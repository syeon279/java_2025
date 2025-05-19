import React from 'react';
import AppLayout from '../components/AppLayout';
//import 'antd/dist/antd.css'
import Head from 'next/head';

const Signup = () => {
    return (
        <>
            <Head>
                <meta charSet="utf-8"></meta>
                <title> Signup | TheJoa </title>
            </Head>
            <AppLayout>회원가입</AppLayout>
        </>
    );
};

export default Signup;