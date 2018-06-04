import axios from 'axios';

import NavigationService from '../service/NavigationService';

const instance = axios.create({
  baseURL: 'http://192.168.43.26:8080',
  // baseURL: 'http://18.236.173.66:8080',
  // baseURL: 'http://192.168.43.26:8080',
  timeout: 1000,
});

instance.interceptors.response.use(response => response.data, error => handleRequestError(error));

function handleRequestError(error) {
  if (error.response.status === 401) {
    NavigationService.navigate('SignedOut');
  }
  return Promise.reject(error);
}

export default instance;
