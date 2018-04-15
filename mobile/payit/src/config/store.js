import { createStore } from 'redux';

import reducer from '../reducers';

const store = createStore(reducer, {});

// const store = createStore(reducers);

export default store;
