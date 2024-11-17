package com.tbd_grupo8.control2.controllers;

import com.tbd_grupo8.control2.config.JwtUtil;
import com.tbd_grupo8.control2.dto.LoginDto;
import com.tbd_grupo8.control2.dto.RegisterDto;
import com.tbd_grupo8.control2.entities.Usuario;
import com.tbd_grupo8.control2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginDto loginDto) {
        try { // Intentar autenticar al usuario
            UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
            Authentication authentication = authenticationManager.authenticate(login);

            // Obtener el usuario y crear el token con toda su información
            Usuario usuario = usuarioService.getUsuarioByUsername(loginDto.getUsername());
            String jwt = this.jwtUtil.create(usuario); // Modificamos el método `create` para recibir un objeto Cliente

            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,jwt).build();
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public Object register(@RequestBody RegisterDto registerDto) {
        if (usuarioService.getUsuarioByUsername(registerDto.getUsername()) != null || usuarioService.getUsuarioByEmail(registerDto.getEmail()) != null) {
            // Devolver un error con estado 409 (CONFLICT) si el usuario ya existe
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un usuario con ese nombre o correo");
        } else {
            Usuario newUsuario = new Usuario();
            newUsuario.setUsername(registerDto.getUsername());
            newUsuario.setContrasena(passwordEncoder.encode(registerDto.getPassword())); // Encriptar la contraseña
            newUsuario.setEmail(registerDto.getEmail());
            newUsuario.setTelefono(registerDto.getTelefono());
            newUsuario.setDireccion(registerDto.getDireccion());
            usuarioService.createUsuario(newUsuario);
            return ResponseEntity.ok().build();
        }
    }
}
