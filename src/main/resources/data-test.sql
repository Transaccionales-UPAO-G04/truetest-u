/*DROP TABLE IF EXISTS respuestas CASCADE;
DROP TABLE IF EXISTS resultado_prueba CASCADE;
DROP TABLE IF EXISTS reseña CASCADE;
DROP TABLE IF EXISTS preguntas CASCADE;
DROP TABLE IF EXISTS prueba_vocacional CASCADE;
DROP TABLE IF EXISTS horario CASCADE;
DROP TABLE IF EXISTS pago CASCADE;
DROP TABLE IF EXISTS plan CASCADE;
DROP TABLE IF EXISTS estudiante CASCADE;
DROP TABLE IF EXISTS mentor CASCADE;
DROP TABLE IF EXISTS especialidades CASCADE;
DROP TABLE IF EXISTS carreras CASCADE;*/




-- INSERT para la tabla carreras
INSERT INTO carrera (nombre_carrera, descripcion_carrera) VALUES
                                                              ('Ingeniería de Sistemas', 'Carrera orientada al desarrollo de software y sistemas informáticos.'),
                                                              ('Psicología', 'Carrera dedicada al estudio del comportamiento humano y procesos mentales.'),
                                                              ('Medicina', 'Carrera orientada al cuidado de la salud humana.'),
                                                              ('Derecho', 'Carrera centrada en el estudio de la ley y la justicia.'),
                                                              ('Arquitectura', 'Carrera dedicada al diseño y construcción de edificaciones.');

-- INSERT para la tabla especialidades
INSERT INTO especialidad (nombre, descripcion, puntaje_aproximado, carrera_id) VALUES
                                                                                   ('Desarrollo de Software', 'Especialidad enfocada en el diseño y programación de aplicaciones.', 85, 1),
                                                                                   ('Neuropsicología', 'Especialidad en el estudio de los procesos neuronales.', 78, 2),
                                                                                   ('Medicina General', 'Especialidad médica general.', 90, 3),
                                                                                   ('Derecho Civil', 'Especialidad enfocada en el derecho civil y familiar.', 85, 4),
                                                                                   ('Arquitectura Sostenible', 'Diseño y construcción con un enfoque ecológico.', 82, 5);


-- Inserts para la tabla Roles
INSERT INTO roles (name) VALUES
                             ('ADMIN'),
                             ('ESTUDIANTE'),
                             ('MENTOR');


INSERT INTO usuario (email, contraseña, role_id) VALUES
                                                     ('jua@correo.com', 'pass123', 2),                   -- Role 'ESTUDIANTE'
                                                     ('maria.garcia@correo.com', 'secure456', 2),        -- Role 'ESTUDIANTE'
                                                     ('carlos.sanchez@correo.com', 'strong789', 2),      -- Role 'ESTUDIANTE'
                                                     ('luisa.martinez@correo.com', 'luisa123', 2),       -- Role 'ESTUDIANTE'
                                                     ('jose.ramirez@correo.com', 'jose456', 2),          -- Role 'ESTUDIANTE'
                                                     ('ana.lopez@correo.com', 'mentorpass', 3),          -- Role 'MENTOR'
                                                     ('pedro.diaz@correo.com', 'mentorsecure', 3),       -- Role 'MENTOR'
                                                     ('lucia.fernandez@correo.com', 'mentor456', 3),     -- Role 'MENTOR'
                                                     ('elena.munoz@correo.com', 'elena789', 3),          -- Role 'MENTOR'
                                                     ('admin@correo.com', 'admin123', 1);                -- Role 'ADMIN'


-- INSERT para la tabla estudiante
INSERT INTO estudiante (nombre_estudiante, estado_plan, estado_cuenta, usuario_id, plan_id) VALUES
                                                                                                ('Juan Pérez', 'NOPREMIUM', 'HABILITADO', 1, NULL),
                                                                                         ('María García', 'PREMIUM', 'HABILITADO', 2, 1),   -- Asignar un plan específico si lo tienes
                                                                                                ('Carlos Sánchez', 'NOPREMIUM', 'INHABILITADO', 3, NULL),
                                                                                                ('Luisa Martínez', 'PREMIUM', 'HABILITADO', 4, 1),   -- Asignar un plan específico si lo tienes
                                                                                                ('José Ramírez', 'NOPREMIUM', 'HABILITADO', 5, NULL);
