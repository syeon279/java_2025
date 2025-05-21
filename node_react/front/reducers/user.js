// [reducers] - user.js

// 1. step 1) 초기값
export const initialState = {
    isLogin: false,
    user: null,
    singupDate: {},
    loginDate: {}
};

// 2. step 2) 로그인 할 때마다 설정 함수
export const loginAction = (data) => {
    return { type: 'LOG_IN', data, }
};
export const logoutAction = {
    type: 'LOG_OUT'
};

// step3) 이전 + 상태 = 다음 상태
export default (state = initialState, action) => {
    switch (action.type) {
        case 'LOG_IN':
            return {
                ...state, // 이전 상태
                isLogin: true,
                user: action.data
            }
        case 'LOG_OUT':
            return {
                ...state,
                isLogin: false,
                user: null,
            }
        default:
            return { ...state }
    }
};