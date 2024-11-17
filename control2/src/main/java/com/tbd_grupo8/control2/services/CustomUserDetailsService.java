package com.tbd_grupo8.control2.services;

import com.tbd_grupo8.control2.entities.Usuario;
import com.tbd_grupo8.control2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.getUsuarioByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getContrasena()) // Asegúrate de que la contraseña esté encriptada
                .build();
    }
}