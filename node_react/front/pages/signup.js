import React, { useState, useCallback } from 'react';
import AppLayout from '../components/AppLayout';
//import 'antd/dist/antd.css';
import Head from 'next/head';
import { Form, Button, Input, Checkbox } from 'antd';
import userInput from '../hooks/userInput';
import styled from 'styled-components';

const ErrorMessage = styled.div`color:blue;`;

// 1. SIGN_UP_REQUEST
import { signupAction } from '../reducers/user';
import { SIGN_UP_REQUEST } from '../reducers/user';
// 2. dispatch, useSelctor
import { useDispatch, useSelector } from 'react-redux';


const Signup = () => {
    // 3. useSelector 이용해서 - signUpLoading 가져오기
    const { signUpLoading } = useSelector((state) => state.user);

    // 4. dispatch 선언
    const dispatch = useDispatch();

    //          code
    const [id, onChangeId] = userInput('');
    const [nickname, onChangeNickname] = userInput('');
    const [password, onChangePass] = userInput('');

    const [password_re, setChangePassword_re] = useState('');
    const [passwordError, setPasswordError] = useState(false);
    const onChangePassword_re = useCallback((e) => {
        setChangePassword_re(e.target.value);
        setPasswordError(e.target.value != password);
    }, [password]);

    const [check, setCheck] = useState('');
    const [checkError, setCheckError] = useState(false);
    const onChangeCheck = useCallback((e) => {
        setCheck(e.target.checked); // true 면 
        setCheckError(false); // false로 바뀜
    }, [check]);

    const onSubmitForm = useCallback(() => {
        if (password != password_re) {
            return setPasswordError(true);
        }
        if (!check) {
            setCheckError(true);
        }

        // 6. dispatch
        return dispatch({
            type: SIGN_UP_REQUEST,
            data: { id, password, nickname },
        });
        //dispatch(signupAction({ id, password }))
    }, [id, password, password_re, check]);
    console.log('........SIGN_UP_REQUEST : ' + SIGN_UP_REQUEST);

    //          view
    return (
        <>
            <Head>
                <meta charSet="utf-8"></meta>
                <title> Signup | TheJoa </title>
            </Head>
            <AppLayout>
                <Form layout='vertical' style={{ padding: '3%' }} onFinish={onSubmitForm}>
                    <Form.Item>
                        <label htmlFor='id'>아이디</label>
                        <Input placeholder='youremail@email.com' id='id' name='id'
                            value={id} onChange={onChangeId} required />
                    </Form.Item>
                    <Form.Item>
                        <label htmlFor='nickname'>닉네임</label>
                        <Input placeholder='nickname' id='nickname' name='nickname'
                            value={nickname} onChange={onChangeNickname} required />
                    </Form.Item>
                    <Form.Item>
                        <label htmlFor='password'>비밀번호</label>
                        <Input.Password placeholder='password' id='password' name='password'
                            value={password} onChange={onChangePass} required />
                    </Form.Item>
                    <Form.Item>
                        <label htmlFor='password-re'>비밀번호 확인</label>
                        <Input.Password placeholder='password' id='password-re' name='password-re'
                            value={password_re} onChange={onChangePassword_re} required />
                        {passwordError && <ErrorMessage>비밀번호를 확인해주세요.</ErrorMessage>}
                    </Form.Item>
                    <Form.Item>
                        <label htmlFor='check'>약관에 동의해주세요<br /></label>
                        <Checkbox name='check' id='check' checked={check} onChange={onChangeCheck}>이용약관</Checkbox>
                        {checkError && <ErrorMessage>약관에 동의해주세요.</ErrorMessage>}
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary"
                            htmlType="submit"
                            loading={signUpLoading}
                        >
                            회원가입
                        </Button>
                    </Form.Item>

                </Form>
            </AppLayout >
        </>
    );
};

export default Signup;