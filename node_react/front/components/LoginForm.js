import React, { useCallback, useState } from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Button, Checkbox, Form, Input } from 'antd';
import Link from 'next/Link';
import userInput from '../hooks/userInput';

import { loginAction } from '../reducers/user';  //#1. redux
import { useDispatch, useSelector } from 'react-redux';  //#2/ redux - useDispatch 


//const LoginForm = ({ setIsLogin }) => {
const LoginForm = () => { //#3. redux
    const { logInLoading } = useSelector((state) => state.user);
    // const { logInLoading } = useSelector(state => state.user);
    console.log('...........logInLoading? : ' + logInLoading);
    const [id, onchageId] = userInput('');
    const [password, onChagePassword] = userInput('');

    const dispatch = useDispatch();  //#4. redux 

    const onSubmitForm = useCallback(() => { // 컴포넌트가 처음 렌더링될 때 한번만 생성
        dispatch(loginAction({ id, password }));  //#5. redux
    }, [id, password]); // is, pass값이 변경 될 때 = 의존성 배열

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
                <Input name="id" value={id} onChange={onchageId} required />
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