/*import { all, put, fork, take, takeLatest, call } from 'redux-saga/effects' // # 1.


/// step3) 
/// 여기서부터
function loginApi() { // finction * 아님!
    return axios.post('/user/login', data);
}

function* login(action) {
    //const result = yield call(loginApi, action.data);
    try {
        yield delay(1000);
        yield put({
            type: 'LOG_IN_SUCCESS',
            data: action.data
        })

        console.log('..........saga')
    } catch (err) {
        yield put({
            type: 'LOG_IN_FAILURE',
            data: err.response.data
        })
        console.log('..........saga')
    }
}
/// 여기까지

function logoutApi() { // finction * 아님!
    return axios.POST('/user/logout');
}

function* logout(action) {
    //const result = yield call(logoutApi); // 처리함수, 처리파라미터
    try {
        yield delay(1000);
        yield put({
            type: 'LOG_OUT_SUCCESS',
            data: action.data
        })
        console.log('..........saga')

    } catch (error) {
        yield put({
            type: 'LOG_OUT_FAILURE',
            data: error.response.data
        })
        console.log('..........saga')
    }
}

///step2) ACTION 기능추가
function* watchLogin() {
    console.log('...........watchLogin : ' + watchLogin);
    yield takeLatest('LOG_IN_REQUEST', login); //LOG_IN 액션이 실행될 때 까지 기다리기
}

function* watchLogout() {
    yield takeLatest('LOG_OUT_REQUEST', logout);
}

//// step1) all()
export default function* userSaga() {
    console.log('🔥 userSaga 시작됨');
    yield all([// all - 동시에 배열로 받은 fork들을 동시에 실행해줌 
        fork(watchLogin), // fork - generator 함수들을 실행해줌.
        fork(watchLogout), // fork - generator 함수들을 실행해줌.
    ]);
}
*/

import { all, put, delay, fork, takeLatest } from 'redux-saga/effects'  //#1
///// step3) 
function loginApi(data) {   //★   function* (X)
    return axios.POST('/user/login', data);
}
function* login(action) {
    //const result = yield call( loginApi, action.data ); 처리함수, 처리파라미터
    try {

        yield delay(1000);
        yield put({
            type: 'LOG_IN_SUCCESS',
            data: action.data   // result.data
        })

        console.log('........ login success');
    } catch (error) {
        yield put({
            type: 'LOG_IN_FAILURE',
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
            type: 'LOG_OUT_SUCCESS',
            // data: result.data   // result.data
        })
    } catch (error) {
        yield put({
            type: 'LOG_OUT_FAILURE',
            data: error.response.data
        })
    }
}


///// step2) ACTION 기능추가
function* watchLogin() {
    yield takeLatest('LOG_IN_REQUEST', login);  //LOG_IN 액션이 실행될때까지 기다리기
}
function* watchLogout() {
    yield takeLatest('LOG_OUT_REQUEST', logout);

}

///// step1) all()
export default function* userSaga() {
    yield all([
        fork(watchLogin),
        fork(watchLogout),
    ]);
}