-- Eliminar tablas existentes
DROP TABLE IF EXISTS reseña CASCADE;
DROP TABLE IF EXISTS resultado_prueba CASCADE;
DROP TABLE IF EXISTS sesion CASCADE;
DROP TABLE IF EXISTS pago CASCADE;
DROP TABLE IF EXISTS preguntas CASCADE;
DROP TABLE IF EXISTS prueba_vocacional CASCADE;
DROP TABLE IF EXISTS horario CASCADE;
DROP TABLE IF EXISTS mentor CASCADE;
DROP TABLE IF EXISTS respuestas CASCADE;
DROP TABLE IF EXISTS estudiante CASCADE;
DROP TABLE IF EXISTS carreras CASCADE;
DROP TABLE IF EXISTS plan CASCADE;
DROP TABLE IF EXISTS recurso CASCADE;
DROP TABLE IF EXISTS especialidad CASCADE;

-- Crear la tabla Plan
CREATE TABLE plan (
                      id_plan SERIAL PRIMARY KEY,
                      nombre_plan VARCHAR(100) NOT NULL,
                      precio DECIMAL(10,2) NOT NULL,
                      descripcion_plan TEXT NOT NULL,
                      fecha_inicio DATE NOT NULL,
                      fecha_fin DATE,
                      tipo_plan VARCHAR(50) NOT NULL,
                      acceso_ilimitado BOOLEAN NOT NULL DEFAULT FALSE
);

-- Insertar datos ficticios en la tabla Plan
INSERT INTO plan (nombre_plan, precio, descripcion_plan, fecha_inicio, fecha_fin, tipo_plan, acceso_ilimitado) VALUES
                                                                                                                   ('Plan No Premium Mensual', 9.99, 'Acceso limitado al test una vez al mes.', '2024-01-01', '2024-01-31', 'Mensual', FALSE),
                                                                                                                   ('Plan Premium Mensual', 19.99, 'Acceso ilimitado al test.', '2024-01-01', '2024-01-31', 'Mensual', TRUE),
                                                                                                                   ('Plan No Premium Anual', 99.99, 'Acceso limitado al test una vez al mes.', '2024-01-01', '2024-12-31', 'Anual', FALSE),
                                                                                                                   ('Plan Premium Anual', 199.99, 'Acceso ilimitado al test.', '2024-01-01', '2024-12-31', 'Anual', TRUE),
                                                                                                                   ('Plan Básico Anual', 49.99, 'Acceso a un número limitado de pruebas.', '2024-01-01', '2024-12-31', 'Anual', FALSE);

-- Crear la tabla Carrera
CREATE TABLE carreras (
                          id_carrera SERIAL PRIMARY KEY,
                          nombre_carrera VARCHAR(150) NOT NULL,
                          puntaje_aproximado INT NOT NULL,
                          descripcion_carrera TEXT NOT NULL
);

-- Insertar datos ficticios en la tabla Carrera
INSERT INTO carreras (nombre_carrera, puntaje_aproximado, descripcion_carrera) VALUES
                                                                                   ('Ingeniería de Sistemas', 85, 'Carrera orientada a la tecnología y desarrollo de software.'),
                                                                                   ('Psicología', 70, 'Estudio del comportamiento humano.'),
                                                                                   ('Medicina', 95, 'Carrera dedicada a la salud y bienestar de las personas.'),
                                                                                   ('Derecho', 80, 'Estudio de la ley y la justicia.'),
                                                                                   ('Arquitectura', 75, 'Diseño y construcción de edificaciones.');

-- Crear la tabla Estudiante
CREATE TABLE estudiante (
                            id_estudiante SERIAL PRIMARY KEY,
                            nombre_estudiante VARCHAR(150) NOT NULL,
                            email VARCHAR(150) NOT NULL UNIQUE,
                            contraseña VARCHAR(100) NOT NULL,
                            estado_plan VARCHAR(50) NOT NULL DEFAULT 'NOPREMIUM',
                            estado_cuenta VARCHAR(50) NOT NULL DEFAULT 'HABILITADO'
);

-- Insertar datos ficticios en la tabla Estudiante
INSERT INTO estudiante (nombre_estudiante, email, contraseña, estado_plan, estado_cuenta) VALUES
                                                                                              ('Juan Perez', 'juan.perez@example.com', 'password123', 'NOPREMIUM', 'HABILITADO'),
                                                                                              ('Maria Lopez', 'maria.lopez@example.com', 'password456', 'PREMIUM', 'HABILITADO'),
                                                                                              ('Carlos Sanchez', 'carlos.sanchez@example.com', 'password789', 'NOPREMIUM', 'INHABILITADO'),
                                                                                              ('Ana Torres', 'ana.torres@example.com', 'password101', 'PREMIUM', 'HABILITADO'),
                                                                                              ('Luis Ramirez', 'luis.ramirez@example.com', 'password202', 'NOPREMIUM', 'HABILITADO');
