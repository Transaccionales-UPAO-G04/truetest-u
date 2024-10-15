-- INSERT para la tabla carreras (15 ejemplos)
INSERT INTO carreras (nombre_carrera, descripcion_carrera) VALUES
                                                               ('Ingeniería de Sistemas', 'Carrera orientada al desarrollo de software y sistemas informáticos.'),
                                                               ('Psicología', 'Carrera dedicada al estudio del comportamiento humano y sus procesos mentales.'),
                                                               ('Medicina', 'Carrera orientada al cuidado y la salud humana.'),
                                                               ('Derecho', 'Carrera dedicada al estudio y aplicación de la ley.'),
                                                               ('Arquitectura', 'Carrera enfocada en el diseño y construcción de edificaciones.'),
                                                               ('Ingeniería Civil', 'Carrera orientada a la construcción de infraestructura.'),
                                                               ('Contabilidad', 'Carrera dedicada a la administración financiera y contable.'),
                                                               ('Ingeniería Industrial', 'Carrera orientada a la optimización de procesos industriales.'),
                                                               ('Administración de Empresas', 'Carrera enfocada en la gestión empresarial.'),
                                                               ('Diseño Gráfico', 'Carrera orientada al diseño visual y la comunicación.'),
                                                               ('Marketing', 'Carrera enfocada en la promoción y ventas de productos y servicios.'),
                                                               ('Biología', 'Carrera orientada al estudio de los seres vivos.'),
                                                               ('Química', 'Carrera dedicada al estudio de las propiedades de la materia.'),
                                                               ('Física', 'Carrera orientada al estudio de las leyes fundamentales del universo.'),
                                                               ('Ingeniería Mecánica', 'Carrera orientada al diseño y construcción de maquinaria.');

-- INSERT para la tabla especialidades (15 ejemplos)
INSERT INTO especialidades (nombre, descripcion, puntaje_aproximado, carrera_id) VALUES
                                                                                     ('Sistemas Computacionales', 'Especialidad en desarrollo de software y sistemas.', 85, 1),
                                                                                     ('Neurociencia', 'Especialidad dedicada al estudio de los procesos neuronales.', 75, 2),
                                                                                     ('Medicina General', 'Especialidad médica general.', 90, 3),
                                                                                     ('Derecho Civil', 'Especialidad en derecho civil.', 85, 4),
                                                                                     ('Arquitectura Sostenible', 'Especialidad enfocada en arquitectura sostenible.', 80, 5),
                                                                                     ('Ingeniería Estructural', 'Especialidad en diseño estructural para construcciones.', 82, 6),
                                                                                     ('Auditoría Financiera', 'Especialidad en revisión de cuentas financieras.', 78, 7),
                                                                                     ('Logística Industrial', 'Especialidad en procesos logísticos.', 77, 8),
                                                                                     ('Gestión de Empresas', 'Especialidad en la gestión empresarial.', 81, 9),
                                                                                     ('Diseño Web', 'Especialidad en el diseño de interfaces web.', 79, 10),
                                                                                     ('Marketing Digital', 'Especialidad en estrategias de marketing en línea.', 76, 11),
                                                                                     ('Genética', 'Especialidad en el estudio del ADN y los genes.', 88, 12),
                                                                                     ('Química Orgánica', 'Especialidad en compuestos de carbono.', 86, 13),
                                                                                     ('Física Teórica', 'Especialidad en el estudio de teorías físicas.', 87, 14),
                                                                                     ('Ingeniería Automotriz', 'Especialidad en diseño y fabricación de vehículos.', 84, 15);

