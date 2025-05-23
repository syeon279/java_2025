import React from 'react';
import { Form, Input } from 'antd';

import { useCallback, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { CHANGE_NICKNAME_REQUEST } from '../reducers/user';

const NicknameForm = () => {
    const { user } = useSelector(state => state.user);
    const [nickname, setNickname] = useState(user?.nickname || '');

    const onChangNickname = useCallback((e) => {
        setNickname(e.target.value);
    }, [nickname]);

    const { changeNicknameLoading } = useSelector(state => state.user);
    const id = useSelector(state => state.user.user?.id);
    const dispatch = useDispatch();
    const onSubmitForm = useCallback((nickname) => {
        console.log('..............onSubmitForm : ' + nickname);
        dispatch({
            type: CHANGE_NICKNAME_REQUEST,
            data: {
                userId: id,
                content: nickname
            }
        });
    });

    return (
        <Form
            onFinish={onSubmitForm}
            name='nickname'
        >
            <Input.Search
                addonBefore="닉네임"
                onChange={onChangNickname}
                onSearch={onSubmitForm}
                value={nickname}
                name='nickname'
                enterButton="수정"
                loading={changeNicknameLoading} />
        </Form>);
};

export default NicknameForm;