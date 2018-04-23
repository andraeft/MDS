import axios from 'axios';

import NavigationService from '../service/NavigationService';

const instance = axios.create({
  baseURL: 'http://192.168.100.8:8080',
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
