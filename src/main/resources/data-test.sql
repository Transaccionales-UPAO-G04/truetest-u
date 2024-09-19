-- Tabla Carrera
CREATE TABLE carreras (
                          id_carrera SERIAL PRIMARY KEY,
                          nombre_carrera VARCHAR(150) NOT NULL,
                          puntaje_aproximado INT NOT NULL,
                          descripcion_carrera TEXT NOT NULL
);

-- Datos ficticios para Carrera
INSERT INTO carreras (nombre_carrera, puntaje_aproximado, descripcion_carrera) VALUES
                                                                                   ('Ingeniería de Sistemas', 85, 'Carrera orientada a la tecnología y desarrollo de software.'),
                                                                                   ('Psicología', 70, 'Estudio del comportamiento humano.'),
                                                                                   ('Medicina', 95, 'Carrera dedicada a la salud y bienestar de las personas.'),
                                                                                   ('Derecho', 80, 'Estudio de la ley y la justicia.'),
                                                                                   ('Arquitectura', 75, 'Diseño y construcción de edificaciones.');

-- Tabla Plan
CREATE TABLE plan (
                      id_plan SERIAL PRIMARY KEY,
                      nombre_plan VARCHAR(100) NOT NULL,
                      precio DECIMAL(10,2) NOT NULL,
                      descripcion_plan TEXT NOT NULL,
                      fecha_inicio DATE NOT NULL,
                      fecha_fin DATE,
                      tipo_plan VARCHAR(50) NOT NULL, -- Mensual o Anual
                      acceso_ilimitado BOOLEAN NOT NULL DEFAULT FALSE -- Para distinguir entre acceso limitado o ilimitado
);

-- Datos ficticios para Plan
INSERT INTO plan (nombre_plan, precio, descripcion_plan, fecha_inicio, fecha_fin, tipo_plan, acceso_ilimitado) VALUES
                                                                                                                   ('Plan No Premium Mensual', 9.99, 'Acceso limitado al test una vez al mes.', '2024-01-01', '2024-01-31', 'Mensual', FALSE),
                                                                                                                   ('Plan Premium Mensual', 19.99, 'Acceso ilimitado al test.', '2024-01-01', '2024-01-31', 'Mensual', TRUE),
                                                                                                                   ('Plan No Premium Anual', 99.99, 'Acceso limitado al test una vez al mes.', '2024-01-01', '2024-12-31', 'Anual', FALSE),
                                                                                                                   ('Plan Premium Anual', 199.99, 'Acceso ilimitado al test.', '2024-01-01', '2024-12-31', 'Anual', TRUE),
                                                                                                                   ('Plan Básico Anual', 49.99, 'Acceso a un número limitado de pruebas.', '2024-01-01', '2024-12-31', 'Anual', FALSE);

-- Tabla Estudiante
CREATE TABLE estudiante (
                            id_estudiante SERIAL PRIMARY KEY,
                            nombre_estudiante VARCHAR(150) NOT NULL,
                            email VARCHAR(150) NOT NULL UNIQUE,
                            contraseña VARCHAR(100) NOT NULL,
                            estado_plan VARCHAR(50) NOT NULL DEFAULT 'NOPREMIUM',
                            estado_cuenta VARCHAR(50) NOT NULL DEFAULT 'HABILITADO',
                            id_plan INT,
                            CONSTRAINT FK_estudiante_plan FOREIGN KEY (id_plan) REFERENCES plan(id_plan)
);


-- Datos ficticios para Estudiante
INSERT INTO estudiante (nombre_estudiante, email, contraseña, estado_plan, estado_cuenta, id_plan) VALUES
                                                                                                       ('Juan Perez', 'juan.perez@example.com', 'password123', 'NOPREMIUM', 'HABILITADO', 1),
                                                                                                       ('Maria Lopez', 'maria.lopez@example.com', 'password456', 'PREMIUM', 'HABILITADO', 2),
                                                                                                       ('Carlos Sanchez', 'carlos.sanchez@example.com', 'password789', 'NOPREMIUM', 'HABILITADO', 1),
                                                                                                       ('Ana Torres', 'ana.torres@example.com', 'password101', 'PREMIUM', 'HABILITADO', 3),
                                                                                                       ('Luis Ramirez', 'luis.ramirez@example.com', 'password202', 'NOPREMIUM', 'HABILITADO', 1);

