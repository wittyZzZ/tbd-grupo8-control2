import httpClient from "../http-common"

const getAll = () =>{
    return httpClient.get('/api/tareas/')
};
const getById = (id) => {
    return httpClient.get(`/api/tareas/${id}`);
};

const create = (task) => {
    return httpClient.post('/api/tareas/', task);
};
  
const update = (id, task) => {
  return httpClient.put(`/api/tareas/${id}`, task);
};
  
const remove = (id) => {
  return httpClient.delete(`/api/tareas/${id}`);
};

const getTasksByUserId = (id_usuario) =>{
  return httpClient.get(`/api/tareas/usuario/${id_usuario}`);
};

const getTasksExpiredUser = (id_usuario) =>{
  return httpClient.get(`/api/tareas/caducada/${id_usuario}`);
};
  
export default {
  getAll,
  getById,
  create,
  update,
  remove,
  getTasksByUserId,
  getTasksExpiredUser
};