-- INSERT para la tabla mentor
INSERT INTO mentor (nombre_mentor, experiencia, especialidad, link_recurso, link_recurso_premium, usuario_id, especialidad_id) VALUES
                                                                                                                                   ('Ana López', '5 años en orientación vocacional', 'Psicología', 'http://recursos.com/ana/estandar', 'http://recursos.com/ana/premium', 6, 2),
                                                                                                                                   ('Pedro Díaz', '3 años en coaching de carrera', 'Educación', 'http://coaching.com/pedro/estandar', 'http://coaching.com/pedro/premium', 7, NULL),  -- Asume que tienes una especialidad en 'Educación'
                                                                                                                                   ('Lucía Fernández', '10 años en desarrollo profesional', 'Desarrollo Personal', 'http://desarrollop.com/lucia/estandar', 'http://desarrollop.com/lucia/premium', 8, NULL),  -- Asume que tienes una especialidad en 'Desarrollo Personal'
                                                                                                                                   ('Elena Muñoz', '8 años en orientación académica', 'Orientación Académica', 'http://orientacion.com/elena/estandar', 'http://orientacion.com/elena/premium', 9, NULL),  -- Asume que tienes una especialidad en 'Orientación Académica'
                                                                                                                                   ('Raúl Torres', '6 años en liderazgo juvenil', 'Liderazgo', 'http://liderazgo.com/raul/estandar', 'http://liderazgo.com/raul/premium', 10, NULL);  -- Asume que tienes una especialidad en 'Liderazgo'


-- INSERT para la tabla horario
INSERT INTO horario (fecha_hora, link_sesion, mentor_id) VALUES
                                                             ('2024-09-01 09:00:00', 'https://example.com/session1', 1),
                                                             ('2024-09-02 10:00:00', 'https://example.com/session2', 2),
                                                             ('2024-09-03 11:00:00', 'https://example.com/session3', 3),
                                                             ('2024-09-04 12:00:00', 'https://example.com/session4', 4),
                                                             ('2024-09-05 13:00:00', 'https://example.com/session5', 5);

-- INSERT para la tabla plan
INSERT INTO plan (nombre_plan, precio, descripcion_plan, fecha_inicio, fecha_fin, id_estudiante) VALUES
                                                                                                     ('Plan Básico', 9.99, 'Acceso limitado a recursos básicos.', '2024-01-01', '2024-12-31', 1),
                                                                                                     ('Plan Premium', 19.99, 'Acceso ilimitado a todos los recursos.', '2024-01-01', '2024-12-31', 2),
                                                                                                     ('Plan Estándar', 14.99, 'Acceso limitado a recursos seleccionados.', '2024-01-01', '2024-12-31', 3),
                                                                                                     ('Plan Avanzado', 29.99, 'Acceso a recursos avanzados.', '2024-01-01', '2024-12-31', 4),
                                                                                                     ('Plan Estudiante', 5.99, 'Acceso para estudiantes con restricciones.', '2024-01-01', '2024-12-31', 5);


-- INSERT para la tabla pago
INSERT INTO pago (monto, metodo_pago, fecha_pago, estado_pago, id_plan, id_estudiante, created_at) VALUES
                                                                                                       (9.99, 'Tarjeta de Crédito', '2024-01-05', 'Completado', 1, 1, '2024-01-05 10:00:00'),
                                                                                                       (19.99, 'Paypal', '2024-01-06', 'Completado', 2, 2, '2024-01-06 11:00:00'),
                                                                                                       (29.99, 'Tarjeta de Débito', '2024-01-07', 'Pendiente', 3, 3, '2024-01-07 12:00:00'),
                                                                                                       (39.99, 'Transferencia Bancaria', '2024-01-08', 'Completado', 4, 4, '2024-01-08 13:00:00'),
                                                                                                       (49.99, 'Paypal', '2024-01-09', 'Completado', 5, 5, '2024-01-09 14:00:00');


