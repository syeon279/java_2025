import { func } from 'prop-types';
import { all, put, delay, fork, takeLatest } from 'redux-saga/effects'  //#1
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
    return axios.POST('/user/login', data);
}
function* login(action) {
    //const result = yield call( loginApi, action.data ); 처리함수, 처리파라미터
    try {

        yield delay(1000);
        yield put({
            type: LOG_IN_SUCCESS,
            data: action.data   // result.data
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



//--
function logoutApi() {   //★   function* (X)
    return axios.POST('/user/logout');
}
function* logout() {
    //const result = yield call( logoutApi); 처리함수, 처리파라미터
    try {
        yield delay(1000);
        yield put({
            type: LOG_OUT_SUCCESS,
        })
    } catch (error) {
        yield put({
            type: LOG_OUT_FAILURE,
            data: error.response.data
        })
    }
}



// siguup
function signUpApi() {   //★   function* (X)
    return axios.POST('/user/');
}
function* signUp(action) {
    //const result = yield call( signUpApi); 처리함수, 처리파라미터
    try {
        yield delay(1000);
        yield put({
            type: SIGN_UP_SUCCESS,
            data: action.data   // result.data
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
    return axios.POST('/user/');
}

function* changeNickname(action) {
    //const result = yield call( changeNicknameApi); 처리함수, 처리파라미터
    try {
        yield delay(1000);
        yield put({
            type: CHANGE_NICKNAME_SUCCESS,
            data: action.data   // result.data
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
    console.log('🔥 userSaga 시작됨');
    yield all([
        fork(watchLogin),
        fork(watchLogout),
        fork(watchSignup),
        fork(watchChangeNickname),
    ]);
}