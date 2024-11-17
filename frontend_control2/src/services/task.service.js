import httpClient from "../http-common"

const getAll = () =>{
    return httpClient.get('/api/tareas/')
};
const getById = (id) => {
    return httpClient.get(`/api/tareas/${id}`);
};

const getByUserId = (id_usuario) => {
  return httpClient.get(`/api/tareas/usuario/${id_usuario}`);
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

export default {
  getAll,
  getById,
  getByUserId,
  create,
  update,
  remove,
};