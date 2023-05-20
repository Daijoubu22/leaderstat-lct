import React from 'react';
import ReactDOM from 'react-dom/client';
import '@/scss/main.scss';
import { setupStore } from '@/store';
import { Provider } from 'react-redux';
import App from '@/App';

const store = setupStore();

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
    <Provider store={store}>
        <App />
    </Provider>,
);
