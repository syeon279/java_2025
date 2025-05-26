import { all, fork, take } from 'redux-saga/effects' // # 1.
import axios from 'axios';
import postSaga from './post';
import userSaga from './user';

axios.defaults.baseURL = 'http://localhost:3065'; //기본요청 url 설정
axios.defaults.withCredentials = true; // 쿠키 http요청에 포함시킬건지 설정
// 서버와의 인증정보를 유지

//// step1) all()
export default function* rootSaga() {
    yield all([// all - 동시에 배열로 받은 fork들을 동시에 실행해줌 
        fork(postSaga), // fork - generator 함수들을 실행해줌.
        fork(userSaga),
    ]);
}
