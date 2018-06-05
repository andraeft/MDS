import { HOME_INIT, HOME_INIT_SUCCESS } from '../actions/home';

const INITIAL_STATE = {
  profilePic: 'default',
  bankRating: 0,
  slaveRating: 0,
  firstName: '',
  lastName: '',
  email: '',
};

export default (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case HOME_INIT: {
      return state;
    }
    case HOME_INIT_SUCCESS: {
      return {
        ...state,
        profilePic: action.payload.profilePic,
        bankRating: action.payload.bankRating,
        slaveRating: action.payload.slaveRating,
        firstName: action.payload.firstName,
        lastName: action.payload.lastName,
        email: action.payload.email,
        id: action.payload.id,
      };
    }
    default: {
      return state;
    }
  }
};
