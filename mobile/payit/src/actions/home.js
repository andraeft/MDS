import homeApi from '../api/homeApi';

export const HOME_INIT = 'HOME_INIT';
export const HOME_INIT_SUCCESS = 'HOME_INIT_SUCCESS';

export const homeInit = () => ({
  type: HOME_INIT,
  payload: { message: 'mesaj payload' },
});

export const homeInitSuccess = data => ({
  type: HOME_INIT_SUCCESS,
  payload: {
    message: data,
  },
});

export function fetchHome() {
  return (dispatch) => {
    dispatch(homeInit());
    homeApi()
      .then((data) => {
        dispatch(homeInitSuccess(data.message));
      })
      .catch(err => console.log(err));
  };
}
