import {ThemeProvider} from 'styled-components';
import '@styles/styles.scss';
import theme from '@theme';
import {Provider, useDispatch, useSelector} from 'react-redux';
import store, {AppState} from '@store';
import {toast, ToastContainer} from 'react-toastify';
import {useEffect} from 'react';
import {commonActions} from '@store/slices/common';
import {handlePostCategories} from '@store/thunk/post';

function MyApp({ Component, pageProps }: { Component: any; pageProps: any }) {
  const WrappedComponent = () => {
    const dispatch = useDispatch();
    const { visible, message, type } = useSelector((state: AppState) => state.common.toast);

    useEffect(() => {
      dispatch(handlePostCategories());
    }, []);

    useEffect(() => {
      if (visible) {
        toast[type || 'info'](message, {
          position: toast.POSITION.BOTTOM_LEFT,
          onClose: () => dispatch(commonActions.hideToast()),
        });
      }
    }, [visible]);

    return (
      <ThemeProvider theme={theme}>
        <Component {...pageProps} />
        <ToastContainer autoClose={1500} style={{ minHeight: 50 }} />
      </ThemeProvider>
    );
  };

  return (
    <Provider store={store}>
      <WrappedComponent />
    </Provider>
  );
}

export default MyApp;
