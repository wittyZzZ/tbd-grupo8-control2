import httpClient from "../http-common"

const getAll = () =>{
    return httpClient.get('/api/cliente/')
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
  
export default {
  getAll,
  getById,
  create,
  update,
  remove,
};