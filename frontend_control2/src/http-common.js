import axios from "axios";

// Crea una instancia de Axios con configuración base
const httpClient = axios.create({
  baseURL: `http://localhost:8081`, // Cambia al puerto y URL que uses
  headers: {
    'Content-Type': 'application/json',
  },
});

// Agrega un interceptor para incluir el token en cada solicitud
httpClient.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token"); // Obtén el token del almacenamiento local
    if (token) {
      config.headers.Authorization = `Bearer ${token}`; // Agrega el token al encabezado
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default httpClient;