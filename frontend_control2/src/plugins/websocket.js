import SockJS from "sockjs-client";
import { Stomp } from "@stomp/stompjs";

export default {
  install(app) {
    const socket = new SockJS("http://localhost:8080/ws", null, {withCredentials: true,});
    const stompClient = Stomp.over(socket);

    stompClient.connect({}, () => {
      console.log("Conectado a WebSocket");

      stompClient.subscribe("/topic/tareas-caducadas", (message) => {
        const tareasCaducadas = JSON.parse(message.body);
        console.log("Tareas caducadas recibidas:", tareasCaducadas);
        // Emitir un evento global para manejar notificaciones
        app.config.globalProperties.$emit("tareaCaducada", tareasCaducadas);
      });
    });

    app.config.globalProperties.$stompClient = stompClient;
  },
};