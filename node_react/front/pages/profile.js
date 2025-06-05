import React, { useState, useCallback, useEffect } from 'react';
import Head from 'next/head';
import { useSelector } from 'react-redux';
import Router from 'next/router';

import { LOAD_MY_INFO_REQUEST } from '../reducers/user';

import wrapper from '../store/configureStore';
import { END } from 'redux-saga';
import axios from 'axios';
import useSWR from 'swr';

import AppLayout from '../components/AppLayout'
import NickNameForm from '../components/NickNameForm';
import FollowList from '../components/FollowList';

const fatcher = (url) => axios.get(url, { withCredentials: true }).then(result => result.data);

//--
const Profile = () => {
  const { user } = useSelector(state => state.user);  // 중앙저장소 - user
  const [followersLimit, setFollowersLimit] = useState(3);  //3,6,9,12,,,,
  const [followingsLimit, setFollowingsLimit] = useState(3);  //3,6,9,,,,
  // const [followersData, setFollowersData] = useState([]);   // 
  // const [followingsData, setFollowingsData] = useState([]);
  // const [loading, setLoading] = useState(true);
  // const [error, setError] = useState(null);
  // 캐시된 데이터를 먼저 반환하고, 최신 데이터를 가져오기
  const { data: followersData, error: followerError } = useSWR(`http://localhost:3065/user/followers?limit=${followersLimit}`, fatcher);
  const { data: followingsData, error: followingError } = useSWR(`http://localhost:3065/user/followings?limit=${followingsLimit}`, fatcher);

  useEffect(() => { if (!(user && user.id)) { Router.push('/'); } }, [user && user.id]);
  /*
  useEffect(() => {
    //////////  axios
    const fetchData = async () => {
      try {
        setLoading(true);

        const followersResponse = await axios.get(`http://localhost:3065/user/followers?limit=${followersLimit}`, { withCredentials: true });
        const followingsResponse = await axios.get(`http://localhost:3065/user/followings?limit=${followingsLimit}`, { withCredentials: true });
        setFollowersData(followersResponse.data);
        setFollowingsData(followingsResponse.data);

      } catch (err) {
        setError(err);
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, [followersLimit, followingsLimit]);
  */

  const loadMoreFollowings = useCallback(() => { setFollowingsLimit(prev => prev + 3); }, []);
  const loadMoreFollowers = useCallback(() => { setFollowersLimit(prev => prev + 3); }, []);

  if (!user) { return ".... 내정보 로딩중   "; }
  if (followerError || followingError) {
    console.error(followerError || followingError);
    return <div>팔로잉/팔로워 로딩중 에러발생</div>;
  }

  return (
    <>
      <Head>
        <meta charSet="utf-8" />
        <title> Profile | TheJoa </title>
      </Head>
      <AppLayout>
        <NickNameForm />
        <FollowList header="팔로잉" data={followingsData} onClickMore={loadMoreFollowings}
          loading={!followersData && !followerError} />
        <FollowList header="팔로우" data={followersData} onClickMore={loadMoreFollowers}
          loading={!followersData && !followingError} />
      </AppLayout>
    </>
  );
}

//////////////////////////////////////////////////////////////////////////
export const getServerSideProps = wrapper.getServerSideProps(async (context) => {
  // 1. cookie 설정
  const cookie = context.req ? context.req.headers.cookie : '';
  //const cookie = context.req ?? '';
  axios.defaults.headers.Cookie = '';

  if (context.req && cookie) { axios.defaults.headers.Cookie = cookie; }

  // 2. redux 액션
  context.store.dispatch({ type: LOAD_MY_INFO_REQUEST });
  //context.store.dispatch({ type: LOAD_POSTS_REQUEST });
  context.store.dispatch(END);

  await context.store.sagaTask.toPromise();
});
//////////////////////////////////////////////////////////////////////////

export default Profile;
