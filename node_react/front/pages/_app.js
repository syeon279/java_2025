import React, { Component } from 'react';
import PropTypes from 'prop-types';
import 'antd/dist/antd.css';
import Head from 'next/head';

const TheJoa = ({ Component }) => {

    return (<>
        <Head>
            <meta charSet="utf-8"></meta>
            <title>TheJoa</title>
        </Head>
        <Component></Component>
    </>);
};
TheJoa.propTypes = {
    Component: PropTypes.elementType.isRequired
}

export default TheJoa;