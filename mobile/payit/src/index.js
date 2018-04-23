import React from 'react';
import { Provider } from 'react-redux';
import { RootNavigator } from './config/router';

import store from './config/store';
import NavigationService from './service/NavigationService';

export default () => (
  <Provider store={store}>
    <RootNavigator
      ref={(navigatorRef) => {
        NavigationService.setTopLevelNavigator(navigatorRef);
      }}
    />
  </Provider>
);