-- Crear la tabla Pago
CREATE TABLE pago (
                      id_pago SERIAL PRIMARY KEY,
                      monto DECIMAL(10,2) NOT NULL,
                      metodo_pago VARCHAR(50) NOT NULL,
                      fecha_pago DATE NOT NULL,
                      id_estudiante INT NOT NULL,
                      id_plan INT NOT NULL,
                      FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante) ON DELETE CASCADE,
                      FOREIGN KEY (id_plan) REFERENCES plan(id_plan) ON DELETE CASCADE
);

-- Insertar datos ficticios en la tabla Pago
INSERT INTO pago (monto, metodo_pago, fecha_pago, id_estudiante, id_plan) VALUES
                                                                              (9.99, 'Tarjeta de Crédito', '2024-01-05', 1, 1),
                                                                              (19.99, 'Paypal', '2024-01-06', 2, 2),
                                                                              (9.99, 'Tarjeta de Débito', '2024-01-07', 3, 1),
                                                                              (19.99, 'Paypal', '2024-01-08', 4, 3),
                                                                              (49.99, 'Tarjeta de Crédito', '2024-01-09', 5, 4);

-- Crear la tabla Especialidad
CREATE TABLE especialidad (
                              id_especialidad SERIAL PRIMARY KEY,
                              nombre_especialidad VARCHAR(150) NOT NULL
);

-- Insertar datos ficticios en la tabla Especialidad
INSERT INTO especialidad (nombre_especialidad) VALUES
                                                   ('Ingeniería de Sistemas'),
                                                   ('Psicología'),
                                                   ('Derecho'),
                                                   ('Arquitectura'),
                                                   ('Medicina');

-- Crear la tabla Mentor
CREATE TABLE mentor (
                        id_mentor SERIAL PRIMARY KEY,
                        nombre_mentor VARCHAR(50) NOT NULL,
                        experiencia TEXT NOT NULL,
                        nro_asesorias INT NOT NULL,
                        id_especialidad INT,
                        FOREIGN KEY (id_especialidad) REFERENCES especialidad(id_especialidad)
);

-- Insertar datos ficticios en la tabla Mentor
INSERT INTO mentor (nombre_mentor, experiencia, nro_asesorias, id_especialidad) VALUES
                                                                                    ('Carlos Martínez', '10 años en desarrollo de software.', 50, 1),
                                                                                    ('Ana López', 'Experta en orientación psicológica.', 30, 2),
                                                                                    ('Luis Gómez', 'Especialista en derecho corporativo.', 40, 3),
                                                                                    ('Elena Pérez', 'Arquitecta con 15 años de experiencia.', 25, 4),
                                                                                    ('Javier Morales', 'Experto en diseño estructural.', 20, 4);

-- Crear la tabla Horario
CREATE TABLE horario (
                         id_horario SERIAL PRIMARY KEY,
                         dia_semana VARCHAR(20) NOT NULL,
                         hora_inicio TIME NOT NULL,
                         hora_fin TIME NOT NULL,
                         id_mentor INT,
                         FOREIGN KEY (id_mentor) REFERENCES mentor(id_mentor)
);

-- Insertar datos ficticios en la tabla Horario
INSERT INTO horario (dia_semana, hora_inicio, hora_fin, id_mentor) VALUES
                                                                       ('Lunes', '09:00', '11:00', 1),
                                                                       ('Martes', '14:00', '16:00', 2),
                                                                       ('Miércoles', '10:00', '12:00', 3),
                                                                       ('Jueves', '15:00', '17:00', 4),
                                                                       ('Viernes', '13:00', '15:00', 5);

-- Crear la tabla PruebaVocacional
CREATE TABLE prueba_vocacional (
                                   id_prueba_vocacional SERIAL PRIMARY KEY,
                                   nro_prueba INT NOT NULL,
                                   fecha DATE NOT NULL,
                                   id_estudiante INT,
                                   FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante) ON DELETE CASCADE
);

-- Insertar datos ficticios en la tabla PruebaVocacional
INSERT INTO prueba_vocacional (nro_prueba, fecha, id_estudiante) VALUES
                                                                     (1, '2024-09-15', 1),
                                                                     (2, '2024-09-16', 2),
                                                                     (3, '2024-09-17', 3),
                                                                     (4, '2024-09-18', 4),
                                                                     (5, '2024-09-19', 5);

-- Crear la tabla Pregunta
CREATE TABLE preguntas (
                           id_pregunta SERIAL PRIMARY KEY,
                           pregunta VARCHAR(250) NOT NULL,
                           punto INT NOT NULL,
                           id_prueba_vocacional INT,
                           FOREIGN KEY (id_prueba_vocacional) REFERENCES prueba_vocacional(id_prueba_vocacional) ON DELETE CASCADE
);

