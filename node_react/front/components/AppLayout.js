import React, { useState, useMemo, useCallback } from 'react';   // react 불러오기   #
import PropTypes from 'prop-types'; // props 타입검사하는 역할
import Link from 'next/Link';
import { Menu, Input, Row, Col } from 'antd';
import UserProfile from './UserProfile';
import LoginForm from './LoginForm';
import styled from 'styled-components';
import Router from 'next/router';

import { useSelector } from 'react-redux';
import userInput from '../hooks/userInput';
const InputSearch = styled(Input.Search)`vertical-align:middle`;
const AppLayout = ({ children }) => {

  // useMemo
  const stylebg = useMemo(() => ({ backgroundColor: '#efefef' }), []);
  const { user } = useSelector(state => state.user);
  const [searchInput, onChangesearchInput] = userInput('');
  const onSearch = useCallback(() => {
    Router.push(`/hashtag/${searchInput}`);
  });
  ///////////////////////////////////////////// code
  const items = [
    { label: <Link href="/">LOGO</Link>, key: '/' }
    , { label: <Link href="/profile">프로필</Link>, key: '/profile' }
    , { label: <Link href="/signup">회원가입</Link>, key: '/signup' }
    , {
      label: <InputSearch
        placeholder="input search text"
        enterButton
        value={searchInput}
        onChange={onChangesearchInput}
        onSearch={onSearch}
      />, key: '/search'
    }
  ];

  ///////////////////////////////////////////// view
  return (
    <div>
      <Menu mode="horizontal" items={items} />
      <Row gutter={8}>
        <Col xs={24} md={6} >
          {user ? <UserProfile /> : <LoginForm />}
        </Col>
        <Col xs={24} md={12} style={stylebg} > {children}  </Col>
        <Col xs={24} md={6} > <div>
          <a href="https://thejoa.com"
            target="_blank"
            rel="noreferrer  noopener">TheJoa</a> copyrights. all reserved. </div> </Col>
      </Row>
    </div>
  );
};

AppLayout.propTypes = {
  children: PropTypes.node.isRequired,
};

export default AppLayout;