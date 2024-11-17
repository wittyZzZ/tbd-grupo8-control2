-- Eliminar la base de datos si ya existe
DROP DATABASE IF EXISTS control2_db;

-- Crear la base de datos
CREATE DATABASE control2_db;

-- Conectarse a la nueva base de datos
\c control2_db

-- Inicio de la creación de tablas
BEGIN;

CREATE TABLE IF NOT EXISTS USUARIO
(
    id_usuario serial NOT NULL PRIMARY KEY,
    username varchar(255),
    direccion varchar(255),
    email varchar(100),
    contrasena varchar(100),
    telefono varchar(20)
);

CREATE TABLE IF NOT EXISTS TAREA
(
    id_tarea serial NOT NULL PRIMARY KEY,
    titulo varchar(100),
    descripcion varchar(255),
    fecha_creacion DATE,
    fecha_termino DATE,
    estado boolean,
    id_usuario integer,
    foreign key (id_usuario) references USUARIO(id_usuario)
);

END;