export const SET_LOADING = 'SET_LOADING';

export const setLoading = isLoading => ({
  type: SET_LOADING,
  payload: isLoading,
});
