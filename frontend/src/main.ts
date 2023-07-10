import { createApp } from 'vue';
import App from './App.vue';
import { RSocketService } from './services/RSocketService';

const app = createApp(App);

// Подключение RSocketService в качестве глобального сервиса
const rSocketService = new RSocketService();
app.provide('rSocketService', rSocketService);

app.mount('#app');
