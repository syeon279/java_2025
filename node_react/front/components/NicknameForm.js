import React from 'react';
import { Form, Input } from 'antd';

import { useCallback, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { CHANGE_NICKNAME_REQUEST } from '../reducers/user';
import UserInput from '../hooks/userInput';

const NicknameForm = () => {
    const { user } = useSelector(state => state.user);
    const [nickname, onChangNickname] = UserInput(user?.nickname || '');

    const { changeNicknameLoading } = useSelector(state => state.user);
    const id = useSelector(state => state.user.user?.id);
    const dispatch = useDispatch();
    const onSubmit = useCallback((nickname) => {
        console.log('..............onSubmitForm : ' + nickname);
        dispatch({
            type: CHANGE_NICKNAME_REQUEST,
            data: nickname
        });
    }, [nickname]);

    return (
        <Form name="nickname">
            <Input.Search
                addonBefore="닉네임"
                onChange={onChangNickname}
                onSearch={(value) => {
                    console.log('닉네임 수정:', value);
                    dispatch({
                        type: CHANGE_NICKNAME_REQUEST,
                        data: value, // 문자열 그대로 전달
                    });
                }}
                value={nickname}
                name="nickname"
                enterButton="수정"
                loading={changeNicknameLoading}
            />
        </Form>

    );
};

export default NicknameForm;