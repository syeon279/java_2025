// [reducers] - user.js

// 1. step 1) 초기값
export const initialState = {
    logInLoading: false,
    logInDone: false,
    logInError: null,

    logOutLoading: false,
    logOutDone: false,
    logOutError: null,

    //////////////////////////////////////// 추가1
    signUpLoading: false, // 회원가입 시도중
    signUpDone: false,
    signUpError: null,

    changeNicknameLoading: false, // 닉네임 변경 시도중
    changeNicknameDone: false,
    changeNicknameError: null,


    followDone: false,
    followError: null,

    unfollowLoading: false, // 언팔로우 시도중
    unfollowDone: false,
    unfollowError: null,
    //////////////////////////////////////// 추가1- END

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
export const signupAction = (data) => {
    return {
        type: 'SIGN_UP_REQUEST',
        data,
    }
};

////
export const LOG_IN_REQUEST = 'LOG_IN_REQUEST';
export const LOG_IN_SUCCESS = 'LOG_IN_SUCCESS';
export const LOG_IN_FAILURE = 'LOG_IN_FAILURE';

export const LOG_OUT_REQUEST = 'LOG_OUT_REQUEST';
export const LOG_OUT_SUCCESS = 'LOG_OUT_SUCCESS';
export const LOG_OUT_FAILURE = 'LOG_OUT_FAILURE';

export const SIGN_UP_REQUEST = 'SIGN_UP_REQUEST';
export const SIGN_UP_SUCCESS = 'SIGN_UP_SUCCESS';
export const SIGN_UP_FAILURE = 'SIGN_UP_FAILURE';

export const CHANGE_NICKNAME_REQUEST = 'CHANGE_NICKNAME_REQUEST';
export const CHANGE_NICKNAME_SUCCESS = 'CHANGE_NICKNAME_SUCCESS';
export const CHANGE_NICKNAME_FAILURE = 'CHANGE_NICKNAME_FAILURE';

export const FOLLOW_REQUEST = 'FOLLOW_REQUEST';
export const FOLLOW_SUCCESS = 'FOLLOW_SUCCESS';
export const FOLLOW_FAILURE = 'FOLLOW_FAILURE';

export const UFOLLOW_REQUEST = 'UFOLLOW_REQUEST';
export const UFOLLOW_SUCCESS = 'UFOLLOW_SUCCESS';
export const UFOLLOW_FAILURE = 'UFOLLOW_FAILURE';

// --
const dummyUser = (data) => ({
    ...data,
    nickname: data.nickname || 'Dan',
    id: 1,
    Posts: [{ id: 1 }],
    Follwings: [{ nickname: 'apple' }, { nickname: 'banana' }, { nicname: 'coconut' }],
    Followers: [{ nickname: 'one' }, { nickname: 'two' }, { nicname: 'three' }]
});




//  step3) 이전 + 상태 = 다음 상태
export default (state = initialState, action) => {
    switch (action.type) {
        ///     LOG_IN
        case LOG_IN_REQUEST:
            return {
                ...state, // 이전 상태
                logInLoading: true,
                logInDone: false,
                logInError: null,
            }
        case LOG_IN_SUCCESS:
            return {
                ...state,
                logInLoading: false,
                logInDone: true,
                user: dummyUser(action.data)
            }
        case LOG_IN_FAILURE:
            return {
                ...state,
                logInLoading: false, //로그인 시도 중 - 로딩창
                logInError: action.error,
            }

        //      LOG_OUT
        case LOG_OUT_REQUEST:
            return {
                ...state,
                logOutLoading: true,
                logOutDone: false,
                logOutError: null,
            }
        case LOG_OUT_SUCCESS:
            return {
                ...state,
                logOutLoading: false,
                logOutDone: true,
                user: null
            }
        case LOG_OUT_FAILURE:
            return {
                ...state,
                logOutLoading: false,
                logOutError: action.error,
            }

        //      SIGN_UP
        case SIGN_UP_REQUEST:
            return {
                ...state,
                signUpLoading: true,
                signUpDone: false,
                signUpError: null,
            }
        case SIGN_UP_SUCCESS:
            return {
                ...state,
                signUpLoading: false,
                signUpDone: true,
            }
        case SIGN_UP_FAILURE:
            return {
                ...state,
                signUpLoading: false,
                signUpError: action.error
            }

        //      CHANGE_NICKNAME
        case CHANGE_NICKNAME_REQUEST:
            return {
                ...state,
                changeNicknameLoading: true, // 닉네임 변경 시도중
                changeNicknameDone: false,
                changeNicknameError: null,
            }
        case CHANGE_NICKNAME_SUCCESS:
            console.log('🔥 action.data 전체:', action.data); // 이거로 확인
            console.log('..........CHANGE_NICKNAME_SUCCESS : ' + action.data.content);
            return {
                ...state,
                user: {
                    ...state.user,
                    nickname: action.data.content,
                },
                changeNicknameLoading: false, // 닉네임 변경 시도중
                changeNicknameDone: true,
            }
        case CHANGE_NICKNAME_FAILURE:
            return {
                ...state,
                changeNicknameLoading: false, // 닉네임 변경 시도중
                changeNicknameDone: false,
                changeNicknameError: action.error,
            }

        //      CHAINGE_NICKNAME
        case SIGN_UP_REQUEST:
            return {
                ...state,
                signUpLoading: true,
                signUpDone: false,
                signUpError: null,
            }
        case SIGN_UP_SUCCESS:
            return {
                ...state,
                signUpLoading: false,
                signUpDone: true,
            }
        case SIGN_UP_FAILURE:
            return {
                ...state,
                signUpLoading: false,
                signUpError: action.error
            }

        default:
            return { ...state }
    }
};