-- INSERT para la tabla estudiante (15 ejemplos)
INSERT INTO estudiante (nombre, email, contraseña, estado_plan, estado_cuenta) VALUES
                                                                                   ('Juan Pérez', 'juan.perez@example.com', 'password123', 'NOPREMIUM', 'HABILITADO'),
                                                                                   ('Ana López', 'ana.lopez@example.com', 'password456', 'PREMIUM', 'HABILITADO'),
                                                                                   ('Carlos Ramírez', 'carlos.ramirez@example.com', 'password789', 'NOPREMIUM', 'INHABILITADO'),
                                                                                   ('Lucía Fernández', 'lucia.fernandez@example.com', 'password101', 'PREMIUM', 'HABILITADO'),
                                                                                   ('María García', 'maria.garcia@example.com', 'password202', 'NOPREMIUM', 'HABILITADO'),
                                                                                   ('Luis Torres', 'luis.torres@example.com', 'password303', 'PREMIUM', 'HABILITADO'),
                                                                                   ('Elena Ruiz', 'elena.ruiz@example.com', 'password404', 'NOPREMIUM', 'INHABILITADO'),
                                                                                   ('Javier Ortega', 'javier.ortega@example.com', 'password505', 'PREMIUM', 'HABILITADO'),
                                                                                   ('Rosa Sánchez', 'rosa.sanchez@example.com', 'password606', 'NOPREMIUM', 'HABILITADO'),
                                                                                   ('Miguel Castro', 'miguel.castro@example.com', 'password707', 'PREMIUM', 'INHABILITADO'),
                                                                                   ('Isabel Hernández', 'isabel.hernandez@example.com', 'password808', 'PREMIUM', 'HABILITADO'),
                                                                                   ('Pedro Moreno', 'pedro.moreno@example.com', 'password909', 'NOPREMIUM', 'HABILITADO'),
                                                                                   ('Daniela Vega', 'daniela.vega@example.com', 'password010', 'PREMIUM', 'HABILITADO'),
                                                                                   ('Raúl Flores', 'raul.flores@example.com', 'password111', 'NOPREMIUM', 'INHABILITADO'),
                                                                                   ('Carmen Rojas', 'carmen.rojas@example.com', 'password212', 'PREMIUM', 'HABILITADO');
-- INSERT para la tabla mentor (15 ejemplos)
INSERT INTO mentor (nombre, email, contraseña, especialidad, experiencia) VALUES
                                                                              ('Carlos Martínez', 'carlos.martinez@example.com', 'password789', 'Sistemas Computacionales', '10 años de experiencia en desarrollo de software'),
                                                                              ('Elena Ramírez', 'elena.ramirez@example.com', 'password123', 'Neurociencia', '5 años de experiencia en investigación neurocientífica'),
                                                                              ('José Ruiz', 'jose.ruiz@example.com', 'password303', 'Medicina General', '15 años de experiencia en medicina general'),
                                                                              ('María Sánchez', 'maria.sanchez@example.com', 'password404', 'Derecho Civil', '10 años de experiencia en derecho civil'),
                                                                              ('Laura López', 'laura.lopez@example.com', 'password505', 'Arquitectura Sostenible', '8 años de experiencia en arquitectura sostenible'),
                                                                              ('Pedro Torres', 'pedro.torres@example.com', 'password606', 'Ingeniería Estructural', '12 años de experiencia en ingeniería civil'),
                                                                              ('Marta Fernández', 'marta.fernandez@example.com', 'password707', 'Auditoría Financiera', '7 años de experiencia en auditorías financieras'),
                                                                              ('Luis Gómez', 'luis.gomez@example.com', 'password808', 'Logística Industrial', '9 años de experiencia en logística'),
                                                                              ('Isabel Romero', 'isabel.romero@example.com', 'password909', 'Gestión de Empresas', '11 años de experiencia en gestión empresarial'),
                                                                              ('Raúl Pérez', 'raul.perez@example.com', 'password010', 'Diseño Web', '6 años de experiencia en diseño de interfaces'),
                                                                              ('Rosa García', 'rosa.garcia@example.com', 'password111', 'Marketing Digital', '8 años de experiencia en marketing digital'),
                                                                              ('Jorge Vega', 'jorge.vega@example.com', 'password212', 'Genética', '12 años de experiencia en investigación genética'),
                                                                              ('Lucía Castro', 'lucia.castro@example.com', 'password313', 'Química Orgánica', '10 años de experiencia en investigación química'),
                                                                              ('Miguel Herrera', 'miguel.herrera@example.com', 'password414', 'Física Teórica', '14 años de experiencia en física teórica'),
                                                                              ('Daniel Sánchez', 'daniel.sanchez@example.com', 'password515', 'Ingeniería Automotriz', '13 años de experiencia en el sector automotriz.');
