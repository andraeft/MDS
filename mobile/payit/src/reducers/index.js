import { combineReducers } from 'redux';

import homeReducer from './homeReducer';
import loadingReducer from './loadingReducer';

export default combineReducers({
  home: homeReducer,
  transaction: loadingReducer,
});
