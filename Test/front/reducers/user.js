import produce from '../util/produce';

export const initialState = {
  logInLoading: false,
  logInDone: false,
  logInError: null,

  signUpLoading: false,
  signUpDone: false,
  signUpError: null,

  loadMyInfoLoading: false,
  loadMyInfoDone: false,
  loadMyInfoError: null,

  user: null,
  userInfo: null,
};

export const LOG_IN_REQUEST = 'LOG_IN_REQUEST';
export const LOG_IN_SUCCESS = 'LOG_IN_SUCCESS';
export const LOG_IN_FAILURE = 'LOG_IN_FAILURE';

export const SIGN_UP_REQUEST = 'SIGN_UP_REQUEST';
export const SIGN_UP_SUCCESS = 'SIGN_UP_SUCCESS';
export const SIGN_UP_FAILURE = 'SIGN_UP_FAILURE';

export const LOAD_MY_INFO_REQUEST = 'LOAD_MY_INFO_REQUEST';
export const LOAD_MY_INFO_SUCCESS = 'LOAD_MY_INFO_SUCCESS';
export const LOAD_MY_INFO_FAILURE = 'LOAD_MY_INFO_FAILURE';

export const ADD_POST_TO_ME = 'ADD_POST_TO_ME';
export const REMOVE_POST_OF_ME = 'REMOVE_POST_OF_ME';

////////////////////////////////////////////////////// next
const reducer = (state = initialState, action) => produce(state, (draft) => {
  switch (action.type) {
    case LOG_IN_REQUEST:
      draft.logInLoading = true;
      draft.logInError = null;
      draft.logInDone = false;
      break;
    case LOG_IN_SUCCESS:
      draft.logInLoading = false;
      draft.user = action.data;   ////dummyUser(action.data);
      draft.logInDone = true;
      break;
    case LOG_IN_FAILURE:
      draft.logInLoading = false;
      draft.logInError = action.error;
      break;

    //
    case SIGN_UP_REQUEST:
      draft.signUpLoading = true;
      draft.signUpError = null;
      draft.signUpDone = false;
      break;
    case SIGN_UP_SUCCESS:
      draft.signUpLoading = false;
      draft.signUpDone = true;
      break;
    case SIGN_UP_FAILURE:
      draft.signUpLoading = false;
      draft.signUpError = action.error;
      break;

    //////////////////////////////
    case LOAD_MY_INFO_REQUEST:
      draft.loadMyInfoLoading = true;
      draft.loadMyInfoError = null;
      draft.loadMyInfoDone = false;
      break;
    case LOAD_MY_INFO_SUCCESS:
      draft.loadMyInfoLoading = false;
      draft.user = action.data;
      draft.loadMyInfoDone = true;
      break;
    case LOAD_MY_INFO_FAILURE:
      draft.loadMyInfoLoading = false;
      draft.loadMyInfoError = action.error;
      break;

    //////////////////////////////
    case ADD_POST_TO_ME:
      draft.user.Posts.unshift({ id: action.data });
      break;
    case REMOVE_POST_OF_ME:
      draft.user.Posts = draft.user.Posts.filter((v) => v.id !== action.data);
      break;

    ///////////////////////////////
    default:
      break;
  }
});

export default reducer;
