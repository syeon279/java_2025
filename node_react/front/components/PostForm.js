import React, { useState, useCallback, useRef, useEffect } from 'react';
import { Form, Input, Button } from 'antd';
import { call } from 'redux-saga/effects';

import { REMOVE_IMAGE, UPLOAD_IMAGES_REQUEST } from '../reducers/post';

// 1. ADD_POST_REQUEST 가져오기
import { ADD_POST_REQUEST } from '../reducers/post';

// 2. Dispatch 선언
import { useDispatch, useSelector } from 'react-redux';

import userInput from '../hooks/userInput';


const PostForm = () => {

    // 3. useSelect 이용해서 post (이미지)
    const { user } = useSelector(stat => stat.user);
    const { imagePaths, addPostLoading, addPostDone } = useSelector(state => state.post);


    // 4. dispatch - submit 했을 때 addPosts (글)
    const dispatch = useDispatch();
    const [text, onChangText, setText] = userInput('');

    useEffect(() => {
        console.log('🔥 addPostDone:', addPostDone);
        if (addPostDone) {
            setText('');
        }
    }, [addPostDone]);

    const onFormSubmit = useCallback(() => {
        // 1. 글 있는지 확인
        if (!text || !text.trim()) {
            return alert('게시글을 확인해주세요');
        }
        // 2. content - text
        // 3. image - 이미지도 있다면
        const formData = new FormData();
        imagePaths.forEach((i) => {
            formData.append('image', i)
        });
        formData.append('content', text)

        console.log(text);

        return dispatch({
            type: ADD_POST_REQUEST,
            data: formData
        });
    }, [text, imagePaths]);

    //5. 이미지 업로드 - UPLOAD_IMAGES_REQUEST
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
    }, []);  //## 

    const onRemoveImage = useCallback((index) => () => {
        dispatch({
            type: REMOVE_IMAGE,
            data: index
        })
    }, []);  //##

    return (
        <Form
            layout='vertical'
            style={{ margin: '3%' }}
            encType='multipart/form-data'
            onFinish={onFormSubmit}
        >
            <Form.Item label=''>
                <Input.TextArea placeholder='게시하실 글을 입력하세요.'
                    value={text}
                    name='text'
                    onChange={onChangText}
                />
            </Form.Item>
            <Form.Item>
                <input type="file" name="image" multiple hidden ref={imageInput}
                    style={{ display: 'none' }} onChange={onChangeImage} />
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
                {Array.isArray(imagePaths) ? imagePaths.map((v, i) => (
                    <div key={`v`} style={{ display: 'inline-block' }}>
                        <img src={`http://localhost:3065/${v}`} style={{ width: '200px' }} />
                        <div><Button onClick={onRemoveImage(i)}>제거</Button></div>
                    </div>
                )) : null}
            </div>
        </Form>
    )
};

export default PostForm;

/*
import React, { useCallback, useState, useRef , useEffect} from 'react';  //##
import { Form, Input, Button } from 'antd';

//1. useDispatch , useSelector
//2. addPost
import { useDispatch, useSelector } from 'react-redux';
import { ADD_POST_REQUEST , REMOVE_IMAGE, UPLOAD_IMAGES_REQUEST  } from '../reducers/post';  //##
import userInput from '../hooks/userInput';  

const PostForm = () => { 
  //3. useSelect 이용해서 post ( 이미지 )
  const { imagePaths , addPostLoading, addPostDone } = useSelector((state) => state.post);


  //4. dispatch - submit  ( 글 )
  const dispatch = useDispatch();
  const [text, onChangeText, setText] = userInput(''); 

  useEffect(() => { 
    if (addPostDone) { setText('');  }
  } , [addPostDone]);
 
  const onSubmitForm = useCallback(() => {
    //1. 글있는지 확인
    if (!text || !text.trim()) { return alert('게시글을 작성하세요.');  }
    //2. content - text
    //3. image   - 이미지도 있다면  
    const formData = new FormData();
    imagePaths.forEach(( i ) => { formData.append('image' , i) });
    formData.append('content', text);
    
    dispatch({
      type: ADD_POST_REQUEST,
      data: formData   // text    
    });
  }, [text ,imagePaths ]);
   
  //5. 이미지 업로드 - UPLOAD_IMAGES_REQUEST
  const imageInput = useRef();
  const onClickImageUpload = useCallback(() => {
      imageInput.current.click();
  }, [imageInput.current]);
  
  const onChangeImage = useCallback((e) => { 
    console.log('..... images'  , e.target.files);
    const imageFormData = new FormData();
    [].forEach.call(e.target.files, (f) => { 
      imageFormData.append( 'image' , f );
    });
    dispatch({
      type: UPLOAD_IMAGES_REQUEST,
      data: imageFormData,
    });
  }, []);  //## 
  
  const onRemoveImage = useCallback((index) => ()=> {   
    dispatch({
      type: REMOVE_IMAGE, 
      data: index
    })
  },[]);  //##

  return (<Form layout="vertical" style={{ margin: '3%' }}
    encType="multipart/form-data" onFinish={onSubmitForm} >
    <Form.Item  label="TheJoa Write" >  
      <Input.TextArea placeholder='게시글을 적어주세요'
        maxLength={200} value={text} onChange={onChangeText} />
    </Form.Item>
    <Form.Item>
      <input type="file" name="image" multiple hidden ref={imageInput} style={{ display: 'none' }}
        onChange={onChangeImage} />
      <Button onClick={onClickImageUpload} >이미지업로드</Button>
      <Button type="primary" style={{ float: 'right' }}
          htmlType='submit'  loading={addPostLoading}>POST</Button>
    </Form.Item> 
    <div>
      { Array.isArray( imagePaths ) ? imagePaths.map((v, i) => (
        <div key={v} style={{display: 'inline-block'}} >
          <img src={`http://localhost:3065/${v}`} style={{ width: '200px' }} />
          <div><Button  onClick={onRemoveImage(i)}>제거</Button></div>
        </div>
      )) : null }
    </div>
  </Form>);
};

export default PostForm;
*/