-- INSERT para la tabla pregunta
INSERT INTO pregunta (pregunta, punto, id_prueba_vocacional) VALUES
                                                                 ('¿Te interesa el desarrollo de software?', 5, 1),
                                                                 ('¿Te atrae el comportamiento humano?', 4, 2),
                                                                 ('¿Te apasiona la medicina?', 5, 3),
                                                                 ('¿Te gustaría ser abogado?', 4, 4),
                                                                 ('¿Te interesa el diseño arquitectónico?', 5, 5);


-- INSERT para la tabla prueba_vocacional
INSERT INTO prueba_vocacional (nro_prueba, fecha, id_estudiante) VALUES
                                                                     (1, '2024-09-01', 1),
                                                                     (2, '2024-09-02', 2),
                                                                     (3, '2024-09-03', 3),
                                                                     (4, '2024-09-04', 4),
                                                                     (5, '2024-09-05', 5);


-- INSERT para la tabla reseña
INSERT INTO reseña (texto, calificacion, id_mentor, id_estudiante) VALUES
                                                                       ('Excelente mentor, muy recomendado.', 5, 1, 1),
                                                                       ('Muy profesional y atento.', 4, 2, 2),
                                                                       ('Excelente orientación, muy útil.', 5, 3, 3),
                                                                       ('Conocedor del tema, muy profesional.', 4, 4, 4),
                                                                       ('Una gran ayuda en mi carrera.', 5, 5, 5);



-- INSERT para la tabla respuestas
INSERT INTO respuestas (opciones, especialidad_id, pregunta_id) VALUES
                                                                    ('Sí', 1, 1),
                                                                    ('No', 2, 2),
                                                                    ('Tal vez', 3, 3),
                                                                    ('No lo sé', 4, 4),
                                                                    ('Prefiero no decirlo', 5, 5);



-- INSERT para la tabla resultado_prueba
INSERT INTO resultado_prueba (puntaje, recomendacion, id_prueba_vocacional) VALUES
                                                                                (85, 'Recomendado para Ingeniería de Sistemas', 1),
                                                                                (75, 'Recomendado para Psicología', 2),
                                                                                (90, 'Recomendado para Derecho', 3),
                                                                                (80, 'Recomendado para Medicina', 4),
                                                                                (70, 'Recomendado para Arquitectura', 5);

-- INSERT para la tabla compra
INSERT INTO compra (monto, created_at, estado_pago, usuario_id, id_plan) VALUES
                                                                             (29.99, '2024-01-05 10:00:00', 'COMPLETADO', 1, 1), -- Compra realizada por usuario 1, Plan 1
                                                                             (49.99, '2024-01-06 11:00:00', 'PENDIENTE', 2, 2), -- Compra realizada por usuario 2, Plan 2
                                                                             (19.99, '2024-01-07 12:00:00', 'COMPLETADO', 3, 3), -- Compra realizada por usuario 3, Plan 3
                                                                             (39.99, '2024-01-08 13:00:00', 'COMPLETADO', 4, 4), -- Compra realizada por usuario 4, Plan 4
                                                                             (59.99, '2024-01-09 14:00:00', 'COMPLETADO', 5, 5); -- Compra realizada por usuario 5, Plan 5

-- INSERT para la tabla compra_items
INSERT INTO compra_items (precio, id_plan, compra_id) VALUES
                                                          (29.99, 1, 1), -- Compra item relacionado con la compra 1, Plan 1
                                                          (49.99, 2, 2), -- Compra item relacionado con la compra 2, Plan 2
                                                          (19.99, 3, 3), -- Compra item relacionado con la compra 3, Plan 3
                                                          (39.99, 4, 4), -- Compra item relacionado con la compra 4, Plan 4
                                                          (59.99, 5, 5); -- Compra item relacionado con la compra 5, Plan 5

