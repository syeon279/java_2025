import React from 'react';
import PropTypes from 'prop-types';
import 'antd/dist/antd.css';
import Head from 'next/head';
import wrapper from '../store/configureStore';
import GlobalStyle from '../styles/GlobalStyle';

const Test = ({ Component }) => {
    // view
    return (
        <>
            <Head>
                <meta charSet="utf-8" />
                <title>Test</title>
            </Head>
            <GlobalStyle />
            <Component />
        </>

    );
};

Test.propTypes = {
    Component: PropTypes.elementType.isRequired,
}

export default wrapper.withRedux(Test);