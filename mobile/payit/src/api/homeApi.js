import qs from 'qs';

import axios from './axiosConfig';

// const initHome = () =>
//   new Promise((resolve) => {
//     setTimeout(() => resolve({ message: 'Hello, World!' }), 3000);
//   });

const initHome = () => axios.get('/public');
const privateHomeApi = () => axios.get('/api/hello');
const login = (username, password) => {
  console.log('autentific');
  return axios.post(
    '/login',
    qs.stringify({
      username,
      password,
    }),
  );
};

export { initHome, privateHomeApi, login };
