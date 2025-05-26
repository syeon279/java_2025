import { func } from 'prop-types';
import { all, put, delay, fork, takeLatest, call, actionChannel } from 'redux-saga/effects'  //#1
import axios from 'axios';
import {
    LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_IN_FAILURE,
    LOG_OUT_REQUEST, LOG_OUT_SUCCESS, LOG_OUT_FAILURE,
    SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAILURE,
    CHANGE_NICKNAME_REQUEST, CHANGE_NICKNAME_SUCCESS, CHANGE_NICKNAME_FAILURE,
    FOLLOW_REQUEST, FOLLOW_SUCCESS, FOLLOW_FAILURE,
    UFOLLOW_REQUEST, UFOLLOW_SUCCESS, UFOLLOW_FAILURE
} from '../reducers/user';



///// step3) 
function loginApi(data) {   //★   function* (X)
    return axios.post('/users/login', data);
}
function* login(action) {
    try {
        const result = yield call(loginApi, action.data);
        //yield delay(500);
        yield put({
            type: LOG_IN_SUCCESS,
            data: result.data   // result.data
        })

        console.log('........ login success');
    } catch (error) {
        yield put({
            type: LOG_IN_FAILURE,
            data: error.response.data
        })
        console.log('........ login error');
    }
}



//logout
function logoutApi() {   //★   function* (X)
    return axios.post('/users/logout');
}
function* logout() {
    try {
        const result = yield call(logoutApi);
        yield put({
            type: LOG_OUT_SUCCESS,
        })
    } catch (error) {
        yield put({
            type: LOG_OUT_FAILURE,
            error: error.response?.data || error.message || 'Unknown error',
        })
    }
}



// siguUp
function signUpApi(data) {   //★   function* (X)
    console.log('signUpApi : ' + data)
    return axios.post('/users/', data);
}
function* signUp(action) {
    try {
        const result = yield call(signUpApi, action.data);
        yield put({
            type: SIGN_UP_SUCCESS,
            data: result.data
        })
    } catch (error) {
        yield put({
            type: SIGN_UP_FAILURE,
            data: error.response.data
        })
    }
}

// change nickname
function changeNicknameApi() {   //★   function* (X)
    return axios.post('/users/nickname');
}

function* changeNickname(action) {
    try {
        const result = yield call(changeNicknameApi);
        yield put({
            type: CHANGE_NICKNAME_SUCCESS,
            data: result.data
        })
    } catch (error) {
        yield put({
            type: CHANGE_NICKNAME_FAILURE,
            data: error.response.data
        })
    }
}


///// step2) ACTION 기능추가
function* watchLogin() {
    yield takeLatest(LOG_IN_REQUEST, login);  //LOG_IN 액션이 실행될때까지 기다리기
}
function* watchLogout() {
    yield takeLatest(LOG_OUT_REQUEST, logout);

}
function* watchSignup() {
    yield takeLatest(SIGN_UP_REQUEST, signUp); // 요청이 10번이라도 응답은 1번
}

function* watchChangeNickname() {
    yield takeLatest(CHANGE_NICKNAME_REQUEST, changeNickname);
}


///// step1) all()
export default function* userSaga() {
    yield all([
        fork(watchLogin),
        fork(watchLogout),
        fork(watchSignup),
        fork(watchChangeNickname),
    ]);
}