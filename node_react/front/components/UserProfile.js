import React, { useCallback } from 'react';
import { EditOutlined, EllipsisOutlined, SettingOutlined } from '@ant-design/icons';
import { Avatar, Card, Button } from 'antd';

const { Meta } = Card;

const UserProfile = ({ setIsLogin }) => {
    ///////////////////////////////////////////// code
    // 로그아웃버튼을 누르면 로그아웃되게 만들기
    const onLogOut = useCallback(() => {
        setIsLogin(false);
    }, []);
    ///////////////////////////////////////////// view
    return (
        <Card
            actions={[
                <div key="sns">게시글 <br /> 0 </div>,
                <div key="following">팔로잉 <br /> 0 </div>,
                <div key="follower">팔로워 <br /> 0 </div>,
            ]}
        >
            <Card.Meta
                avatar={<Avatar>TheJoa</Avatar>}
                title="TheJoa"
            />
            <Button style={{ marginTop: "10%" }} onClick={onLogOut} >로그아웃</Button>
        </Card>

    );
};

export default UserProfile;