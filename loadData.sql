\encoding UTF8

INSERT INTO USUARIO (id_usuario, username, direccion, email, contrasena, telefono)
VALUES
(1, 'user_1', 'Street 1, City 4', 'user1@example.com', 'password1', '+56935303864'),
(2, 'user_2', 'Street 2, City 5', 'user2@example.com', 'password2', '+56922531069'),
(3, 'user_3', 'Street 3, City 5', 'user3@example.com', 'password3', '+56913446058'),
(4, 'user_4', 'Street 4, City 3', 'user4@example.com', 'password4', '+56942749550'),
(5, 'user_5', 'Street 5, City 6', 'user5@example.com', 'password5', '+56985843537'),
(6, 'user_6', 'Street 6, City 3', 'user6@example.com', 'password6', '+56916010600'),
(7, 'user_7', 'Street 7, City 8', 'user7@example.com', 'password7', '+56945672230'),
(8, 'user_8', 'Street 8, City 7', 'user8@example.com', 'password8', '+56915422477'),
(9, 'user_9', 'Street 9, City 8', 'user9@example.com', 'password9', '+56969754723'),
(10, 'user_10', 'Street 10, City 3', 'user10@example.com', 'password10', '+56975219943'),
(11, 'user_11', 'Street 11, City 2', 'user11@example.com', 'password11', '+56952681740'),
(12, 'user_12', 'Street 12, City 4', 'user12@example.com', 'password12', '+56926153006'),
(13, 'user_13', 'Street 13, City 10', 'user13@example.com', 'password13', '+56915495386'),
(14, 'user_14', 'Street 14, City 3', 'user14@example.com', 'password14', '+56974282011'),
(15, 'user_15', 'Street 15, City 1', 'user15@example.com', 'password15', '+56981776810'),
(16, 'user_16', 'Street 16, City 8', 'user16@example.com', 'password16', '+56994174036'),
(17, 'user_17', 'Street 17, City 10', 'user17@example.com', 'password17', '+56926806878'),
(18, 'user_18', 'Street 18, City 10', 'user18@example.com', 'password18', '+56967100641'),
(19, 'user_19', 'Street 19, City 6', 'user19@example.com', 'password19', '+56932870016'),
(20, 'user_20', 'Street 20, City 2', 'user20@example.com', 'password20', '+56910191446');

INSERT INTO TAREA (id_tarea, titulo, descripcion, fecha_creacion, fecha_termino, estado, id_usuario)
VALUES
(1, 'Tarea 1', 'Descripcion de la tarea 1', '2024-11-27', '2024-12-22', false, 7),
(2, 'Tarea 2', 'Descripcion de la tarea 2', '2024-06-24', '2024-07-07', true, 8),
(3, 'Tarea 3', 'Descripcion de la tarea 3', '2024-05-26', '2024-05-29', false, 9),
(4, 'Tarea 4', 'Descripcion de la tarea 4', '2024-03-06', '2024-03-23', false, 9),
(5, 'Tarea 5', 'Descripcion de la tarea 5', '2024-07-01', '2024-07-21', true, 6),
(6, 'Tarea 6', 'Descripcion de la tarea 6', '2024-07-19', '2024-08-17', true, 11),
(7, 'Tarea 7', 'Descripcion de la tarea 7', '2024-02-21', '2024-02-24', true, 18),
(8, 'Tarea 8', 'Descripcion de la tarea 8', '2024-04-23', '2024-05-15', true, 5),
(9, 'Tarea 9', 'Descripcion de la tarea 9', '2024-06-24', '2024-06-29', true, 17),
(10, 'Tarea 10', 'Descripcion de la tarea 10', '2024-12-04', '2024-12-16', false, 12),
(11, 'Tarea 11', 'Descripcion de la tarea 11', '2024-07-27', '2024-08-04', false, 8),
(12, 'Tarea 12', 'Descripcion de la tarea 12', '2024-05-04', '2024-05-22', false, 13),
(13, 'Tarea 13', 'Descripcion de la tarea 13', '2024-10-03', '2024-10-09', true, 5),
(14, 'Tarea 14', 'Descripcion de la tarea 14', '2024-04-26', '2024-05-06', false, 15),
(15, 'Tarea 15', 'Descripcion de la tarea 15', '2024-01-12', '2024-02-01', false, 14),
(16, 'Tarea 16', 'Descripcion de la tarea 16', '2024-01-14', '2024-01-19', false, 11),
(17, 'Tarea 17', 'Descripcion de la tarea 17', '2024-11-27', '2024-11-28', false, 15),
(18, 'Tarea 18', 'Descripcion de la tarea 18', '2024-01-22', '2024-02-17', false, 8),
(19, 'Tarea 19', 'Descripcion de la tarea 19', '2024-06-01', '2024-06-25', false, 13),
(20, 'Tarea 20', 'Descripcion de la tarea 20', '2024-06-16', '2024-06-22', false, 19);

