import React, { useCallback } from 'react';
import { Avatar, Card, Button } from 'antd';
import styled from 'styled-components';
import { useDispatch, useSelector } from 'react-redux';
import { LOG_OUT_REQUEST } from '../reducers/user';

const ButtonWrapper = styled.div`
  margin-top: 10%;
`;

const UserProfile = () => {
    const dispatch = useDispatch();
    const { logOutLoading, user } = useSelector((state) => state.user); // Redux에서 유저 정보 직접 가져옴

    const onLogOut = useCallback(() => {
        dispatch({ type: LOG_OUT_REQUEST });
    }, [dispatch]);

    // 닉네임, 게시글 수, 팔로잉/팔로워 전부 Redux에서 바로 읽음
    const nickname = user?.nickname || '';
    const postCount = user?.Posts?.length || 0;
    const followingCount = user?.Followings?.length || 0;
    const followerCount = user?.Followers?.length || 0;

    return (
        <Card
            actions={[
                <div key="sns">게시글 <br /> {postCount}</div>,
                <div key="following">팔로잉 <br /> {followingCount}</div>,
                <div key="follower">팔로워 <br /> {followerCount}</div>,
            ]}
        >
            <Card.Meta
                avatar={<Avatar>{nickname[0] || '?'}</Avatar>}
                title={nickname}
            />
            <ButtonWrapper>
                <Button onClick={onLogOut} loading={logOutLoading}>
                    로그아웃
                </Button>
            </ButtonWrapper>
        </Card>
    );
};

export default UserProfile;
