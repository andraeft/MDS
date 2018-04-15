import React from 'react';
import { Provider } from 'react-redux';
import Navigator from './config/Navigator';

import store from './config/store';

export default () => (
  <Provider store={store}>
    <Navigator />
  </Provider>
);
