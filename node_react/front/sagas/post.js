import { all, put, fork, take, takeLatest, delay } from 'redux-saga/effects' // # 1.

//////
function addPostApi(data) { // finction * 아님!
    return axios.POST('/post');
}

function* addPost(action) {
    //const result = yield call(addpostApi, action.data); // 처리함수, 처리파라미터
    try {
        yield delay(1000);
        yield put({
            type: 'ADD_POST_SUCCESS',
            data: action.data
        })

    } catch (error) {
        yield put({
            type: 'ADD_POST_FAILURE',
            data: error.response.data
        })
    }
}

//////
function removePostApi(data) { // finction * 아님!
    return axios.POST('/post');
}

function* removePost(action) {
    //const result = yield call(addpostApi, action.data); // 처리함수, 처리파라미터
    try {
        yield delay(1000);
        yield put({
            type: 'REMOVE_POST_SUCCESS',
            data: action.data
        })

    } catch (error) {
        yield put({
            type: 'REMOVE_POST_FAILURE',
            data: error.response.data
        })
    }
}

function addCommentApi(data) { // finction * 아님!
    return axios.POST('/post/comment');
}

function* addComment(action) {
    //const result = yield call(addpostApi, action.data); // 처리함수, 처리파라미터
    try {
        yield delay(1000);
        yield put({
            type: 'ADD_COMMENT_SUCCESS',
            data: action.data
        })

    } catch (error) {
        yield put({
            type: 'ADD_COMMENT_FAILURE',
            data: error.response.data
        })
    }
}

///step2) ACTION 기능추가
function* watchAddPost() {
    //yield take('ADD_POST', addpost);    // ver 1 -> take는 일회용 - 로그인 1번, 게시글도 1번만
    yield takeLatest('ADD_POST_REQUEST', addPost); // ver 2 -> 3번 요청 => 응답 1번
    // yield throttle('ADD_POST', addpost, 10000); // ver 3 -> 몇초뒤에 실행, 시간 설정 가능 - 10초 뒤에 
}

function* watchRemovePost() {
    yield takeLatest('REMOVE_POST_REQUEST', removePost);
}
function* watchAddComment() {
    yield takeLatest('ADD_COMMENT_REQUEST', addComment);
}

//// step1) all()
export default function* postSaga() {
    yield all([
        fork(watchAddPost),
        fork(watchRemovePost),
        fork(watchAddComment),
    ]);
}