-- Insertar datos ficticios en la tabla Pregunta
INSERT INTO preguntas (pregunta, punto, id_prueba_vocacional) VALUES
                                                                  ('¿Te interesa el desarrollo de software?', 5, 1),
                                                                  ('¿Te atrae el trabajo en equipo?', 3, 2),
                                                                  ('¿Te gustaría trabajar en la administración pública?', 4, 3),
                                                                  ('¿Te apasiona el diseño de edificios?', 5, 4),
                                                                  ('¿Te interesa el análisis estructural?', 4, 5);

-- Crear la tabla Respuesta
CREATE TABLE respuestas (
                            id_respuesta SERIAL PRIMARY KEY,
                            opciones VARCHAR(150) NOT NULL
);

-- Insertar datos ficticios en la tabla Respuesta
INSERT INTO respuestas (opciones) VALUES
                                      ('Sí'),
                                      ('No'),
                                      ('Tal vez'),
                                      ('No lo sé'),
                                      ('Prefiero no decirlo');

-- Crear la tabla Reseña
CREATE TABLE reseña (
                        id_reseña SERIAL PRIMARY KEY,
                        texto TEXT NOT NULL,
                        calificacion INT NOT NULL,
                        id_mentor INT,
                        id_estudiante INT,
                        FOREIGN KEY (id_mentor) REFERENCES mentor(id_mentor),
                        FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante) ON DELETE CASCADE
);

-- Insertar datos ficticios en la tabla Reseña
INSERT INTO reseña (texto, calificacion, id_mentor, id_estudiante) VALUES
                                                                       ('Gran mentor, muy recomendado.', 5, 1, 1),
                                                                       ('Muy profesional y atento.', 4, 2, 2),
                                                                       ('Excelente orientación, muy útil.', 5, 3, 3),
                                                                       ('Muy conocedor del tema.', 4, 4, 4),
                                                                       ('Ayuda invaluable en mi carrera.', 5, 5, 5);

-- Crear la tabla ResultadoPrueba
CREATE TABLE resultado_prueba (
                                  id_resultado_prueba SERIAL PRIMARY KEY,
                                  puntaje INT NOT NULL,
                                  recomendacion VARCHAR(150) NOT NULL,
                                  id_prueba_vocacional INT,
                                  FOREIGN KEY (id_prueba_vocacional) REFERENCES prueba_vocacional(id_prueba_vocacional) ON DELETE CASCADE
);

-- Insertar datos ficticios en la tabla ResultadoPrueba
INSERT INTO resultado_prueba (puntaje, recomendacion, id_prueba_vocacional) VALUES
                                                                                (85, 'Recomendado para Ingeniería.', 1),
                                                                                (70, 'Recomendado para Psicología.', 2),
                                                                                (90, 'Recomendado para Derecho.', 3),
                                                                                (75, 'Recomendado para Arquitectura.', 4),
                                                                                (80, 'Recomendado para Diseño Estructural.', 5);

-- Crear la tabla Sesion
CREATE TABLE sesion (
                        id_sesion SERIAL PRIMARY KEY,
                        fecha_hora TIMESTAMP NOT NULL,
                        duracion TIME NOT NULL,
                        link VARCHAR(255) NOT NULL,
                        id_estudiante INT,
                        id_horario INT,
                        FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante) ON DELETE CASCADE,
                        FOREIGN KEY (id_horario) REFERENCES horario(id_horario) ON DELETE CASCADE
);

-- Insertar datos ficticios en la tabla Sesion
INSERT INTO sesion (fecha_hora, duracion, link, id_estudiante, id_horario) VALUES
                                                                               ('2024-09-15 10:00:00', '01:00:00', 'https://example.com/session1', 1, 1),
                                                                               ('2024-09-16 14:00:00', '02:00:00', 'https://example.com/session2', 2, 2),
                                                                               ('2024-09-17 10:00:00', '01:30:00', 'https://example.com/session3', 3, 3),
                                                                               ('2024-09-18 15:00:00', '01:15:00', 'https://example.com/session4', 4, 4),
                                                                               ('2024-09-19 13:00:00', '00:45:00', 'https://example.com/session5', 5, 5);

-- Crear la tabla Recurso
CREATE TABLE recurso (
                         id_recurso SERIAL PRIMARY KEY,
                         link_recurso VARCHAR(300) NOT NULL,
                         es_premium BOOLEAN NOT NULL,
                         es_favorito BOOLEAN NOT NULL,
                         id_estudiante INT,
                         id_mentor INT,
                         FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante),
                         FOREIGN KEY (id_mentor) REFERENCES mentor(id_mentor)
);

-- Insertar datos ficticios en la tabla Recurso
INSERT INTO recurso (link_recurso, es_premium, es_favorito, id_estudiante, id_mentor) VALUES
                                                                                          ('http://example.com/recurso1', TRUE, FALSE, 1, 1),
                                                                                          ('http://example.com/recurso2', FALSE, TRUE, 2, 2),
                                                                                          ('http://example.com/recurso3', TRUE, TRUE, 1, 3),
                                                                                          ('http://example.com/recurso4', FALSE, FALSE, 3, 1),
                                                                                          ('http://example.com/recurso5', TRUE, FALSE, 2, 3);
