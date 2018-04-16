import { HOME_INIT, HOME_INIT_SUCCESS } from '../actions/home';

const INITIAL_STATE = {
  message: 'initial',
  loading: false,
};

export default (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case HOME_INIT: {
      return {
        ...state,
        loading: true,
      };
    }
    case HOME_INIT_SUCCESS: {
      return {
        ...state,
        loading: false,
        message: action.payload.message,
      };
    }
    default: {
      return state;
    }
  }
};
