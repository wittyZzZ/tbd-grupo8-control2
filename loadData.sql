\encoding UTF8

INSERT INTO USUARIO (id_usuario, username, direccion, email, contrasena, telefono)
VALUES
(1, 'user_1', 'Street 1, City 4', 'user1@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56935303864'),
(2, 'user_2', 'Street 2, City 5', 'user2@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56922531069'),
(3, 'user_3', 'Street 3, City 5', 'user3@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56913446058'),
(4, 'user_4', 'Street 4, City 3', 'user4@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56942749550'),
(5, 'user_5', 'Street 5, City 6', 'user5@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56985843537'),
(6, 'user_6', 'Street 6, City 3', 'user6@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56916010600'),
(7, 'user_7', 'Street 7, City 8', 'user7@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56945672230'),
(8, 'user_8', 'Street 8, City 7', 'user8@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56915422477'),
(9, 'user_9', 'Street 9, City 8', 'user9@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56969754723'),
(10, 'user_10', 'Street 10, City 3', 'user10@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56975219943'),
(11, 'user_11', 'Street 11, City 2', 'user11@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56952681740'),
(12, 'user_12', 'Street 12, City 4', 'user12@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56926153006'),
(13, 'user_13', 'Street 13, City 10', 'user13@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56915495386'),
(14, 'user_14', 'Street 14, City 3', 'user14@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56974282011'),
(15, 'user_15', 'Street 15, City 1', 'user15@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56981776810'),
(16, 'user_16', 'Street 16, City 8', 'user16@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56994174036'),
(17, 'user_17', 'Street 17, City 10', 'user17@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56926806878'),
(18, 'user_18', 'Street 18, City 10', 'user18@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56967100641'),
(19, 'user_19', 'Street 19, City 6', 'user19@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56932870016'),
(20, 'user_20', 'Street 20, City 2', 'user20@example.com', '$2a$10$oPaHQ9If2AreZLvYLy1Q3.s0Z1eOngyOdB720x81ooKYRIgmWnB1.', '+56910191446');

INSERT INTO TAREA (id_tarea, titulo, descripcion, fecha_creacion, fecha_termino, estado, id_usuario)
VALUES
(1, 'Tarea 1', 'Descripcion de la tarea 1', '2024-02-02', '2024-03-03', 'Pendiente', 2),
(2, 'Tarea 2', 'Descripcion de la tarea 2', '2024-09-01', '2024-09-15', 'Pendiente', 17),
(3, 'Tarea 3', 'Descripcion de la tarea 3', '2024-05-19', '2024-05-22', 'Pendiente', 14),
(4, 'Tarea 4', 'Descripcion de la tarea 4', '2024-03-31', '2024-04-09', 'Pendiente', 11),
(5, 'Tarea 5', 'Descripcion de la tarea 5', '2024-04-27', '2024-05-24', 'Pendiente', 18),
(6, 'Tarea 6', 'Descripcion de la tarea 6', '2024-08-22', '2024-09-19', 'Completada', 19),
(7, 'Tarea 7', 'Descripcion de la tarea 7', '2024-12-03', '2024-12-20', 'Completada', 2),
(8, 'Tarea 8', 'Descripcion de la tarea 8', '2024-11-23', '2024-12-01', 'Completada', 5),
(9, 'Tarea 9', 'Descripcion de la tarea 9', '2024-12-28', '2025-01-10', 'Completada', 10),
(10, 'Tarea 10', 'Descripcion de la tarea 10', '2024-01-26', '2024-02-04', 'Pendiente', 7),
(11, 'Tarea 11', 'Descripcion de la tarea 11', '2024-03-29', '2024-04-26', 'Completada', 10),
(12, 'Tarea 12', 'Descripcion de la tarea 12', '2024-09-18', '2024-09-30', 'Completada', 4),
(13, 'Tarea 13', 'Descripcion de la tarea 13', '2024-07-13', '2024-07-21', 'Completada', 19),
(14, 'Tarea 14', 'Descripcion de la tarea 14', '2024-09-04', '2024-09-21', 'Pendiente', 19),
(15, 'Tarea 15', 'Descripcion de la tarea 15', '2024-07-06', '2024-07-11', 'Pendiente', 13),
(16, 'Tarea 16', 'Descripcion de la tarea 16', '2024-10-30', '2024-11-12', 'Caducada', 11),
(17, 'Tarea 17', 'Descripcion de la tarea 17', '2024-01-22', '2024-02-01', 'Caducada', 13),
(18, 'Tarea 18', 'Descripcion de la tarea 18', '2024-12-18', '2024-12-28', 'Completada', 13),
(19, 'Tarea 19', 'Descripcion de la tarea 19', '2024-03-17', '2024-04-07', 'Pendiente', 1),
(20, 'Tarea 20', 'Descripcion de la tarea 20', '2024-01-17', '2024-02-12', 'Pendiente', 7);


