import React from 'react';
import { Provider } from 'react-redux';
import { RootNavigator } from './config/router';

import store from './config/store';

export default () => (
  <Provider store={store}>
    <RootNavigator />
  </Provider>
);
