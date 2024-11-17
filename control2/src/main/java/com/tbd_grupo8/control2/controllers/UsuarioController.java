package com.tbd_grupo8.control2.controllers;

import com.tbd_grupo8.control2.entities.Usuario;
import com.tbd_grupo8.control2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping("/")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    // Obtener un usuario por su Username
    @GetMapping("/{username}")
    public ResponseEntity<Usuario> getUsuarioByUsername(@PathVariable String username) {
        Usuario usuario = usuarioService.getUsuarioByUsername(username);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Void> createUsuario(@RequestBody Usuario usuario) {
        int result = usuarioService.createUsuario(usuario);
        return result > 0 ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId_usuario(id);
        int result = usuarioService.updateUsuario(usuario);
        return result > 0 ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        int result = usuarioService.deleteUsuario(id);
        return result > 0 ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
