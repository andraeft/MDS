import qs from 'qs';

import axios from './axiosConfig';

const login = (username, password) => axios.post(
  '/login',
  qs.stringify({
    username,
    password,
  }),
);

export default login;
