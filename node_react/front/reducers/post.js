// [reducers] - post.js
export const initialState = {
    mainPosts: [{
        id: 1,
        User: { id: 1, nickname: 'TheJoa' },
        content: '첫번째 게시글 #node #react',
        Images: [
            { src: 'https://www.fitpetmall.com/wp-content/uploads/2022/11/shutterstock_196467692-1024x819.jpg' },
            { src: 'https://www.gklibrarykor.com/wp-content/uploads/2024/08/1_%EA%B0%95%EC%95%84%EC%A7%80%EC%9D%98-%EC%8B%A0%EC%B2%B4%EC%A0%81-%ED%8A%B9%EC%A7%95.jpg' },
            { src: 'https://banulpattern.com/cdn/shop/products/IMG_7557.jpg?v=1636425784&width=1946' },
        ],
        Comments: [{
            User: { nickname: 'Dan' },
            content: 'ㅋㅋㅋ'
        }, {
            User: { nickname: 'sen' },
            content: 'Hi'
        }]

    }],
    postAdd: false,
    imagePaths: [],
}

export const addPost = { type: 'ADD_POST', }

//////////////dummyPost
const dummyPost = {
    id: 2,
    content: 'dummy',
    User: { id: 2, nickname: 'Dan' },
    Images: [],
    Comments: [{
        User: { nickname: 'dummy' },
        content: 'dumdum'
    }]
}
/////////////////

export default (state = initialState, action) => {
    switch (action.type) {
        case 'ADD_POST':
            return {
                ...state,
                mainPosts: [dummyPost, ...state.mainPosts],   // 글이 맨 앞으로
                //mainPosts: [...state.mainPosts, dummyPost,],   // 글이 맨 앞으로
                postAdd: true,  // 글쓰기추가
            }
        default: {
            return { ...state, }
        }
    }
}