import React, { useState, useCallback, useRef, useEffect } from 'react';
import { Form, Input, Button } from 'antd';

// 1. ADD_POST_REQUEST 가져오기
import { ADD_POST_REQUEST } from '../reducers/post';

// 2. Dispatch 선언
import { useDispatch, useSelector } from 'react-redux';

import userInput from '../hooks/userInput';


const PostForm = () => {

    // 3. useSelect 이용해서 post (이미지)
    const { user } = useSelector(stat => stat.user);
    const { imagePaths, addPostLoading, addPostDone } = useSelector(state => state.post);
    const imageInput = useRef();

    const onClickImageUpload = useCallback(() => {
        if (imageInput.current) {
            imageInput.current.click();
        }
    }, [imageInput.current]);

    const [text, onChangText, setText] = userInput('');

    // 4. dispatch - submit 했을 때 addPosts (글)
    const dispatch = useDispatch();
    const onFormSubmit = useCallback((values) => {
        console.log(values);
        return dispatch({
            type: ADD_POST_REQUEST,
            data: values
        });
    }, [text]);

    // 5. 이벤트
    useEffect(() => {
        console.log('addPostDone : ' + addPostDone);
        if (addPostDone) {
            setText('');
        }
    }, [addPostDone]);

    return (
        <Form
            layout='vertical'
            style={{ margin: '3%' }}
            encType='multipart/form-data'
            onFinish={onFormSubmit}
        >
            <Form.Item label='' name='text'>
                <Input.TextArea placeholder='게시하실 글을 입력하세요.'
                    value={text}
                    onChange={onChangText}
                />
            </Form.Item>
            <Form.Item>
                <input type="file" name="image" multiple hidden ref={imageInput} style={{ display: 'none' }} />
                <Button onClick={onClickImageUpload}> 이미지 업로드 </Button>
                <Button type='primary'
                    htmlType='submit'
                    style={{ float: 'right', }}
                    loading={addPostLoading}
                >
                    POST
                </Button>
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