package com.tbd_grupo8.control2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {
    private Long id_tarea;
    private String titulo;
    private String descripcion;
    private Date fecha_creacion;
    private Date fecha_termino;
    private String estado;
    private Long id_usuario;
}
