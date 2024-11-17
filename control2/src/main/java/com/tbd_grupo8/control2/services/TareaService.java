package com.tbd_grupo8.control2.services;

import com.tbd_grupo8.control2.entities.Tarea;
import com.tbd_grupo8.control2.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    // Obtener todas las tareas
    public List<Tarea> getAllTareas() {
        return tareaRepository.getAllTareas();
    }

    // Obtener una tarea por ID
    public Tarea getTareaById(Long id) {
        return tareaRepository.getTareaById(id);
    }

    // Crear una nueva tarea
    public int createTarea(Tarea tarea) {
        return tareaRepository.createTarea(tarea);
    }

    // Actualizar una tarea existente
    public int updateTarea(Tarea tarea) {
        return tareaRepository.updateTarea(tarea);
    }

    // Eliminar una tarea por ID
    public int deleteTarea(Long id) {
        return tareaRepository.deleteTarea(id);
    }

    // Obtener tareas por estado (pendiente o completada)
    public List<Tarea> getTareasByEstado(Boolean estado) {
        return tareaRepository.getTareasByEstado(estado);
    }

    // Obtener tareas de un usuario
    public List<Tarea> getTareasByUsuario(Long id_usuario) {
        return tareaRepository.getTareasByUsuario(id_usuario);
    }

    // Calcular el tiempo restante de una tarea
    public int getTiempoRestante(Long id) {
        return tareaRepository.getTiempoRestante(id);
    }
}
