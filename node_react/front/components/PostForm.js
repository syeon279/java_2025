import React, { useState, useCallback, useRef } from 'react';
import { Form, Input, Button } from 'antd';
// 1. useDispatch
import { useDispatch, useSelector } from 'react-redux';
// 2. addPost
import { addPost } from '../reducers/post'

const PostForm = () => {
    // 3. useSelect 이용해서 post (이미지)
    const { imagePaths } = useSelector(state => state.post);
    const imageInput = useRef();
    const onClickImageUpload = useCallback(() => {
        if (imageInput.current) {
            imageInput.current.click();
        }
    }, [imageInput.current]);

    // 4. dispatch - submit 했을 때 addPosts (글)
    const dispatch = useDispatch();
    const [text, setText] = useState('');
    const onChangText = useCallback((e) => {
        console.log(".........." + e.target.value);
        setText(e.target.value);
    }, []);
    const onFormSubmit = useCallback(() => {
        dispatch(addPost);
        setText('');
    }, []);

    // 5. 이벤트

    return (
        <Form
            layout='vertical'
            style={{ margin: '3%' }}
            encType='multipart/form-data'
            onFinish={onFormSubmit}>
            <Form.Item label='' name='text '>
                <Input.TextArea placeholder='게시하실 글을 입력하세요.' name='text' onChange={onChangText} />
            </Form.Item>
            <Form.Item>
                <input type="file" name="image" multiple hidden ref={imageInput} style={{ display: 'none' }} />
                <Button onClick={onClickImageUpload}> 이미지 업로드 </Button>
                <Button type='primary' htmlType='submit' style={{ float: 'right', }}>POST</Button>
            </Form.Item>
            <div>
                {imagePaths.map((v, i) => (
                    <div key={v}>
                        <img src={v} style={{ width: '200px' }} />
                        <div><Button>제거</Button></div>
                    </div>
                ))}
            </div>
        </Form>
    )
};

export default PostForm;