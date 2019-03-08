import {restConstants} from "../constants/restConstants";

const initialState = {
    users: [],
    newUser: {},
}

export function userReducer(state = initialState, action) {
    switch (action.type) {
        case restConstants.GET_USERS_REQUEST:
            return {
                ...state,
                users: action.data,
            }
        case restConstants.POST_USER_REQUEST:
            return {
                ...state,
                newUser: action.data,
            }
    }
}