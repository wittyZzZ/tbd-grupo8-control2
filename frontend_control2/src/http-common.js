import axios from "axios";

// Crea una instancia de Axios
const httpClient = axios.create({
  baseURL: "http://localhost:8080", // Cambia esto por la URL de tu backend
  headers: {
    "Content-type": "application/json",
  },
});

// Interceptor para incluir el token en las cabeceras de todas las solicitudes
httpClient.interceptors.request.use(
  (config) => {
    // Verifica si la URL no pertenece a rutas de autenticación
    if (!config.url.includes("/auth/")) {
      // Obtén el token de localStorage
      const token = localStorage.getItem("token");
      if (token) {
        // Agrega el token al header Authorization
        config.headers.Authorization = `Bearer ${token}`;
      }
    }
    return config;
  },
  (error) => {
    // Manejo de errores antes de enviar la solicitud
    return Promise.reject(error);
  }
);

export default httpClient;