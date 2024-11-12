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
INSERT INTO carreras (nombre_carrera, descripcion_carrera) VALUES
                                                               ('Ingeniería de Sistemas', 'Carrera orientada al desarrollo de software y sistemas informáticos.'),
                                                               ('Psicología', 'Carrera dedicada al estudio del comportamiento humano y procesos mentales.'),
                                                               ('Medicina', 'Carrera orientada al cuidado de la salud humana.'),
                                                               ('Derecho', 'Carrera centrada en el estudio de la ley y la justicia.'),
                                                               ('Arquitectura', 'Carrera dedicada al diseño y construcción de edificaciones.');
-- INSERT para la tabla especialidades
INSERT INTO especialidades (nombre, descripcion, puntaje_aproximado, carrera_id) VALUES
                                                                                     ('Desarrollo de Software', 'Especialidad enfocada en el diseño y programación de aplicaciones.', 85, 1),
                                                                                     ('Neuropsicología', 'Especialidad en el estudio de los procesos neuronales.', 78, 2),
                                                                                     ('Medicina General', 'Especialidad médica general.', 90, 3),
                                                                                     ('Derecho Civil', 'Especialidad enfocada en el derecho civil y familiar.', 85, 4),
                                                                                     ('Arquitectura Sostenible', 'Diseño y construcción con un enfoque ecológico.', 82, 5);
-- INSERT para la tabla estudiante
-- Inserts para la tabla Roles
INSERT INTO roles (name) VALUES
                             ('ADMIN'),
                             ('ESTUDIANTE'),
                             ('MENTOR');

INSERT INTO usuario (email, password, role_id) VALUES
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

INSERT INTO estudiante (nombre_estudiante, estado_plan, estado_cuenta, usuario_id) VALUES
                                                                                       ('Juan Pérez', 'NOPREMIUM', 'HABILITADO', 1),
                                                                                       ('María García', 'PREMIUM', 'HABILITADO', 2),
                                                                                       ('Carlos Sánchez', 'NOPREMIUM', 'INHABILITADO', 3),
                                                                                       ('Luisa Martínez', 'PREMIUM', 'HABILITADO', 4),
                                                                                       ('José Ramírez', 'NOPREMIUM', 'HABILITADO', 5);
-- INSERT para la tabla mentor
INSERT INTO mentor (nombre_mentor, experiencia, especialidad, link_recurso, link_recurso_premium, usuario_id) VALUES
                                                                                                                  ('Ana López', '5 años en orientación vocacional', 'Psicología', 'http://recursos.com/ana/estandar', 'http://recursos.com/ana/premium', 6),
                                                                                                                  ('Pedro Díaz', '3 años en coaching de carrera', 'Educación', 'http://coaching.com/pedro/estandar', 'http://coaching.com/pedro/premium', 7),
                                                                                                                  ('Lucía Fernández', '10 años en desarrollo profesional', 'Desarrollo Personal', 'http://desarrollop.com/lucia/estandar', 'http://desarrollop.com/lucia/premium', 8),
                                                                                                                  ('Elena Muñoz', '8 años en orientación académica', 'Orientación Académica', 'http://orientacion.com/elena/estandar', 'http://orientacion.com/elena/premium', 9),
                                                                                                                  ('Raúl Torres', '6 años en liderazgo juvenil', 'Liderazgo', 'http://liderazgo.com/raul/estandar', 'http://liderazgo.com/raul/premium', 10);
-- INSERT para la tabla horario       -- Role 'ADMIN'
INSERT INTO horario (fecha_hora, hora_sesion, link_sesion, id_mentor) VALUES
                                                                          ('2024-09-01 09:00:00', '09:00', 'https://example.com/session1', 1),
                                                                          ('2024-09-02 10:00:00', '10:00', 'https://example.com/session2', 2),
                                                                          ('2024-09-03 11:00:00', '11:00', 'https://example.com/session3', 3),
                                                                          ('2024-09-04 12:00:00', '12:00', 'https://example.com/session4', 4),
                                                                          ('2024-09-05 13:00:00', '13:00', 'https://example.com/session5', 5);
-- INSERT para la tabla plan
INSERT INTO plan (nombre_plan, precio, descripcion_plan, fecha_inicio) VALUES
                                                                           ('Plan Básico', 9.99, 'Acceso limitado a recursos básicos.', '2024-01-01'),
                                                                           ('Plan Premium', 19.99, 'Acceso ilimitado a todos los recursos.', '2024-01-01'),
                                                                           ('Plan Estándar', 14.99, 'Acceso limitado a recursos seleccionados.', '2024-01-01'),
                                                                           ('Plan Avanzado', 29.99, 'Acceso a recursos avanzados.', '2024-01-01'),
                                                                           ('Plan Estudiante', 5.99, 'Acceso para estudiantes con restricciones.', '2024-01-01');
-- INSERT para la tabla pago
INSERT INTO pago (monto, metodo_pago, fecha_pago, id_plan) VALUES
                                                               (9.99, 'Tarjeta de Crédito', '2024-01-05', 1),
                                                               (19.99, 'Paypal', '2024-01-06', 2),
                                                               (29.99, 'Tarjeta de Débito', '2024-01-07', 3),
                                                               (39.99, 'Transferencia Bancaria', '2024-01-08', 4),
                                                               (49.99, 'Paypal', '2024-01-09', 5);
-- INSERT para la tabla pregunta
INSERT INTO preguntas (pregunta, punto) VALUES
                                            ('¿Te interesa el desarrollo de software?', 5),
                                            ('¿Te atrae el comportamiento humano?', 4),
                                            ('¿Te apasiona la medicina?', 5),
                                            ('¿Te gustaría ser abogado?', 4),
                                            ('¿Te interesa el diseño arquitectónico?', 5);
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
                                                                       ('Una gran ayuda en mi carrera.', 5, 5,5);
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

