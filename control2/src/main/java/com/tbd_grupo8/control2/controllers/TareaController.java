package com.tbd_grupo8.control2.controllers;

import com.tbd_grupo8.control2.entities.Tarea;
import com.tbd_grupo8.control2.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Obtener todas las tareas
    @GetMapping("/")
    public List<Tarea> getAllTareas() {
        return tareaService.getAllTareas();
    }

    // Obtener una tarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable Long id) {
        Tarea tarea = tareaService.getTareaById(id);
        return tarea != null ? ResponseEntity.ok(tarea) : ResponseEntity.notFound().build();
    }

    // Crear una nueva tarea
    @PostMapping("/")
    public ResponseEntity<Void> createTarea(@RequestBody Tarea tarea) {
        int result = tareaService.createTarea(tarea);
        return result > 0 ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    // Actualizar una tarea
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        tarea.setId_tarea(id);
        int result = tareaService.updateTarea(tarea);
        return result > 0 ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id) {
        int result = tareaService.deleteTarea(id);
        return result > 0 ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    // Obtener tareas por estado
    @GetMapping("/estado/{estado}")
    public List<Tarea> getTareasByEstado(@PathVariable String estado) {
        return tareaService.getTareasByEstado(estado);
    }

    @GetMapping("/caducada/{id_usuario}")
    public List<Tarea> getTareasCaducadas(@PathVariable Long id_usuario) {
        return tareaService.getTareasCaducadasByUsername(id_usuario);
    }

    // Obtener tareas de un usuario
    @GetMapping("/usuario/{id_usuario}")
    public ResponseEntity<List<Tarea>> getTareasByUsuario(@PathVariable Long id_usuario) {
        List<Tarea> tareasCaducadas = tareaService.getTareasByUsuario(id_usuario);
        return tareasCaducadas != null ? ResponseEntity.ok(tareasCaducadas) : ResponseEntity.notFound().build();
    }
}
