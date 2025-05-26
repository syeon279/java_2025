import { all, put, fork, takeLatest, delay, throttle } from 'redux-saga/effects' // # 1.
import {
    generateDummyPost,
    LOAD_POSTS_REQUEST, LOAD_POSTS_SUCCESS, LOAD_POSTS_FAILURE,
    ADD_POST_REQUEST, ADD_POST_SUCCESS, ADD_POST_FAILURE,
    REMOVE_POST_REQUEST, REMOVE_POST_SUCCESS, REMOVE_POST_FAILURE,
    ADD_COMMENT_REQUEST, ADD_COMMENT_SUCCESS, ADD_COMMENT_FAILURE,
} from '../reducers/post';

//////
function loadPostApi(data) { // finction * 아님!
    return axios.get('/posts', data);
}

function* loadPost(action) {
    //const result = yield call(addpostApi, action.data); // 처리함수, 처리파라미터
    try {
        yield delay(500);
        yield put({
            type: LOAD_POSTS_SUCCESS,
            data: generateDummyPost(10),
        })

    } catch (error) {
        yield put({
            type: LOAD_POSTS_FAILURE,
            data: error.response.data
        })
    }
}
//////
function addPostApi(data) { // finction * 아님!
    return axios.POST('/post');
}

function* addPost(action) {
    //const result = yield call(addpostApi, action.data); // 처리함수, 처리파라미터
    try {
        yield delay(500);
        yield put({
            type: ADD_POST_SUCCESS,
            data: action.data
        })

    } catch (error) {
        yield put({
            type: ADD_POST_FAILURE,
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
        yield delay(500);
        yield put({
            type: REMOVE_POST_SUCCESS,
            data: action.data
        })

    } catch (error) {
        yield put({
            type: REMOVE_POST_FAILURE,
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
        yield delay(500);
        yield put({
            type: ADD_COMMENT_SUCCESS,
            data: action.data
        })

    } catch (error) {
        yield put({
            type: ADD_COMMENT_FAILURE,
            data: error.response.data
        })
    }
}

///step2) ACTION 기능추가
function* watchLoadPost() {
    yield throttle(4000, LOAD_POSTS_REQUEST, loadPost);
}
function* watchAddPost() {
    yield takeLatest(ADD_POST_REQUEST, addPost); // ver 2 -> 3번 요청 => 응답 1번
}

function* watchRemovePost() {
    yield takeLatest(REMOVE_POST_REQUEST, removePost);
}
function* watchAddComment() {
    yield takeLatest(ADD_COMMENT_REQUEST, addComment);
}

//// step1) all()
export default function* postSaga() {
    yield all([
        fork(watchAddPost),
        fork(watchRemovePost),
        fork(watchAddComment),
        fork(watchLoadPost),
    ]);
}