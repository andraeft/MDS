import { SET_LOADING } from '../actions/loading';

const INITIAL_STATE = {
  loading: false,
};

export default (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case SET_LOADING: {
      return {
        ...state,
        loading: action.payload,
      };
    }
    default: {
      return state;
    }
  }
};
