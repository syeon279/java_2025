import React from 'react';
import { Card, Avatar, Button, List, Popover } from 'antd';
import { EllipsisOutlined, HeartOutlined, MessageOutlined, RetweetOutlined } from '@ant-design/icons';
import Comment from '../components/Comment';
import PostImages from './PostImages';

const PostCard = ({ post }) => {
    return (
        <div style={{ margin: '3%' }}>
            <Card
                cover={
                    post.Images && post.Images.length > 0 &&
                    <PostImages images={post.Images} />
                }
                actions={[
                    <HeartOutlined />,
                    <RetweetOutlined />,
                    <Popover content={(
                        <Comment />
                    )}>
                        <MessageOutlined />
                    </Popover>,
                    <Popover content={(
                        <Button.Group>
                            <Button>수정하기</Button>
                            <Button type='primary'>삭제하기</Button>
                        </Button.Group>
                    )}  >
                        <EllipsisOutlined />
                    </Popover>,
                ]}
            >
                <Card.Meta avatar={<Avatar>{post.User.nickname[0]}</Avatar>} title={post.User.nickname} description={post.content} />
            </Card>
            <Comment />
            <div>
                0 댓글
            </div>
        </div>
    );
};

export default PostCard;