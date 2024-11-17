package com.tbd_grupo8.control2.repositories;

import com.tbd_grupo8.control2.entities.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TareaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Tarea> tareaRowMapper = (rs, rowNum) -> {
        Tarea tarea = new Tarea();
        tarea.setId_tarea(rs.getLong("id_tarea"));
        tarea.setTitulo(rs.getString("titulo"));
        tarea.setDescripcion(rs.getString("descripcion"));
        tarea.setFecha_creacion(rs.getDate("fecha_creacion"));
        tarea.setFecha_termino(rs.getDate("fecha_termino"));
        tarea.setEstado(rs.getBoolean("estado"));
        tarea.setId_usuario(rs.getLong("id_usuario"));
        return tarea;
    };

    public List<Tarea> getAllTareas() {
        String sql = "SELECT * FROM tarea";
        try {
            return jdbcTemplate.query(sql, tareaRowMapper);
        } catch (DataAccessException e) {
            System.out.println("Error al obtener todas las tareas: " + e.getMessage());
            return null;
        }
    }

    public Tarea getTareaById(Long id) {
        String sql = "SELECT * FROM tarea WHERE id_tarea = ?";
        try {
            return jdbcTemplate.queryForObject(sql, tareaRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (DataAccessException e) {
            System.out.println("Error al obtener tarea con id " + id + ": " + e.getMessage());
            return null;
        }
    }

    public int createTarea(Tarea tarea) {
        String sql = "INSERT INTO tarea (titulo, descripcion, fecha_creacion, fecha_termino, estado, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            return jdbcTemplate.update(sql, tarea.getTitulo(), tarea.getDescripcion(), tarea.getFecha_creacion(), tarea.getFecha_termino(), tarea.getEstado(), tarea.getId_usuario());
        } catch (DataAccessException e) {
            System.out.println("Error al crear tarea: " + e.getMessage());
            return 0;
        }
    }

    public int updateTarea(Tarea tarea) {
        String sql = "UPDATE tarea SET titulo = ?, descripcion = ?, fecha_creacion = ?, fecha_termino = ?, estado = ?, id_usuario = ? WHERE id_tarea = ?";
        try {
            return jdbcTemplate.update(sql, tarea.getTitulo(), tarea.getDescripcion(), tarea.getFecha_creacion(), tarea.getFecha_termino(), tarea.getEstado(), tarea.getId_usuario(), tarea.getId_tarea());
        } catch (DataAccessException e) {
            System.out.println("Error al actualizar tarea con id " + tarea.getId_tarea() + ": " + e.getMessage());
            return 0;
        }
    }

    public int deleteTarea(Long id) {
        String sql = "DELETE FROM tarea WHERE id_tarea = ?";
        try {
            return jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            System.out.println("Error al eliminar tarea con id " + id + ": " + e.getMessage());
            return 0;
        }
    }

    public List<Tarea> getTareasByUsuario(Long id_usuario) {
        String sql = "SELECT * FROM tarea WHERE id_usuario = ?";
        try {
            return jdbcTemplate.query(sql, tareaRowMapper, id_usuario);
        } catch (DataAccessException e) {
            System.out.println("Error al obtener tareas para el usuario con id " + id_usuario + ": " + e.getMessage());
            return null;
        }
    }

    public List<Tarea> getTareasByEstado(Boolean estado) {
        String sql = "SELECT * FROM tarea WHERE estado = ?";
        try {
            return jdbcTemplate.query(sql, tareaRowMapper, estado);
        } catch (DataAccessException e) {
            System.out.println("Error al obtener tareas con estado " + estado + ": " + e.getMessage());
            return null;
        }
    }

    public int getTiempoRestante(Long id) {
        String sql = "SELECT (fecha_termino - CURRENT_DATE) AS tiempo_restante FROM tarea WHERE id_tarea = ?";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class, id);
        } catch (DataAccessException e) {
            System.out.println("Error al obtener tiempo restante de tarea con id " + id + ": " + e.getMessage());
            return 0;
        }
    }

}
