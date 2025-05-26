// [reducers] - user.js
import produce from 'immer';

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
    Followings: [{ nickname: 'apple' }, { nickname: 'banana' }, { nicname: 'coconut' }],
    Followers: [{ nickname: 'one' }, { nickname: 'two' }, { nickname: 'three' }]
});




//  step3) 이전 + 상태 = 다음 상태
const reducer = (state = initialState, action) => produce(state, (draft) => {
    switch (action.type) {
        ///     LOG_IN
        case LOG_IN_REQUEST:
            draft.logInLoading = true;
            draft.logInDone = false;
            draft.logInError = null;
            break;

        case LOG_IN_SUCCESS:
            draft.logInLoading = false;
            draft.logInDone = true;
            draft.user = dummyUser(action.data); //action.data
            break;

        case LOG_IN_FAILURE:
            draft.logInLoading = false; //로그인 시도 중 - 로딩창
            draft.logInError = action.error;
            break;

        //      LOG_OUT
        case LOG_OUT_REQUEST:
            draft.logOutLoading = true;
            draft.logOutDone = false;
            draft.logOutError = null;
            break;

        case LOG_OUT_SUCCESS:
            draft.logOutLoading = false;
            draft.logOutDone = true;
            draft.user = null;
            break;

        case LOG_OUT_FAILURE:
            draft.logOutLoading = false;
            draft.logOutError = action.error;
            break;

        //      SIGN_UP
        case SIGN_UP_REQUEST:
            draft.signUpLoading = true;
            draft.signUpDone = false;
            draft.signUpError = null;
            break;

        case SIGN_UP_SUCCESS:
            draft.signUpLoading = false;
            draft.signUpDone = true;
            break;

        case SIGN_UP_FAILURE:
            draft.signUpLoading = false;
            draft.signUpError = action.error;
            break;

        //      CHANGE_NICKNAME
        case CHANGE_NICKNAME_REQUEST:
            draft.changeNicknameLoading = true; // 닉네임 변경 시도중
            draft.changeNicknameDone = false;
            draft.changeNicknameError = null;
            break;

        case CHANGE_NICKNAME_SUCCESS:
            draft.user.nickname = action.data.nickname;
            draft.changeNicknameLoading = false; // 닉네임 변경 시도중
            draft.changeNicknameDone = true;
            break;

        case CHANGE_NICKNAME_FAILURE:
            draft.changeNicknameLoading = false; // 닉네임 변경 시도중
            draft.changeNicknameDone = false;
            draft.changeNicknameError = action.error;
            break;
        ////////////
        default: {
            break;
        }
    };
});
export default reducer;