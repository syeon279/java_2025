import React from 'react';
import PropTypes from 'prop-types';
import 'antd/dist/antd.css';   // 공통css
import Head from 'next/head';
import wrapper from '../store/configureStore';  //## 

const TheJoa = ({ Component }) => {
  //////////////////////////////////////////////// view
  return (
    <>
      <Head>
        <meta charSet="utf-8" />
        <title>TheJoa</title>
      </Head>
      <Component />
    </>

  );
};

TheJoa.propTypes = {
  Component: PropTypes.elementType.isRequired,
}

export default wrapper.withRedux(TheJoa);