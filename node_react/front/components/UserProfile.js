import React, { useCallback } from 'react';
import { EditOutlined, EllipsisOutlined, SettingOutlined } from '@ant-design/icons';
import { Avatar, Card, Button } from 'antd';
import styled from 'styled-components';

//import { logoutAction } from '../reducers/user'; //#1. redux
import { useDispatch, useSelector } from 'react-redux';  //#2. redux
import { LOG_OUT_REQUEST } from '../reducers/user';

const ButtonWrapper = styled.div`
    margin-top:10%;
`;

//const UserProfile = ({ setIsLogin }) => {
const UserProfile = () => {  //#3. redux

    const { logOutLoading, user } = useSelector((state) => state.user); // ##redux 2
    console.log('.....user.nickname : ' + user.nickname);
    //              code
    const dispatch = useDispatch();  //#4. redux
    // 로그아웃버튼을 누르면 로그아웃되게 만들기
    const onLogOut = useCallback(() => {
        //dispatch(logoutAction);  //#5. redux
        dispatch({
            type: LOG_OUT_REQUEST
        })
    }, []);
    //               view
    return (
        <Card
            actions={[
                <div key="sns">게시글 <br /> {user.Posts ? user.Posts.length : 0}</div>,
                <div key="following">팔로잉 <br /> {user.Follwings ? user.Follwings.length : 0} </div>,
                <div key="follower">팔로워 <br /> {user.Followers ? user.Followers.length : 0} </div>,
            ]}
        >
            <Card.Meta
                avatar={<Avatar>{user.nickname?.[0] || '?'}</Avatar>}
                title={user.nickname}
            />
            <ButtonWrapper>
                <Button onClick={onLogOut} loading={logOutLoading}>로그아웃</Button>
            </ButtonWrapper>
        </Card>

    );
};

export default UserProfile;