import React, { useCallback, useState } from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Button, Checkbox, Form, Input } from 'antd';
import Link from 'next/Link';
import userInput from '../hooks/userInput';

const LoginForm = ({ setIsLogin }) => {
    ////////////////////////////////////////////code
    const [id, onchageId] = userInput('');
    const [password, onChagePassword] = userInput('');

    // Q. 로그인 버튼 클릭시 count의 숫자 증가, 콘솔 창에 숫자 증가 (useState)
    const [count, setCount] = useState('');
    const onChangeCount = () => {
        setCount(Number(count) + 1);
        console.log(count);
    };

    const onSubmitForm = useCallback(() => { // 컴포넌트가 처음 렌더링될 때 한번만 생성
        console.log(id, password);
        setIsLogin(true);
    }, [id, password]); // is, pass값이 변경 될 때

    //////////////////////////////////////////// view
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
                <Button type="primary" htmlType="submit" className="login-form-button" loading={false} style={{ margin: '3%', marginRight: '8%' }} onClick={onChangeCount} value={count}>
                    Log in
                </Button>
                Or <a href="/signup" style={{ margin: '5%' }} > 회원 가입 </a>
            </Form.Item>
        </Form>
    );
};

export default LoginForm;