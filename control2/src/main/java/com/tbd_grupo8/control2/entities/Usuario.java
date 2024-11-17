package com.tbd_grupo8.control2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long id_usuario;
    private String username;
    private String direccion;
    private String email;
    private String contrasena;
    private String telefono;
}
