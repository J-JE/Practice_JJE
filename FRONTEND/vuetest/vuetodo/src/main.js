import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

// createApp(App).use(router).mount('#app')

const app1 = createApp(App);
app1.use(router);
app1.mount('#app');

app1.config.globalProperties.$ax =axios;