-- Tabla Mentor
CREATE TABLE mentor (
                        id_mentor SERIAL PRIMARY KEY,
                        nombre_mentor VARCHAR(50) NOT NULL,
                        experiencia TEXT NOT NULL,
                        especialidad VARCHAR(50) NOT NULL,
                        nro_asesorias INT NOT NULL
);

-- Datos ficticios para Mentor
INSERT INTO mentor (nombre_mentor, experiencia, especialidad, nro_asesorias) VALUES
                                                                                 ('Carlos Martínez', '10 años en desarrollo de software.', 'Ingeniería de Sistemas', 50),
                                                                                 ('Ana López', 'Experta en orientación psicológica.', 'Psicología', 30),
                                                                                 ('Luis Gómez', 'Especialista en derecho corporativo.', 'Derecho', 40),
                                                                                 ('Elena Pérez', 'Arquitecta con 15 años de experiencia.', 'Arquitectura', 25),
                                                                                 ('Javier Morales', 'Experto en diseño estructural.', 'Arquitectura', 20);

-- Tabla Horario
CREATE TABLE horario (
                         id_horario SERIAL PRIMARY KEY,
                         dia_semana VARCHAR(20) NOT NULL,
                         hora_inicio TIME NOT NULL,
                         hora_fin TIME NOT NULL,
                         id_mentor INT,
                         FOREIGN KEY (id_mentor) REFERENCES mentor(id_mentor)
);

-- Datos ficticios para Horario
INSERT INTO horario (dia_semana, hora_inicio, hora_fin, id_mentor) VALUES
                                                                       ('Lunes', '09:00', '11:00', 1),
                                                                       ('Martes', '14:00', '16:00', 2),
                                                                       ('Miércoles', '10:00', '12:00', 3),
                                                                       ('Jueves', '15:00', '17:00', 4),
                                                                       ('Viernes', '13:00', '15:00', 5);

-- Tabla Pago
CREATE TABLE pago (
                      id_pago SERIAL PRIMARY KEY,
                      monto DECIMAL(10,2) NOT NULL,
                      fecha TIMESTAMP NOT NULL,
                      metodo_pago VARCHAR(50) NOT NULL,
                      estado_pago VARCHAR(50) NOT NULL,
                      id_estudiante INT,
                      id_plan INT,
                      FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante),
                      FOREIGN KEY (id_plan) REFERENCES plan(id_plan)
);

-- Datos ficticios para Pago
INSERT INTO pago (monto, fecha, metodo_pago, estado_pago, id_estudiante, id_plan) VALUES
                                                                                      (19.99, NOW(), 'Tarjeta de Crédito', 'Completado', 1, 2),
                                                                                      (9.99, NOW(), 'PayPal', 'Pendiente', 2, 1),
                                                                                      (199.99, NOW(), 'Transferencia Bancaria', 'Completado', 3, 4),
                                                                                      (49.99, NOW(), 'Tarjeta de Crédito', 'Completado', 4, 3),
                                                                                      (99.99, NOW(), 'PayPal', 'Pendiente', 5, 5);

-- Tabla PruebaVocacional
CREATE TABLE prueba_vocacional (
                                   id_prueba_vocacional SERIAL PRIMARY KEY,
                                   nro_prueba INT NOT NULL,
                                   fecha DATE NOT NULL,
                                   id_estudiante INT,
                                   FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante)
);

-- Datos ficticios para PruebaVocacional
INSERT INTO prueba_vocacional (nro_prueba, fecha, id_estudiante) VALUES
                                                                     (1, '2024-09-15', 1),
                                                                     (2, '2024-09-16', 2),
                                                                     (3, '2024-09-17', 3),
                                                                     (4, '2024-09-18', 4),
                                                                     (5, '2024-09-19', 5);

-- Tabla Pregunta
CREATE TABLE preguntas (
                           id_pregunta SERIAL PRIMARY KEY,
                           pregunta VARCHAR(250) NOT NULL,
                           punto INT NOT NULL,
                           id_prueba_vocacional INT,
                           FOREIGN KEY (id_prueba_vocacional) REFERENCES prueba_vocacional(id_prueba_vocacional)
);

