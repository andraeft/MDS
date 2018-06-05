import axios from './axiosConfig';

// const initHome = () =>
//   new Promise((resolve) => {
//     setTimeout(() => resolve({
//       profilePic: '852ad2f0-4061-413d-b56a-8f9305ab70a9',
//       bankRating: 0,
//       slaveRating: 0,
//       firstName: 'Titi',
//       lastName: 'Popa',
//       email: 'tit@yahoo.com',
//     }), 3000);
//   });

const initHome = () => axios.get('/user/me');
const privateHomeApi = () => axios.get('/api/hello');

const editUser = (id, firstName, lastName, email) => axios.post(
  `/user/${id}`,
  {
    firstName,
    lastName,
    email,
  },
);

export { initHome, privateHomeApi, editUser };
