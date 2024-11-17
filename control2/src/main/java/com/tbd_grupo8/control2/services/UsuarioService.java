package com.tbd_grupo8.control2.services;

import com.tbd_grupo8.control2.entities.Usuario;
import com.tbd_grupo8.control2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.getAllUsuarios();
    }

    // Obtener un usuario por ID
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.getUsuarioById(id);
    }

    // Crear un nuevo usuario
    public int createUsuario(Usuario usuario) {
        return usuarioRepository.createUsuario(usuario);
    }

    // Actualizar un usuario
    public int updateUsuario(Usuario usuario) {
        return usuarioRepository.updateUsuario(usuario);
    }

    // Eliminar un usuario
    public int deleteUsuario(Long id) {
        return usuarioRepository.deleteUsuario(id);
    }

    // Buscar un usuario por nombre de usuario
    public Usuario getUsuarioByUsername(String username) {
        return usuarioRepository.getUsuarioByUsername(username);
    }

    // Buscar un usuario por email
    public Usuario getUsuarioByEmail(String email) {
        return usuarioRepository.getUsuarioByEmail(email);
    }
}