-- Datos ficticios para Pregunta
INSERT INTO preguntas (pregunta, punto, id_prueba_vocacional) VALUES
                                                                  ('¿Te interesa el desarrollo de software?', 5, 1),
                                                                  ('¿Te atrae el trabajo en equipo?', 3, 2),
                                                                  ('¿Te gustaría trabajar en la administración pública?', 4, 3),
                                                                  ('¿Te apasiona el diseño de edificios?', 5, 4),
                                                                  ('¿Te interesa el análisis estructural?', 4, 5);

-- Tabla Respuesta
CREATE TABLE respuestas (
                            id_respuesta SERIAL PRIMARY KEY,
                            opciones VARCHAR(150) NOT NULL
);

-- Datos ficticios para Respuesta
INSERT INTO respuestas (opciones) VALUES
                                      ('Sí'),
                                      ('No'),
                                      ('Tal vez'),
                                      ('No lo sé'),
                                      ('Prefiero no decirlo');

-- Tabla Reseña
CREATE TABLE reseña (
                        id_reseña SERIAL PRIMARY KEY,
                        texto TEXT NOT NULL,
                        calificacion INT NOT NULL,
                        id_mentor INT,
                        id_estudiante INT,
                        FOREIGN KEY (id_mentor) REFERENCES mentor(id_mentor),
                        FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante)
);

-- Datos ficticios para Reseña
INSERT INTO reseña (texto, calificacion, id_mentor, id_estudiante) VALUES
                                                                       ('Gran mentor, muy recomendado.', 5, 1, 1),
                                                                       ('Muy profesional y atento.', 4, 2, 2),
                                                                       ('Excelente orientación, muy útil.', 5, 3, 3),
                                                                       ('Muy conocedor del tema.', 4, 4, 4),
                                                                       ('Ayuda invaluable en mi carrera.', 5, 5, 5);

-- Tabla ResultadoPrueba
CREATE TABLE resultado_prueba (
                                  id_resultado_prueba SERIAL PRIMARY KEY,
                                  puntaje INT NOT NULL,
                                  recomendacion VARCHAR(150) NOT NULL,
                                  id_prueba_vocacional INT,
                                  FOREIGN KEY (id_prueba_vocacional) REFERENCES prueba_vocacional(id_prueba_vocacional)
);

-- Datos ficticios para ResultadoPrueba
INSERT INTO resultado_prueba (puntaje, recomendacion, id_prueba_vocacional) VALUES
                                                                                (85, 'Recomendado para Ingeniería.', 1),
                                                                                (70, 'Recomendado para Psicología.', 2),
                                                                                (90, 'Recomendado para Derecho.', 3),
                                                                                (75, 'Recomendado para Arquitectura.', 4),
                                                                                (80, 'Recomendado para Diseño Estructural.', 5);

-- Tabla Sesion
CREATE TABLE sesion (
                        id_sesion SERIAL PRIMARY KEY,
                        fecha_hora TIMESTAMP NOT NULL,
                        duracion TIME NOT NULL,
                        participantes INT NOT NULL,
                        link VARCHAR(255) NOT NULL,
                        id_estudiante INT,
                        id_horario INT,
                        FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante),
                        FOREIGN KEY (id_horario) REFERENCES horario(id_horario)
);

-- Datos ficticios para Sesion
INSERT INTO sesion (fecha_hora, duracion, participantes, link, id_estudiante, id_horario) VALUES
                                                                                              (NOW(), '01:00:00', 5, 'https://meetinglink.com/abc', 1, 1),
                                                                                              (NOW(), '00:45:00', 3, 'https://meetinglink.com/def', 2, 2),
                                                                                              (NOW(), '01:15:00', 4, 'https://meetinglink.com/ghi', 3, 3),
                                                                                              (NOW(), '00:30:00', 2, 'https://meetinglink.com/jkl', 4, 4),
                                                                                              (NOW(), '01:00:00', 6, 'https://meetinglink.com/mno', 5, 5);
