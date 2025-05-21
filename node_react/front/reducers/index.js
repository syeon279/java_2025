//  [reducers]  -   index.js
import { HYDRATE } from 'next-redux-wrapper'; //Redux 상태를 서버에서 생성, 클라이언트에 전달
import { combineReducers } from 'redux';

import user from './user';
import post from './post';

const rootReducer = combineReducers({
    index: (state = {}, action) => {
        switch (action.type) {
            case HYDRATE:
                console.log('HYDRATE', action);
                return { ...state, ...action.payload };
            default:
                return { ...state }
        }
    },
    user,
    post,
});

export default rootReducer;