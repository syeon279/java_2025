// [reducers] - post.js
import shortid from 'shortid';

export const initialState = {
    mainPosts: [{
        id: 1,
        User: { id: 2, nickname: 'YSH' },
        content: '첫번째 게시글 #node #react',
        Images: [
            { id: shortid.generate(), src: 'https://www.fitpetmall.com/wp-content/uploads/2022/11/shutterstock_196467692-1024x819.jpg' },
            { id: shortid.generate(), src: 'https://www.gklibrarykor.com/wp-content/uploads/2024/08/1_%EA%B0%95%EC%95%84%EC%A7%80%EC%9D%98-%EC%8B%A0%EC%B2%B4%EC%A0%81-%ED%8A%B9%EC%A7%95.jpg' },
            { id: shortid.generate(), src: 'https://banulpattern.com/cdn/shop/products/IMG_7557.jpg?v=1636425784&width=1946' },
        ],
        Comments: [{
            id: shortid.generate(),
            User: {
                id: shortid.generate(),
                nickname: 'Dan'
            },
            content: 'ㅋㅋㅋ'
        }, {
            User: {
                id: shortid.generate(),
                nickname: 'sen'
            },
            content: 'Hi'
        }]

    }],
    //postAdd: false,
    //imagePaths: [],
    /////////////////////////// 추가 START
    //postAdd: false,
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

export const LOAD_POST_REQUEST = 'LOAD_POST_REQUEST';
export const LOAD_POST_SUCCESS = 'LOAD_POST_SUCCESS';
export const LOAD_POST_FAILURE = 'LOAD_POST_FAILURE';

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
    content: data,
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

export default (state = initialState, action) => {
    switch (action.type) {
        case ADD_POST_REQUEST:
            return {
                ...state,
                addPostLoading: true,
                addPostDone: false,
            }
        case ADD_POST_SUCCESS:
            console.log('ADD_POST_SUCCESS : ' + action.data.content)
            return {
                ...state,
                mainPosts: [dummyPost(action.data.content), ...state.mainPosts],
                addPostLoading: false,
                addPostDone: true,
            }
        case ADD_POST_FAILURE:
            return {
                ...state,
                addPostLoading: false,
                addPostError: action.error,
            }

        //      REMOVE
        case REMOVE_POST_REQUEST:
            return {
                ...state,
                removePostLoading: true,
                removePostDone: false,
                removePostError: null,
            }
        case REMOVE_POST_SUCCESS:
            console.log('REMOVE_POST_SUCCESS : ', action.data)
            return {
                ...state,
                mainPosts: state.mainPosts.filter(v => v.id !== action.data.postId),
                removePostLoading: false,
                removePostDone: true,
            }
        case REMOVE_POST_FAILURE:
            return {
                ...state,
                removePostLoading: false,
                removePostError: action.error,
            }

        //      comment
        case ADD_COMMENT_REQUEST:
            return {
                ...state,
                addCommentLoading: true,
                addCommentDone: false,
            }
        case ADD_COMMENT_SUCCESS:
            //1. postIndex 해당글 가져오기
            const postIndex = state.mainPosts.findIndex((v) => v.id === action.data.postId);
            const post = { ...state.mainPosts[postIndex] };
            //2. post.Comment
            post.Comments = [dummyComment(action.data.content), ...post.Comments];
            //3. mainPosts 추가
            const mainPosts = [...state.mainPosts];
            mainPosts[postIndex] = post;
            return {
                ...state,
                mainPosts,
                addCommentLoading: false,
                addCommentDone: true,
            }
        case ADD_COMMENT_FAILURE:
            return {
                ...state,
                addCommentLoading: false,
                addCommentError: action.error,
            }

        default: {
            return { ...state, }
        }
    }
}