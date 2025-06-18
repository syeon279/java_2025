import React, { useState, useMemo, useCallback } from 'react';
import PropTypes from 'prop-types';
import Link from 'next/Link';
import { Menu, Input, Row, Col, Button } from 'antd';
import UserProfile from './UserProfile';
import LoginForm from './LoginForm';
import styled from 'styled-components';
import Router from 'next/router';

import { useSelector } from 'react-redux';
import userInput from '../hooks/userInput';

const Wrapper = styled.div`
  position: relative;
  min-height: 100vh;
  padding: 16px;

  &::before {
    content: '';
    position: fixed;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;

    background-image:
      url('https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Cloud_font_awesome.svg/800px-Cloud_font_awesome.svg.png'),
      linear-gradient(to bottom, rgb(125, 218, 255), #ffffff);

    background-repeat: no-repeat, no-repeat;
    background-position: top center, top;
    background-size: 300px, cover;

    z-index: -1;
    opacity: 1;
  }
`;

const AppLayout = ({ children }) => {
  const stylebg = useMemo(() => ({
    padding: '3%', borderRadius: '16px', margin: '2%',
    backgroundColor: '#fff',
    boxShadow: '0 4px 12px rgba(0, 0, 0, 0.3)',
  }), []);

  const stylePrifile = useMemo(() => ({
    padding: '3%', margin: '2%',
  }), []);

  const styleButtons = useMemo(() => ({
    display: 'flex',
    justifyContent: 'center',
    gap: '32px',
    marginBottom: '24px',
  }), []);

  const styleButton = useMemo(() => ({
    padding: '0 3%',
    borderRadius: '16px',
    background: 'linear-gradient(to bottom, #ffffff, #a4ff9f)',
    boxShadow: '0 4px 12px rgba(0, 0, 0, 0.3)',
    fontFamily: 'Ycomputer-Regular',
    height: '40px',
    lineHeight: '40px',
    textAlign: 'center',
    fontSize: '20px',
    border: 'none',
    color: '#000',
    border: '1px solid rgb(112, 112, 112)'
  }), []);


  const { user } = useSelector(state => state.user);

  ///////////////////////////////////////////// code

  ///////////////////////////////////////////// view
  return (
    <Wrapper>
      <div style={styleButtons}>
        <Button style={styleButton} href='/'>TEST</Button>
        <Button style={styleButton} href='/profile'>PROFILE</Button>
        <Button style={styleButton} href='/signup'>Sign-Up</Button>
      </div>
      <Row gutter={8}>
        <Col xs={24} md={6} style={stylePrifile} >
          {user ? <UserProfile me={user} /> : <LoginForm />}
        </Col>
        <Col xs={24} md={12} style={stylebg} > {children}  </Col>
      </Row>
    </Wrapper >
  );
};

AppLayout.propTypes = {
  children: PropTypes.node.isRequired,
};

export default AppLayout;