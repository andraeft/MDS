import { initHome, privateHomeApi } from '../api/homeApi';
import { setLoading } from './loading';

export const HOME_INIT = 'HOME_INIT';
export const HOME_INIT_SUCCESS = 'HOME_INIT_SUCCESS';

export const homeInit = () => ({
  type: HOME_INIT,
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
    dispatch(setLoading(true));

    initHome()
      .then((data) => {
        dispatch(homeInitSuccess(data.message));
        dispatch(setLoading(false));
      })
      .catch((err) => {
        console.log(err);
        dispatch(setLoading(false));
      });
  };
}

export function privateHome() {
  return (dispatch) => {
    dispatch(homeInit());
    dispatch(setLoading(true));

    privateHomeApi()
      .then((data) => {
        dispatch(homeInitSuccess(data.message));
        dispatch(setLoading(false));
      })
      .catch((err) => {
        console.log(err);
        dispatch(setLoading(false));
      });
  };
}
