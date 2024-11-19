import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import vuetify from './plugins/vuetify';
import { loadFonts } from './plugins/webfontloader';


loadFonts()

createApp(App)
  .use(router)
  .use(vuetify) // Asegúrate de que esta línea sea correcta
  .mount('#app');