-- INSERT para la tabla plan (15 ejemplos)
INSERT INTO plan (nombre_plan, precio, descripcion_plan, fecha_inicio, fecha_fin, acceso_ilimitado) VALUES
                                                                                                        ('Plan Básico', 9.99, 'Acceso limitado a los recursos', '2024-01-01', '2024-12-31', FALSE),
                                                                                                        ('Plan Premium', 19.99, 'Acceso ilimitado a todos los recursos', '2024-01-01', '2024-12-31', TRUE),
                                                                                                        ('Plan Estándar', 14.99, 'Acceso limitado a recursos seleccionados', '2024-01-01', '2024-12-31', FALSE);
-- INSERT para la tabla pregunta (15 ejemplos)
INSERT INTO pregunta (pregunta, punto) VALUES
                                           ('¿Te interesa el desarrollo de software?', 5),
                                           ('¿Te gusta resolver conflictos legales?', 4),
                                           ('¿Te interesa la investigación médica?', 5),
                                           ('¿Te gustaría trabajar en el campo de la arquitectura?', 4),
                                           ('¿Te interesa la administración financiera?', 5),
                                           ('¿Te gustaría trabajar en el diseño gráfico?', 4),
                                           ('¿Te apasiona la ingeniería industrial?', 5),
                                           ('¿Te gustaría trabajar en marketing digital?', 4),
                                           ('¿Te interesa el campo de la biología?', 5),
                                           ('¿Te gustaría investigar sobre genética?', 4),
                                           ('¿Te gustaría trabajar en el desarrollo de software?', 5),
                                           ('¿Te interesa la contabilidad?', 4),
                                           ('¿Te apasiona la química?', 5),
                                           ('¿Te gustaría trabajar en la física teórica?', 4),
                                           ('¿Te interesa la ingeniería automotriz?', 5);
-- INSERT para la tabla prueba_vocacional (15 ejemplos)
INSERT INTO prueba_vocacional (nro_prueba, fecha, id_estudiante) VALUES
                                                                     (1, '2024-09-01', 1),
                                                                     (2, '2024-09-02', 2),
                                                                     (3, '2024-09-03', 3),
                                                                     (4, '2024-09-04', 4),
                                                                     (5, '2024-09-05', 5),
                                                                     (6, '2024-09-06', 6),
                                                                     (7, '2024-09-07', 7),
                                                                     (8, '2024-09-08', 8),
                                                                     (9, '2024-09-09', 9),
                                                                     (10, '2024-09-10', 10),
                                                                     (11, '2024-09-11', 11),
                                                                     (12, '2024-09-12', 12),
                                                                     (13, '2024-09-13', 13),
                                                                     (14, '2024-09-14', 14),
                                                                     (15, '2024-09-15', 15);
-- INSERT para la tabla respuestas (15 ejemplos)
INSERT INTO respuestas (opciones) VALUES
                                      ('Sí'),
                                      ('No'),
                                      ('Tal vez'),
                                      ('No lo sé');

-- INSERT para la tabla resultado_prueba (15 ejemplos)
INSERT INTO resultado_prueba (puntaje, recomendacion, id_prueba_vocacional) VALUES
                                                                                (85, 'Recomendado para Ingeniería de Sistemas', 1),
                                                                                (75, 'Recomendado para Psicología', 2),
                                                                                (90, 'Recomendado para Derecho', 3),
                                                                                (80, 'Recomendado para Medicina', 4),
                                                                                (70, 'Recomendado para Arquitectura', 5),
                                                                                (95, 'Recomendado para Ingeniería Civil', 6),
                                                                                (65, 'Recomendado para Contabilidad', 7),
                                                                                (85, 'Recomendado para Ingeniería Industrial', 8),
                                                                                (88, 'Recomendado para Administración de Empresas', 9),
                                                                                (75, 'Recomendado para Diseño Gráfico', 10),
                                                                                (78, 'Recomendado para Marketing', 11),
                                                                                (92, 'Recomendado para Biología', 12),
                                                                                (85, 'Recomendado para Química', 13),
                                                                                (80, 'Recomendado para Física', 14),
                                                                                (89, 'Recomendado para Ingeniería Mecánica', 15);
