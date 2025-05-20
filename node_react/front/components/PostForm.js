import React from 'react';
import { Form, Input, Button } from 'antd';

const PostForm = () => {
    return (
        <Form layout='vertical' style={{ margin: '3%' }}>
            <Form.Item label='' name='text '>
                <Input.TextArea placeholder='게시하실 글을 입력하세요.' name='text' />
            </Form.Item>
            <Form.Item>
                <Input type="file" name="image" multiple hidden />
                <Button> 이미지 업로드 </Button>
                <Button type='primary' htmlType='submit' style={{ float: 'right', }}>POST</Button>
            </Form.Item>
        </Form>
    )
};

export default PostForm;