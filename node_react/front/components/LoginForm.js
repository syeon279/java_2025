import React, { useCallback, useState, useEffect } from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Button, Checkbox, Form, Input } from 'antd';
import Link from 'next/Link';
import userInput from '../hooks/userInput';

import { LOG_IN_REQUEST } from '../reducers/user';  //#1. redux
import { useDispatch, useSelector } from 'react-redux';  //#2/ redux - useDispatch 


//const LoginForm = ({ setIsLogin }) => {
const LoginForm = () => { //#3. redux
    const { logInLoading, logInError } = useSelector((state) => state.user);
    console.log('...........LoginForm/logInLoading? : ' + logInLoading);
    const [email, onchageEmail] = userInput('');
    const [password, onChagePassword] = userInput('');

    const dispatch = useDispatch();  //#4. redux 

    useEffect((logInError) => {
        if (logInError) {
            alert(logInError);
        }
    }, [logInError]);

    const onSubmitForm = useCallback(() => {
        dispatch({
            type: LOG_IN_REQUEST,
            data: { email, password }
        });  //#5. redux
    }, [email, password]);

    //view
    return (
        <Form layout="vertical" style={{ padding: '5%' }} onFinish={onSubmitForm}>
            <Form.Item
                label="아이디"
                name="username"
                rules={[
                    {
                        required: true,
                        message: 'Please input your Username!',
                    },
                ]}
            >
                <Input name="email" value={email} onChange={onchageEmail} required />
            </Form.Item>
            <Form.Item
                label="Password"
                name="password"
                rules={[
                    {
                        required: true,
                        message: 'Please input your Password!',
                    },
                ]}
            >
                <Input.Password name="password" value={password} onChange={onChagePassword} />
            </Form.Item>
            <Form.Item>
                <Button type="primary"
                    htmlType="submit"
                    className="login-form-button"
                    loading={logInLoading}
                    style={{ margin: '3%', marginRight: '8%' }}>
                    Log in
                </Button>
                Or <a href="/signup" style={{ margin: '5%' }} > 회원 가입 </a>
            </Form.Item>
        </Form>
    );
};

export default LoginForm;