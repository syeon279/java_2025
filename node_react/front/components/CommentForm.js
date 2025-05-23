import React, { useCallback, useEffect } from 'react';
import { Form, Input, Button } from 'antd';
import PropTypes from 'prop-types';
import userInput from '../hooks/userInput';

import { ADD_COMMENT_REQUEST } from '../reducers/post';
import { useSelector, useDispatch } from 'react-redux';

const CommentForm = ({ post }) => { //어떤 게시글에 대한 댓글
    /////////////////// code
    const id = useSelector((state) => state.user.user?.id);
    const { addCommentLoading, addCommentDone } = useSelector((state) => state.post);
    const [comment, onChangeComment, setComment] = userInput('');

    const dispatch = useDispatch();
    const onSubmitForm = useCallback((e) => {
        console.log("...........CommentForm :  " + post.id, comment);
        return dispatch({
            type: ADD_COMMENT_REQUEST,
            data: {
                userId: id,
                postId: post.id,
                content: comment
            }
        });
    }, [comment]);

    useEffect(() => {
        if (addCommentDone) {
            setComment('');
        }
    }, [addCommentDone]);

    /////////////////// view 
    return (
        <Form style={{ margin: '3%' }} onFinish={onSubmitForm}>
            <Form.Item>
                <Input.TextArea rows={2}
                    name='comment'
                    value={comment}
                    onChange={onChangeComment}
                    placeholder='댓글을 적어주세요.'
                >
                </Input.TextArea>
            </Form.Item>
            <Form.Item>
                <Button type='primary'
                    htmlType='submit'
                    style={{ float: 'right', }}
                    loading={addCommentLoading}
                >댓글</Button>
            </Form.Item>
        </Form>
    );
};
CommentForm.prototype = {
    post: PropTypes.object.isRequired
};
export default CommentForm;