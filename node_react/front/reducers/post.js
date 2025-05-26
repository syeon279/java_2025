// [reducers] - post.js
import shortid from 'shortid';
import produce from 'immer';
import { faker } from '@faker-js/faker';
faker.seed(123);
import axios from 'axios';

export const initialState = {
    mainPosts: [],
    /////////////////////////// 추가 START
    //postAdd:false,
    imagePaths: [],
    hasMorePosts: true,

    loadPostsLoading: false,
    loadPostsDone: false,
    loadPostsError: null,

    addPostLoading: false,
    addPostDone: false,
    addPostError: null,

    removePostLoading: false,
    removePostDone: false,
    removePostError: null,

    addCommentLoading: false,
    addCommentDone: false,
    addCommentError: null,
    /////////////////////////// 추가 END


}

export const LOAD_POSTS_REQUEST = 'LOAD_POSTS_REQUEST';
export const LOAD_POSTS_SUCCESS = 'LOAD_POSTS_SUCCESS';
export const LOAD_POSTS_FAILURE = 'LOAD_POSTS_FAILURE';

export const ADD_POST_REQUEST = 'ADD_POST_REQUEST';
export const ADD_POST_SUCCESS = 'ADD_POST_SUCCESS';
export const ADD_POST_FAILURE = 'ADD_POST_FAILURE';

export const REMOVE_POST_REQUEST = 'REMOVE_POST_REQUEST';
export const REMOVE_POST_SUCCESS = 'REMOVE_POST_SUCCESS';
export const REMOVE_POST_FAILURE = 'REMOVE_POST_FAILURE';

export const ADD_COMMENT_REQUEST = 'ADD_COMMENT_REQUEST';
export const ADD_COMMENT_SUCCESS = 'ADD_COMMENT_SUCCESS';
export const ADD_COMMENT_FAILURE = 'ADD_COMMENT_FAILURE';


//          dummyPost
const dummyPost = (data) => ({
    //id: 2,
    id: shortid.generate(),
    content: data.text,
    User: {
        id: 1,
        nickname: 'Dan'
    },
    Images: [],
    Comments: []
})
//          E: dummyPost

const dummyComment = (data) => ({
    //id: 3,
    id: shortid.generate(),
    content: data,
    User: {
        id: 1,
        nickname: 'Dan'
    }
})
// 10개씩 무한스크롤 부르는 메서드
export const generateDummyPost = (number) =>
    Array(number)
        .fill()
        .map(() => ({
            id: shortid.generate(),
            User: { id: shortid.generate(), nickname: faker.internet.userName() },
            content: faker.lorem.paragraph(),
            Images: [{ src: faker.image.avatar() }],
            Comments: [
                {
                    id: shortid.generate(),
                    User: { id: shortid.generate(), nickname: faker.internet.userName() },
                    content: faker.lorem.sentence(),
                },
            ],
        }));



///
const reducer = (state = initialState, action) => produce(state, (draft) => {
    switch (action.type) {
        // ADD
        case LOAD_POSTS_REQUEST:
            draft.loadPostsLoading = true;
            draft.loadPostsDone = false;
            draft.loadPostsError = null;
            break;

        case LOAD_POSTS_SUCCESS:
            draft.loadPostsLoading = false;
            draft.loadPostsDone = true;
            draft.mainPosts = action.data.concat(draft.mainPosts);
            console.log('........mainPosts : ', action.data.concat(draft.mainPosts).length);
            draft.hasMorePosts = draft.mainPosts.length < 50; // 게시글 50개 부근 보이게 체크
            break;

        case LOAD_POSTS_FAILURE:
            draft.loadPostsLoading = false;
            draft.loadPostsError = action.error;

        // ADD
        case ADD_POST_REQUEST:
            draft.addPostLoading = true;
            draft.addPostDone = false;
            draft.addPostError = null;
            break;

        case ADD_POST_SUCCESS:
            draft.addPostLoading = false;
            draft.addPostDone = true;
            draft.mainPosts.unshift(dummyPost(action.data));
            break;

        case ADD_POST_FAILURE:
            draft.addPostLoading = false;
            draft.addPostError = action.error;
            break;

        ////        REMOVE
        case REMOVE_POST_REQUEST:
            draft.removePostLoading = true;
            draft.removePostDone = false;
            draft.removePostError = null;
            break;

        case REMOVE_POST_SUCCESS:
            draft.mainPosts = draft.mainPosts.filter(v => v.id !== action.data.postId);
            draft.removePostLoading = false;
            draft.removePostDone = true;
            break;

        case REMOVE_POST_FAILURE:
            draft.removePostLoading = false;
            draft.removePostError = action.error;
            break;

        ///         COMMENT
        case ADD_COMMENT_REQUEST:
            draft.addCommentLoading = true;
            draft.addCommentDone = false;
            draft.addCommentError = null;
            break;

        case ADD_COMMENT_SUCCESS:
            //1. postIndex 해당글 가져오기
            const post = draft.mainPosts.find((v) => v.id === action.data.postId);

            //2. post.Comment
            post.Comments.unshift(dummyComment(action.data.content));
            draft.addCommentLoading = false;
            draft.addCommentDone = true;
            break;

        case ADD_COMMENT_FAILURE:
            draft.addCommentLoading = false;
            draft.addCommentError = action.error;
            break;

        ///
        default: {
            break;
        }
    }


});

export default reducer;