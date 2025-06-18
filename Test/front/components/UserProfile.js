import React, { useCallback, useEffect, useMemo } from 'react'
import { Card, Avatar, Button } from 'antd';
import styled from 'styled-components';
import { useDispatch, useSelector } from 'react-redux';
import Link from 'next/Link';

import { LOAD_MY_INFO_REQUEST } from '../reducers/user';

const UserProfile = ({ me }) => {
  console.log(me);
  const dispatch = useDispatch();

  ////////////////////////// code
  useEffect(() => {
    dispatch({ type: LOAD_MY_INFO_REQUEST });
  }, [dispatch]);

  const styleCard = useMemo(() => ({
    padding: '5%', borderRadius: '16px', margin: '2%',
    //backgroundColor: '#fff',
    boxShadow: '0 4px 12px rgba(0, 0, 0, 0.3)',
    background: 'linear-gradient(to bottom,rgb(255, 255, 255),rgb(250, 250, 250))',
    fontFamily: 'Ycomputer-Regular',
  }), []);

  const styleAvatar = useMemo(() => ({
    width: 64,
    height: 64,
    fontSize: 24,
    border: '2px solid rgb(112, 112, 112)',
    boxShadow: '0 0 4px rgba(0,0,0,0.3)',
  }), []);

  const styleBox = useMemo(() => ({
    border: '2px solidrgb(112, 112, 112)',
    //boxShadow: '0 0 4px rgba(0,0,0,0.3)',
  }), []);

  ////////////////////////// view
  return (
    <Card
      style={styleCard}
      actions={[
        <div key="sns" style={styleBox}>
          <span>게시글<br /> {me?.Posts ? me?.Posts.length : 0}</span>
        </div>
      ]}
    >
      <div style={{ display: 'flex', alignItems: 'center', gap: '16px' }}>
        <Avatar
          src='https://img3.tmon.kr/cdn4/deals/2024/06/25/27116047158/front_7cf4c_jujyg.jpg'
          style={styleAvatar}
        >
          {me?.nickname[0]}
        </Avatar>
        <div style={{ fontSize: '18px', }}>{me?.nickname}</div>
      </div>
    </Card>);
};

export default UserProfile;