-- INSERT para la tabla reseña (15 ejemplos)
INSERT INTO reseña (texto, calificacion, id_mentor, id_estudiante) VALUES
                                                                       ('Excelente mentor, muy recomendado.', 5, 1, 1),
                                                                       ('Muy profesional y atento.', 4, 2, 2),
                                                                       ('Excelente orientación, muy útil.', 5, 3, 3),
                                                                       ('Conocedor del tema, muy profesional.', 4, 4, 4),
                                                                       ('Una gran ayuda en mi desarrollo profesional.', 5, 5),
                                                                       ('Agradable y bien informado.', 3, 6, 6),
                                                                       ('Puntual y comprometido.', 5, 7, 7),
                                                                       ('Excelente experiencia, muy agradecido.', 5, 8, 8),
                                                                       ('Muy bien organizado.', 4, 9, 9),
                                                                       ('Ayuda invaluable en mi carrera.', 5, 10, 10),
                                                                       ('Me proporcionó muchas herramientas útiles.', 5, 11, 11),
                                                                       ('Conocimientos prácticos y aplicables.', 4, 12, 12),
                                                                       ('Buena mentoría, pero podría mejorar en ciertos aspectos.', 3, 13, 13),
                                                                       ('Me ayudó a ver diferentes perspectivas.', 4, 14, 14),
                                                                       ('Muy recomendable para cualquier estudiante.', 5, 15, 15);
-- INSERT para la tabla pago (15 ejemplos)
INSERT INTO pago (monto, metodo_pago, fecha_pago, id_estudiante, id_plan) VALUES
                                                                              (9.99, 'Tarjeta de Crédito', '2024-01-05', 1, 1),
                                                                              (19.99, 'Paypal', '2024-01-06', 2, 2),
                                                                              (9.99, 'Tarjeta de Débito', '2024-01-07', 3, 1),
                                                                              (19.99, 'Paypal', '2024-01-08', 4, 2),
                                                                              (49.99, 'Tarjeta de Crédito', '2024-01-09', 5, 5),
                                                                              (14.99, 'Tarjeta de Crédito', '2024-01-10', 6, 3),
                                                                              (29.99, 'Paypal', '2024-01-11', 7, 4),
                                                                              (5.99, 'Tarjeta de Débito', '2024-01-12', 8, 5),
                                                                              (24.99, 'Paypal', '2024-01-13', 9, 6),
                                                                              (49.99, 'Tarjeta de Crédito', '2024-01-14', 10, 7),
                                                                              (89.99, 'Paypal', '2024-01-15', 11, 8),
                                                                              (199.99, 'Tarjeta de Crédito', '2024-01-16', 12, 9),
                                                                              (99.99, 'Paypal', '2024-01-17', 13, 10),
                                                                              (29.99, 'Tarjeta de Débito', '2024-01-18', 14, 11),
                                                                              (59.99, 'Paypal', '2024-01-19', 15, 12);
-- INSERT para la tabla horario (15 ejemplos)
INSERT INTO horario (dia_semana, hora_inicio, hora_fin, id_mentor) VALUES
                                                                       ('Lunes', '09:00', '11:00', 1),
                                                                       ('Martes', '14:00', '16:00', 2),
                                                                       ('Miércoles', '10:00', '12:00', 3),
                                                                       ('Jueves', '15:00', '17:00', 4),
                                                                       ('Viernes', '13:00', '15:00', 5),
                                                                       ('Sábado', '09:00', '11:00', 6),
                                                                       ('Domingo', '10:00', '12:00', 7),
                                                                       ('Lunes', '08:00', '10:00', 8),
                                                                       ('Martes', '13:00', '15:00', 9),
                                                                       ('Miércoles', '11:00', '13:00', 10),
                                                                       ('Jueves', '16:00', '18:00', 11),
                                                                       ('Viernes', '12:00', '14:00', 12),
                                                                       ('Sábado', '10:00', '12:00', 13),
                                                                       ('Domingo', '09:00', '11:00', 14),
                                                                       ('Lunes', '14:00', '16:00', 15);
