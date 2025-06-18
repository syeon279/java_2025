import React, { useState, useCallback, useEffect, useMemo } from 'react'
import { Input, Button, Form, Row, Col } from 'antd';
import Link from 'next/Link';
import userInput from '../hooks/userInput';

import { useDispatch, useSelector } from 'react-redux';
import { LOG_IN_REQUEST } from '../reducers/user';

const LoginForm = () => { //#3  redux
  const { logInLoading, logInError } = useSelector(state => state.user);
  ///////////////////////////////////////////// code
  const [email, onChangeEmail] = userInput('');
  const [password, onChangePassword] = userInput('');

  const dispatch = useDispatch();  //#4.   redux

  useEffect(() => { if (logInError) { alert(logInError); } }, [logInError]);

  const onSubmitForm = useCallback(() => {
    console.log(email, password);
    dispatch({
      type: LOG_IN_REQUEST,
      data: { email, password }
    });
  }, [email, password]);

  const LoginForm = useMemo(() => ({
    padding: '5%', borderRadius: '16px', margin: '2%',
    //backgroundColor: '#fff',
    boxShadow: '0 4px 12px rgba(0, 0, 0, 0.3)',
    background: 'linear-gradient(to bottom,rgb(255, 255, 255),rgb(250, 250, 250))',
    fontFamily: 'Ycomputer-Regular',
  }), []);

  const styleButton = useMemo(() => ({
    padding: '5%',
    borderRadius: '0px',
    marginRight: '3%',
    backgroundColor: '#fff',
    borderRadius: '16px',
    fontFamily: 'Ycomputer-Regular',
    textAlign: 'center',
    fontSize: '15px',
    border: '1px solid #000',
    heigth: '10px',
    lineHeight: '10px',
    background: 'linear-gradient(to bottom, #ffffff, #a4ff9f)',
    color: '#000',
    cursor: 'pointer',
  }), []);

  ///////////////////////////////////////////// view
  return (
    <>
      <Form layout="vertical" style={LoginForm} onFinish={onSubmitForm}  >
        <Form.Item label="아이디" name="email"  >
          <Input placeholder="user@gmail.com 형식으로 입력"
            value={email} onChange={onChangeEmail} required />
        </Form.Item>
        <Form.Item label="비밀번호" name="password" >
          <Input.Password placeholder="비밀번호 입력"
            value={password} onChange={onChangePassword} required />
        </Form.Item>
        <Form.Item style={{ textAlign: 'center' }}>
          <div style={{ display: 'flex', justifyContent: 'center', gap: '16px' }}>
            <Button
              style={styleButton}
              htmlType='submit'
              loading={logInLoading}
            >로그인</Button>
            <Link href="/signup" legacyBehavior ><Button style={styleButton} >회원가입</Button></Link>
          </div>
        </Form.Item>
      </Form >
    </>
  );
};
export default LoginForm;