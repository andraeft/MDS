import qs from 'qs';

import axios from './axiosConfig';

const login = (username, password) => axios.post(
  '/login',
  qs.stringify({
    username,
    password,
  }),
);

const register = (username, password) => axios.post (
  '/public/credentials',
  qs.stringify({
    username,
    password,
  }),
);

export {login, register};

