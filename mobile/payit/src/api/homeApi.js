import axios from './axiosConfig';

// const initHome = () =>
//   new Promise((resolve) => {
//     setTimeout(() => resolve({ message: 'Hello, World!' }), 3000);
//   });

const initHome = () => axios.get('/public');
const privateHomeApi = () => axios.get('/api/hello');

export { initHome, privateHomeApi };
