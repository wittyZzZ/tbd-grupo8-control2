import axios from "axios";

// const backendServer = import.meta.env.BACKEND_SERVER;
// const backendPort = 8080;

// console.log(backendServer)
// console.log(backendPort)

export default axios.create({
    // baseURL: `http://${backendServer}:${backendPort}`,
    baseURL: `http://localhost:8080`,
    headers: {
        'Content-Type': 'application/json'
    }
});