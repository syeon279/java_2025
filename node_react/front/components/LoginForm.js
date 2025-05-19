import React, { useCallback, useState } from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Button, Checkbox, Form, Input } from 'antd';
import Link from 'next/Link';

const LoginForm = () => {
    ////////////////////////////////////////////code
    const [id, setId] = useState(''); // 상태 관리 - 컴포넌트에서 값이 변경
    const onchageId = useCallback((e) => {
        setId(e.target.value);
        console.log(e.target.value);
    }, []); // function - 함수의 재성성

    const [password, setPassword] = useState('');
    const onChagePass = useCallback((e) => {
        setPassword(e.target.value);
        console.log(e.target.value);
    }, []);

    // Q. 로그인 버튼 클릭시 count의 숫자 증가, 콘솔 창에 숫자 증가 (useState)
    const [count, setCount] = useState('');
    const onChangeCount = () => {
        setCount(Number(count) + 1);
        console.log(count);
    };

    //////////////////////////////////////////// view
    return (
        <Form layout="vertical" style={{ padding: '5%' }}>
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
                <Input.Password />
            </Form.Item>
            <Form.Item>
                <Button type="danger" htmlType="submit" className="login-form-button" style={{ margin: '5px' }} onClick={onChangeCount} value={count}>
                    Log in
                </Button>
                Or <a href="/signup" style={{ margin: '5px' }} > 회원 가입 </a>
            </Form.Item>
        </Form>
    );
};

export default LoginForm;