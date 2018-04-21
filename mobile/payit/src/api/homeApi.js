import axios from './axiosConfig';

// const initHome = () =>
//   new Promise((resolve) => {
//     setTimeout(() => resolve({ message: 'Hello, World!' }), 3000);
//   });

const initHome = () => axios.get('/hello');

export default initHome;
