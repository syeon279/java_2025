import React, { useState, useCallback, useEffect, useMemo } from 'react';
import PropTypes, { object } from 'prop-types';
import styled from 'styled-components';

import { Card, Avatar, Button, List, Comment, Popover } from 'antd';
import { MoreOutlined } from '@ant-design/icons';

import PostImages from './PostImages';
import PostCardContent from './PostCardContent';

import { useDispatch, useSelector } from 'react-redux';
import { REMOVE_POST_REQUEST, UPDATE_POST_REQUEST } from '../reducers/post';
import Link from 'next/Link';

const PostWrapper = styled.div`
  display: block;                 
  width: 100%;                    
  background: linear-gradient(to bottom, #ffffff,rgb(161, 217, 255)); 
  border-radius: 0px 30px 30px 30px;
  padding: 16px;
  position: relative;
  margin: 0 auto 24px auto;       
  box-sizing: border-box;
  border: 1px solid rgb(112, 112, 112);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);

}
`;


const PostCard = ({ post }) => {

  const me = useSelector((state) => state.user);
  console.log('me! : ', me);
  const { removePostLoading, removePostDone, } = useSelector(state => state.post);
  const dispatch = useDispatch();

  const styleAvatar = useMemo(() => ({
    width: 64,
    height: 64,
    fontSize: 24,
    border: '2px solid rgb(112, 112, 112)',
    boxShadow: '0 0 4px rgba(0,0,0,0.3)',
  }), []);

  ///////////////////////////////////////////////////// code

  //삭제
  const onRemovePost = useCallback(() => {
    dispatch({
      type: REMOVE_POST_REQUEST,
      data: post.id
    });
  }, []);

  // 수정
  const [editMode, setEditMode] = useState(false);
  const onClickUpdate = useCallback(() => {
    setEditMode(true);
  }, []);
  const onCancelUpdate = useCallback(() => {
    setEditMode(false);
  }, []);
  const onEditPost = useCallback((editText) => () => {
    console.log('📚 onEditPost : ', post.id, editText);
    dispatch({
      type: UPDATE_POST_REQUEST,
      data: { PostId: post.id, content: editText }
    });
  }, [post]); // 

  ///////////////////////////////////////////////////// view
  return (
    <PostWrapper>
      <Card style={{ backgroundColor: 'transparent', boxShadow: 'none', border: 'none' }}>
        <div style={{ display: 'flex', alignItems: 'flex-start', gap: '16px' }}>
          {post.Images && post.Images.length > 0 && (
            <div style={{ flex: '0 0 200px' }}>
              <PostImages images={post.Images} />
            </div>
          )}

          <div style={{ flex: 1, display: 'flex', flexDirection: 'row', gap: '12px', marginLeft: '3%' }}>
            <Avatar
              src='https://img3.tmon.kr/cdn4/deals/2024/06/25/27116047158/front_7cf4c_jujyg.jpg'
              style={styleAvatar}
            />
            <div style={{ display: 'flex', flexDirection: 'column', marginLeft: '2%' }}>
              <div style={{ fontSize: '18px', fontWeight: 'bold', marginBottom: '6px' }}>
                {post.User.nickname}
              </div>
              <PostCardContent
                editMode={editMode}
                onChangePost={onEditPost}
                onCancelUpdate={onCancelUpdate}
                postData={post.content}
              />
            </div>
          </div>

        </div>
      </Card>
    </PostWrapper>);
};

PostCard.propTypes = { post: PropTypes.object.isRequired };

export default PostCard;
//         