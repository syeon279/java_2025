import React from 'react';
import { Form, Input, Button } from 'antd';

const Comment = () => {
    return (
        <Form style={{ margin: '3%' }}>
            <Form.Item>
                <Input.TextArea placeholder='댓글을 적어주세요.'>

                </Input.TextArea>
            </Form.Item>
            <Form.Item>
                <Button type='primary' htmlType='submit' style={{ float: 'right', }}>댓글</Button>
            </Form.Item>
        </Form>
    );
};

export default Comment;