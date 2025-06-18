import React, { useCallback, useState, useRef, useEffect, useMemo } from 'react';  //##
import { Form, Input, Button } from 'antd';
import styled from 'styled-components';

import { useDispatch, useSelector } from 'react-redux';
import { ADD_POST_REQUEST, REMOVE_IMAGE, UPLOAD_IMAGES_REQUEST } from '../reducers/post';  //##
import userInput from '../hooks/userInput';


const FormWrapper = styled.div`
  display: block;                 
  width: 100%;                    
  background: linear-gradient(to bottom, #ffffff,#a4ff9f); 
  border-radius: 20px 0px 20px 20px;
  padding: 16px;
  position: relative;
  margin: 0 auto 24px auto;       
  box-sizing: border-box;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
  border: 1px solid rgb(112, 112, 112);

}
`;

const PostForm = () => {
  const { imagePaths, addPostLoading, addPostDone } = useSelector((state) => state.post);
  const dispatch = useDispatch();
  const [text, onChangeText, setText] = userInput('');

  useEffect(() => {
    if (addPostDone) { setText(''); }
  }, [addPostDone]);

  const onSubmitForm = useCallback(() => {
    if (!text || !text.trim()) { return alert('게시글을 작성하세요.'); }
    const formData = new FormData();
    imagePaths.forEach((i) => { formData.append('image', i) });
    formData.append('content', text);

    dispatch({
      type: ADD_POST_REQUEST,
      data: formData   // text    
    });
  }, [text, imagePaths]);

  const imageInput = useRef();
  const onClickImageUpload = useCallback(() => {
    imageInput.current.click();
  }, [imageInput.current]);

  const onChangeImage = useCallback((e) => {
    console.log('..... images', e.target.files);
    const imageFormData = new FormData();
    [].forEach.call(e.target.files, (f) => {
      imageFormData.append('image', f);
    });
    dispatch({
      type: UPLOAD_IMAGES_REQUEST,
      data: imageFormData,
    });
  }, []);

  const onRemoveImage = useCallback((index) => () => {
    dispatch({
      type: REMOVE_IMAGE,
      data: index
    })
  }, []);

  ///
  const box = useMemo(() => ({
    padding: '5%', borderRadius: '16px', margin: '2%',
    //boxShadow: '0 4px 12px rgba(0, 0, 0, 0.3)',
    //background: 'linear-gradient(to bottom,rgb(255, 255, 255),rgb(250, 250, 250))',
    fontFamily: 'Ycomputer-Regular',
  }), []);

  const imageButton = useMemo(() => ({
    borderRadius: '16px',
    //boxShadow: '0 4px 12px rgba(0, 0, 0, 0.3)',
    background: 'linear-gradient(to bottom,rgb(255, 255, 255),rgb(241, 241, 241))',
    fontFamily: 'Ycomputer-Regular',
  }), []);

  const postButton = useMemo(() => ({
    borderRadius: '16px',
    //boxShadow: '0 4px 12px rgba(0, 0, 0, 0.3)',
    background: 'linear-gradient(to bottom,rgb(255, 255, 255),rgb(133, 207, 250))',
    fontFamily: 'Ycomputer-Regular',
    float: 'right',
  }), []);

  return (
    <FormWrapper>
      <Form layout="vertical" style={{ padding: '2%' }}
        encType="multipart/form-data" onFinish={onSubmitForm} >
        <Form.Item >
          <Input.TextArea placeholder='게시글을 적어주세요'
            maxLength={200} value={text} onChange={onChangeText} style={box} />
        </Form.Item>
        <Form.Item>
          <input type="file" name="image" multiple hidden ref={imageInput} style={{ display: 'none' }}
            onChange={onChangeImage} />
          <Button onClick={onClickImageUpload} style={imageButton}>이미지업로드</Button>
          <Button style={postButton}
            htmlType='submit' loading={addPostLoading} >POST</Button>
        </Form.Item>
        <div>
          {Array.isArray(imagePaths) ? imagePaths.map((v, i) => (
            <div key={v} style={{ display: 'inline-block' }} >
              <img src={`http://localhost:3065/${v}`} style={{ width: '200px' }} />
              <div><Button onClick={onRemoveImage(i)} style={box}>제거</Button></div>
            </div>
          )) : null}
        </div>
      </Form>
    </FormWrapper>
  );
};

export default PostForm;