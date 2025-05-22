import React, { useState, useCallback, useMemo } from 'react';
import { Card, Avatar, Button, List, Popover, Comment } from 'antd';
import { EllipsisOutlined, HeartOutlined, HeartTwoTone, MessageOutlined, RetweetOutlined } from '@ant-design/icons';
import CommentForm from './CommentForm';
import PostImages from './PostImages';
import { useSelector } from 'react-redux';

const PostCard = ({ post }) => {
    ////////////////////////////////////// code
    const id = useSelector((state) => state.user.user?.id);
    //console.log(id);

    // 1. 좋아요 - false
    const [like, setLike] = useState(false);
    const onClickLike = useCallback((e) => {
        setLike((prev) => !prev);
    }, []);

    // 2. 댓글
    const [commentOpen, setCommentOpen] = useState(false);
    const showCommnet = useCallback((e) => {
        setCommentOpen((prev) => (!prev));
    })

    // styled
    const styleCommentFrom = useMemo(() => ({
        margin: '3%'
    }), []);
    ////////////////////////////////////// view
    return (
        <div style={styleCommentFrom}>
            <Card
                cover={
                    post.Images && post.Images.length > 0 &&
                    <PostImages images={post.Images} />
                }
                actions={[
                    like ?
                        <HeartTwoTone twoToneColor="#f00" key="heart" onClick={onClickLike} />
                        :
                        <HeartOutlined key="heart" onClick={onClickLike} />,

                    <RetweetOutlined key="retweet" />,
                    <MessageOutlined key="comment" onClick={showCommnet} />,
                    <Popover content={(
                        <Button.Group>
                            {id && id === post.User.id ?
                                (<>
                                    <Button>수정하기</Button>,
                                    <Button type='primary'>삭제하기</Button>
                                </>)
                                :
                                <Button type='danger'>신고</Button>
                            }
                        </Button.Group>
                    )}  >
                        <EllipsisOutlined />
                    </Popover>,
                ]}
            >
                <Card.Meta avatar={<Avatar>{post.User.nickname[0]}</Avatar>}
                    title={post.User.nickname}
                    description={post.content} />
            </Card>
            {
                commentOpen && (
                    <>
                        {/* 댓글폼 */}
                        <CommentForm post={post} />
                        {/* 댓글 리스트 */}
                        <List
                            header={`댓글`}
                            itemLayout='horizontal'
                            dataSource={post.Comments}
                            renderItem={
                                (item) => (
                                    <li>
                                        <Comment
                                            avatar={<Avatar>{item.User.nickname[0]}</Avatar>}
                                            content={item.content}
                                            author={item.User.nickname}
                                        />
                                    </li>
                                )
                            }
                        />
                    </>
                )
            }
        </div >
    );
};

export default PostCard;