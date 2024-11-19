# Control N°2 - Base de Datos Avanzadas
Este repositorio contiene todos los archivos relacionados con el Control N°2 del ramo Base de Datos Avanzadas desarrollado por el equipo 8.

## Integrantes del equipo 8
* Gonzalo Arévalo
* Arina Bilan
* Patricio Briceño
* Cristóbal Flores
* William Zubarzo

## Herramientas de Desarrollo
Para ejecutar correctamente todo el proyecto, además de los archivos del repositorio se requieren las siguientes tecnologías:

* Postgres SQL versión 12
* JDK versión 17
* pgAdmin 4
* IntelliJ IDEA Ultimate
* Visual Studio Code
* Postman
* VUE versión 3

## Guía de Instalación y Ejecución

1. Clonar el siguiente repositorio en su dispositivo con el comando:

```sh
git clone https://github.com/wittyZzZ/tbd-grupo8-control2
```

2. Instalación de IntelliJ IDEA
   
    * Descarga IntelliJ IDEA desde el sitio web oficial: [Descargar IntelliJ IDEA](https://www.jetbrains.com/idea/download/).
    * Instala IntelliJ IDEA siguiendo las instrucciones específicas para tu sistema operativo.
  
3. Instalación de PostgresSQL
   
    * Descarga PostgreSQL desde el sitio web oficial: [Descargar PostgreSQL](https://www.postgresql.org/download/).
    * Sigue las instrucciones de instalación para tu sistema operativo.
  
4. Instalación de pgAdmin

    * Descarga pgAdmin desde el sitio web oficial: [Descargar pgAdmin](https://www.pgadmin.org/download/).
    * Instala pgAdmin siguiendo las instrucciones para tu sistema operativo.

5. Creación de la base de datos y carga de información

    * Habiendo clonado el repositorio, se debe abrir una terminal dentro de esa carpeta, de manera de poder acceder a los archivos "dbCreate.sql" y "loadData.sql"
    * En la terminal, se deben correr los siguientes comandos (leer archivo "secuencia_de_comandos.txt"):
  
      ```sh
      psql -U postgres -f dbCreate.sql
      psql -U postgres -d control2_db -f loadData.sql
      ```
    * Habiendo hecho lo anterior, ya debería estar disponible la base de datos "control2_db" cargada con datos de prueba.
      
6. Levantamiento del Frontend Vue 3

    * Abrir Visual Studio Code -> Abrir carpeta -> Seleccionar "tbd-grupo8-control2\frontend_control2".
    * Ejecutar los siguientes comandos en la terminal:
      
      ```sh
      npm install
      npm run serve
      ```
    * Ingresar en un navegador la URL http://localhost:5173/

7. Levantamiento del Backend

    * Abrir IntelliJ IDEA y seleccionar el proyecto Spring de la carpeta "tbd-grupo8-control2\control2".
    * Esperar a que se cargue por completo el proyecto y luego darle a 'Run Control2Application'.
  

8. Probar la aplicación

    * Estando en http://localhost:5173/login, para iniciar sesión se puede hacer el registro de un nuevo usuario o se puede usar cualquiera de las siguientes cuentas ya existentes:
      
        * Usuario: user_19; Contraseña: 123
        * Usuario: user_13; Contraseña: 123
        * Usuario: user_7; Contraseña: 123
        * Usuario: user_11; Contraseña: 123

**¡Listo! Ahora se deberían poder probar las todas las funcionalidades implementadas dentro de la aplicación web.**
       

















