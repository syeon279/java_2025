import React, { useState, useCallback, useMemo, useEffect } from 'react';
import { Card, Avatar, Button, List, Popover, Comment } from 'antd';
import { EllipsisOutlined, HeartOutlined, HeartTwoTone, MessageOutlined, RetweetOutlined } from '@ant-design/icons';
import CommentForm from './CommentForm';
import PostImages from './PostImages';
import { useSelector, useDispatch, } from 'react-redux';

import { REMOVE_POST_REQUEST } from '../reducers/post';

const PostCard = ({ post }) => {
    const id = useSelector((state) => state.user.user?.id);
    const { removePostLoading, removePostDone } = useSelector(state => state.post);
    const dispatch = useDispatch();

    const onRemoveClick = useCallback(() => {
        dispatch({
            type: REMOVE_POST_REQUEST,
            data: {
                postId: post.id
            }
        })
    });

    //               code
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

    useEffect(() => {
        console.log('removePostDone : ' + removePostDone);
        if (removePostDone) { console.log('게시글을 삭제했습니다.'); }
    }, [removePostDone]);
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
                                    <Button type='primary' loading={removePostLoading} onClick={onRemoveClick}>삭제하기</Button>
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
                            header={`${post.Comments.length} 댓글`}
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