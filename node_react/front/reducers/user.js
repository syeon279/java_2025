// [reducers] - user.js

// 1. step 1) 초기값
export const initialState = {
    logInLoading: false,
    logInDone: false,
    logInError: null,

    logOutLoading: false,
    logOutDone: false,
    logOutError: null,

    user: null,
    singupDate: {},
    loginDate: {}
};

// 2. step 2) 로그인 할 때마다 설정 함수
export const loginAction = (data) => {
    return {
        type: 'LOG_IN_REQUEST',
        data,
    }
};
export const logoutAction = {
    type: 'LOG_OUT_REQUEST'
};

// step3) 이전 + 상태 = 다음 상태
export default (state = initialState, action) => {
    switch (action.type) {
        case 'LOG_IN_REQUEST':
            return {
                ...state, // 이전 상태
                logInLoading: true,
                logInDone: false,
                logInError: null,
            }
        case 'LOG_IN_SUCCESS':
            return {
                ...state,
                logInLoading: false,
                logInDone: true,
                user: { ...action.data, nickname: 'Dan' }
            }
        case 'LOG_IN_FAILURE':
            return {
                ...state,
                logInLoading: false, //로그인 시도 중 - 로딩창
                logInError: action.error,
            }
        case 'LOG_OUT_REQUEST':
            return {
                ...state,
                logOutLoading: true,
                logOutDone: false,
                logOutError: null,
            }
        case 'LOG_OUT_SUCCESS':
            return {
                ...state,
                logOutLoading: false,
                logOutDone: true,
                user: null
            }
        case 'LOG_OUT_FAILURE':
            return {
                ...state,
                logOutLoading: false,
                logOutError: action.error,
            }
        default:
            return { ...state }
    }
};