import React, { useCallback } from 'react';
import { Form, Input, Button } from 'antd';
import PropTypes from 'prop-types';
import userInput from '../hooks/userInput';
import { useSelector } from 'react-redux';

const CommentForm = ({ post }) => { //어떤 게시글에 대한 댓글
    /////////////////// code
    const { isLogin } = useSelector((state) => state.user);
    const [comment, onChangeComment] = userInput('');
    const onSubmitForm = useCallback((e) => {
        console.log("...........CommentForm :  " + post.id, comment);
    }, [comment]);
    /////////////////// view 
    return (
        <Form style={{ margin: '3%' }} onFinish={onSubmitForm}>
            <Form.Item>
                <Input.TextArea rows={2} value={comment} onChange={onChangeComment} placeholder='댓글을 적어주세요.'>
                </Input.TextArea>
            </Form.Item>
            <Form.Item>
                <Button type='primary' htmlType='submit' style={{ float: 'right', }}>댓글</Button>
            </Form.Item>
        </Form>
    );
};
CommentForm.prototype = {
    post: PropTypes.object.isRequired
};
export default CommentForm;