import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://192.168.100.8:8080',
  timeout: 1000,
});

instance.interceptors.response.use(
  response => response.data,
  error => Promise.reject(error),
);

export default instance;
