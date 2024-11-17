package com.tbd_grupo8.control2.repositories;

import com.tbd_grupo8.control2.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Usuario> usuarioRowMapper = (rs, rowNum) -> {
        Usuario usuario = new Usuario();
        usuario.setId_usuario(rs.getLong("id_usuario"));
        usuario.setUsername(rs.getString("username"));
        usuario.setDireccion(rs.getString("direccion"));
        usuario.setEmail(rs.getString("email"));
        usuario.setContrasena(rs.getString("contrasena"));
        usuario.setTelefono(rs.getString("telefono"));
        return usuario;
    };

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        String sql = "SELECT * FROM usuario";
        try {
            return jdbcTemplate.query(sql, usuarioRowMapper);
        } catch (DataAccessException e) {
            System.out.println("Error al obtener todos los usuarios: " + e.getMessage());
            return null;
        }
    }

    // Obtener un usuario por ID
    public Usuario getUsuarioById(Long id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        try {
            return jdbcTemplate.queryForObject(sql, usuarioRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (DataAccessException e) {
            System.out.println("Error al obtener usuario con id " + id + ": " + e.getMessage());
            return null;
        }
    }

    // Crear un nuevo usuario
    public int createUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (username, direccion, email, contrasena, telefono) VALUES (?, ?, ?, ?, ?)";
        try {
            return jdbcTemplate.update(sql, usuario.getUsername(), usuario.getDireccion(), usuario.getEmail(), usuario.getContrasena(), usuario.getTelefono());
        } catch (DataAccessException e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
            return 0; // Retorna 0 en caso de error
        }
    }

    // Actualizar un usuario existente
    public int updateUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET username = ?, direccion = ?, email = ?, contrasena = ?, telefono = ? WHERE id_usuario = ?";
        try {
            return jdbcTemplate.update(sql, usuario.getUsername(), usuario.getDireccion(), usuario.getEmail(), usuario.getContrasena(), usuario.getTelefono(), usuario.getId_usuario());
        } catch (DataAccessException e) {
            System.out.println("Error al actualizar usuario con id " + usuario.getId_usuario() + ": " + e.getMessage());
            return 0; // Retorna 0 en caso de error
        }
    }

    // Eliminar un usuario por ID
    public int deleteUsuario(Long id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try {
            return jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            System.out.println("Error al eliminar usuario con id " + id + ": " + e.getMessage());
            return 0; // Retorna 0 en caso de error
        }
    }

    // Buscar un usuario por nombre de usuario
    public Usuario getUsuarioByUsername(String username) {
        String sql = "SELECT * FROM usuario WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, usuarioRowMapper, username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (DataAccessException e) {
            System.out.println("Error al obtener usuario con username " + username + ": " + e.getMessage());
            return null;
        }
    }

    // Buscar un usuario por email
    public Usuario getUsuarioByEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        try {
            return jdbcTemplate.queryForObject(sql, usuarioRowMapper, email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (DataAccessException e) {
            System.out.println("Error al obtener usuario con email " + email + ": " + e.getMessage());
            return null;
        }
    }

}
