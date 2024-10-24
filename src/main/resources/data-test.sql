-- Eliminar tablas si existen
DROP TABLE IF EXISTS recurso CASCADE;
DROP TABLE IF EXISTS reseña CASCADE;
DROP TABLE IF EXISTS sesion CASCADE;
DROP TABLE IF EXISTS horario CASCADE;
DROP TABLE IF EXISTS mentor CASCADE;
DROP TABLE IF EXISTS resultado_prueba CASCADE;
DROP TABLE IF EXISTS preguntas CASCADE;
DROP TABLE IF EXISTS respuestas CASCADE;
DROP TABLE IF EXISTS prueba_vocacional CASCADE;
DROP TABLE IF EXISTS compra CASCADE;
DROP TABLE IF EXISTS historial_pago CASCADE;
DROP TABLE IF EXISTS pago CASCADE;
DROP TABLE IF EXISTS estudiante CASCADE;
DROP TABLE IF EXISTS plan CASCADE;
DROP TABLE IF EXISTS carrera CASCADE;
DROP TABLE IF EXISTS especialidad CASCADE;

-- Crear las tablas



-- Tabla carrera
CREATE TABLE carrera (
                         id_carrera SERIAL PRIMARY KEY,
                         nombre_carrera VARCHAR(150) NOT NULL,
                         puntaje_aproximado INT NOT NULL,
                         descripcion_carrera TEXT NOT NULL
);

-- Tabla plan
CREATE TABLE plan (
                      id_plan SERIAL PRIMARY KEY,
                      nombre_plan VARCHAR(100) NOT NULL,
                      precio DECIMAL(10, 2) NOT NULL,
                      descripcion_plan TEXT NOT NULL,
                      beneficios TEXT NOT NULL,
                      fecha_inicio DATE NOT NULL,
                      fecha_fin DATE
);


-- Tabla especialidad
CREATE TABLE especialidad (
                              id SERIAL PRIMARY KEY,
                              nombre VARCHAR(255) NOT NULL,
                              descripcion VARCHAR(500)
);

-- Tabla estudiante
CREATE TABLE estudiante (
                            id_estudiante SERIAL PRIMARY KEY,
                            nombre_estudiante VARCHAR(150) NOT NULL,
                            email VARCHAR(150) NOT NULL UNIQUE,
                            contraseña VARCHAR(100) NOT NULL,
                            estado_plan VARCHAR(20) NOT NULL,
                            id_plan INT,
                            id_carrera INT,
                            FOREIGN KEY (id_plan) REFERENCES plan(id_plan),
                            FOREIGN KEY (id_carrera) REFERENCES carrera(id_carrera)
);

-- Tabla mentor
CREATE TABLE mentor (
                        id_mentor SERIAL PRIMARY KEY,
                        nombre_mentor VARCHAR(100),
                        experiencia VARCHAR(255),
                        especialidad VARCHAR(100),
                        nro_asesorias INT
);




-- Tabla horario
CREATE TABLE horario (
                         id_horario SERIAL PRIMARY KEY,
                         dia_semana VARCHAR(50) NOT NULL,
                         hora_inicio TIME NOT NULL,
                         hora_fin TIME NOT NULL,
                         id_mentor INT,
                         FOREIGN KEY (id_mentor) REFERENCES mentor(id_mentor)
);

-- Tabla sesion
CREATE TABLE sesion (
                        id_sesion SERIAL PRIMARY KEY,
                        fecha_hora TIMESTAMP NOT NULL,
                        duracion TIME NOT NULL,
                        link VARCHAR(255) NOT NULL,
                        id_estudiante INT,
                        id_horario INT,
                        FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante),
                        FOREIGN KEY (id_horario) REFERENCES horario(id_horario)
);

-- Tabla prueba_vocacional
CREATE TABLE prueba_vocacional (
                                   id_prueba_vocacional SERIAL PRIMARY KEY,
                                   nro_prueba INT NOT NULL,
                                   fecha DATE NOT NULL,
                                   nombre VARCHAR(255) NOT NULL,
                                   email VARCHAR(255) NOT NULL,
                                   id_estudiante INT,
                                   FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante)
);


-- Tabla respuestas
CREATE TABLE respuestas (
                            id_respuestas SERIAL PRIMARY KEY,
                            opciones VARCHAR(150) NOT NULL
);

-- Tabla preguntas
CREATE TABLE preguntas (
                           id_preguntas SERIAL PRIMARY KEY,
                           preguntas VARCHAR(250) NOT NULL,
                           punto INT NOT NULL,
                           id_respuestas INT,
                           id_prueba_vocacional INT,
                           id_carrera INT,
                           FOREIGN KEY (id_respuestas) REFERENCES respuestas(id_respuestas),
                           FOREIGN KEY (id_prueba_vocacional) REFERENCES prueba_vocacional(id_prueba_vocacional),
                           FOREIGN KEY (id_carrera) REFERENCES carrera(id_carrera)
);

-- Tabla resultado_prueba
CREATE TABLE resultado_prueba (
                                  id_resultado_prueba SERIAL PRIMARY KEY,
                                  puntaje INT NOT NULL,
                                  recomendacion VARCHAR(150) NOT NULL,
                                  id_prueba_vocacional INT,
                                  FOREIGN KEY (id_prueba_vocacional) REFERENCES prueba_vocacional(id_prueba_vocacional)
);

-- Tabla compra
CREATE TABLE compra (
                        id_compra SERIAL PRIMARY KEY,
                        id_estudiante INT NOT NULL,
                        id_plan INT NOT NULL,
                        metodo_pago VARCHAR(50) NOT NULL,
                        estado VARCHAR(20) NOT NULL,
                        FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante),
                        FOREIGN KEY (id_plan) REFERENCES plan(id_plan)
);

-- Tabla pago
CREATE TABLE pago (
                      id_pago SERIAL PRIMARY KEY,
                      id_estudiante INT,
                      id_plan INT,
                      monto DECIMAL(10, 2) NOT NULL,
                      metodo_pago VARCHAR(255) NOT NULL,
                      fecha_pago DATE NOT NULL,
                      FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante),
                      FOREIGN KEY (id_plan) REFERENCES plan(id_plan)
);

-- Tabla historial_pago
CREATE TABLE historial_pago (
                                id_pago SERIAL PRIMARY KEY,
                                fecha_pago DATE NOT NULL,
                                monto DECIMAL(10, 2) NOT NULL,
                                metodo_pago VARCHAR(50) NOT NULL,
                                id_estudiante INT,
                                FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante)
);


-- Tabla recurso
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


-- Tabla reseña
CREATE TABLE reseña (
                        id_reseña SERIAL PRIMARY KEY,
                        texto TEXT NOT NULL,
                        calificacion INT NOT NULL,
                        id_mentor INT,
                        id_estudiante INT,
                        FOREIGN KEY (id_mentor) REFERENCES mentor(id_mentor),
                        FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante)
);








-- Datos para Carrera
INSERT INTO carrera (id_carrera, nombre_carrera, puntaje_aproximado, descripcion_carrera) VALUES
                                                                          (1, 'Ingeniería de Software', 80, 'Estudio del desarrollo de software y sistemas informáticos.'),
                                                                          (2, 'Administración de Empresas', 75, 'Gestión y dirección de empresas y organizaciones.'),
                                                                          (3, 'Diseño Gráfico', 70, 'Creación de diseños visuales y comunicación gráfica.'),
                                                                          (4, 'Ciencias de la Computación', 85, 'Estudio de los fundamentos y aplicaciones de la computación.'),
                                                                          (5, 'Arquitectura', 90, 'Diseño y planificación de edificios y espacios.');



-- Datos para Plan
INSERT INTO plan (id_plan, nombre_plan, precio, descripcion_plan, beneficios, fecha_inicio, fecha_fin) VALUES
                                                                                                           (1, 'Plan No Premium Mensual', 9.99, 'Acceso limitado al test una vez al mes.', 'Beneficios básicos.', '2024-01-01', '2024-01-31'),
                                                                                                           (2, 'Plan Premium Mensual', 19.99, 'Acceso ilimitado al test.', 'Beneficios premium.', '2024-01-01', '2024-01-31'),
                                                                                                           (3, 'Plan No Premium Anual', 99.99, 'Acceso limitado al test una vez al mes.', 'Beneficios básicos.', '2024-01-01', '2024-12-31'),
                                                                                                           (4, 'Plan Premium Anual', 199.99, 'Acceso ilimitado al test.', 'Beneficios premium.', '2024-01-01', '2024-12-31'),
                                                                                                           (5, 'Plan Básico Anual', 49.99, 'Acceso a un número limitado de pruebas.', 'Beneficios básicos.', '2024-01-01', '2024-12-31');

-- Datos para Especialidad
INSERT INTO especialidad (nombre, descripcion) VALUES
                                                   ('Ingeniería de Sistemas', 'Especialidad orientada al desarrollo de software y sistemas.'),
                                                   ('Psicología Clínica', 'Especialidad centrada en el diagnóstico y tratamiento de trastornos mentales.'),
                                                   ('Medicina General', 'Especialidad médica que trata una amplia variedad de enfermedades.'),
                                                   ('Derecho Penal', 'Especialidad enfocada en la defensa y litigio de casos penales.');

-- Datos para Estudiante
INSERT INTO estudiante (id_estudiante, nombre_estudiante, email, contraseña, estado_plan, id_plan) VALUES
                                                                                                       (1, 'Carlos Pérez', 'carlos.perez@example.com', 'contraseña123', 'NOPREMIUM', 1),
                                                                                                       (2, 'Ana López', 'ana.lopez@example.com', 'contraseña456', 'NOPREMIUM', 2),
                                                                                                       (3, 'Luis García', 'luis.garcia@example.com', 'contraseña789', 'NOPREMIUM', 3),
                                                                                                       (4, 'María Rodríguez', 'maria.rodriguez@example.com', 'contraseña012', 'NOPREMIUM', 4),
                                                                                                       (5, 'José Martínez', 'jose.martinez@example.com', 'contraseña345', 'NOPREMIUM', 5);


-- Datos para Mentor
INSERT INTO mentor (id_mentor, nombre_mentor, experiencia, especialidad, nro_asesorias) VALUES
                                                                                            (1, 'Juan Pérez', '10 años de experiencia en matemáticas', 'Matemáticas', 50),
                                                                                            (2, 'Ana López', '8 años de experiencia en física', 'Física', 40),
                                                                                            (3, 'Carlos García', '7 años de experiencia en química', 'Química', 30),
                                                                                            (4, 'María Rodríguez', '9 años de experiencia en biología', 'Biología', 45),
                                                                                            (5, 'José Martínez', '12 años de experiencia en historia', 'Historia', 60);

-- Datos para Horario
INSERT INTO horario (id_horario, dia_semana, hora_inicio, hora_fin, id_mentor) VALUES
                                                                                   (1, 'Lunes', '09:00:00', '11:00:00', 1),
                                                                                   (2, 'Martes', '14:00:00', '16:00:00', 2),
                                                                                   (3, 'Miércoles', '10:00:00', '12:00:00', 3),
                                                                                   (4, 'Jueves', '15:00:00', '17:00:00', 4),
                                                                                   (5, 'Viernes', '13:00:00', '15:00:00', 5);

--Datos sesion
INSERT INTO sesion (fecha_hora, duracion, link, id_estudiante, id_horario) VALUES
                                                                               ('2024-01-15 09:00:00', '02:00:00', 'https://mentoria.com/sesion1', 1, 1),
                                                                               ('2024-02-20 14:00:00', '01:30:00', 'https://mentoria.com/sesion2', 2, 2),
                                                                               ('2024-03-10 09:30:00', '02:00:00', 'https://mentoria.com/sesion3', 3, 3),
                                                                               ('2024-04-05 13:00:00', '02:00:00', 'https://mentoria.com/sesion4', 4, 4),
                                                                               ('2024-05-12 10:00:00', '01:45:00', 'https://mentoria.com/sesion5', 5, 5);

-- Datos para Prueba Vocacional
INSERT INTO prueba_vocacional (id_prueba_vocacional, nro_prueba, fecha, nombre, email, id_estudiante) VALUES
                                                                                               (1, 1, '2024-09-15', 'Test 1', 'estudiante1@example.com', 1),
                                                                                               (2, 2, '2024-09-16', 'Test 2', 'estudiante2@example.com', 2),
                                                                                               (3, 3, '2024-09-17', 'Test 3', 'estudiante3@example.com', 3),
                                                                                               (4, 4, '2024-09-18', 'Test 4', 'estudiante4@example.com', 4),
                                                                                               (5, 5, '2024-09-19', 'Test 5', 'estudiante5@example.com', 5);

-- Datos para Respuestas
INSERT INTO respuestas (id_respuestas, opciones) VALUES
                                                    (1, 'Sí'),
                                                    (2, 'No'),
                                                    (3, 'Tal vez'),
                                                    (4, 'No lo sé'),
                                                    (5, 'Prefiero no decirlo');
-- Datos para Preguntas
INSERT INTO preguntas (id_preguntas, preguntas, punto, id_respuestas, id_prueba_vocacional, id_carrera) VALUES
                                                                                                            (1, '¿Te interesa el desarrollo de software?', 5, 1, 1, 1),
                                                                                                            (2, '¿Te atrae el trabajo en equipo?', 3, 2, 2, 2),
                                                                                                            (3, '¿Te gustaría trabajar en la administración pública?', 4, 3, 3, 3),
                                                                                                            (4, '¿Te apasiona el diseño de edificios?', 5, 4, 4, 4),
                                                                                                            (5, '¿Te interesa el análisis estructural?', 4, 5, 5, 5);


-- Datos para Resultado Prueba
INSERT INTO resultado_prueba (id_resultado_prueba, puntaje, recomendacion, id_prueba_vocacional) VALUES
                                                                                              (1, 85, 'Recomendado para Ingeniería.', 1),
                                                                                              (2, 70, 'Recomendado para Psicología.', 2),
                                                                                              (3, 90, 'Recomendado para Derecho.', 3),
                                                                                              (4, 75, 'Recomendado para Arquitectura.', 4),
                                                                                              (5, 80, 'Recomendado para Diseño Estructural.', 5);

--Datos compra
INSERT INTO compra (id_estudiante, id_plan, metodo_pago, estado) VALUES
                                                                     (1, 1, 'Tarjeta de Crédito', 'Completado'),
                                                                     (2, 2, 'PayPal', 'Completado'),
                                                                     (3, 3, 'Transferencia Bancaria', 'Pendiente'),
                                                                     (4, 4, 'Tarjeta de Débito', 'Completado'),
                                                                     (5, 5, 'Tarjeta de Crédito', 'Pendiente');

-- Datos para Pago
INSERT INTO pago (id_pago, id_estudiante, id_plan, monto, metodo_pago, fecha_pago) VALUES
                                                                                       (1, 1, 1, 19.99, 'Tarjeta de Crédito', '2024-01-05'),
                                                                                       (2, 2, 2, 9.99, 'PayPal', '2024-01-06'),
                                                                                       (3, 3, 3, 199.99, 'Transferencia Bancaria', '2024-01-07'),
                                                                                       (4, 4, 4, 49.99, 'Tarjeta de Crédito', '2024-01-08'),
                                                                                       (5, 5, 5, 99.99, 'PayPal', '2024-01-09');




--Datos Historial Pago
INSERT INTO historial_pago (fecha_pago, monto, metodo_pago, id_estudiante) VALUES
                                                                               ('2024-01-01', 9.99, 'Tarjeta de Crédito', 1),
                                                                               ('2024-02-01', 19.99, 'PayPal', 2),
                                                                               ('2024-03-01', 99.99, 'Transferencia Bancaria', 3),
                                                                               ('2024-04-01', 199.99, 'Tarjeta de Débito', 4),
                                                                               ('2024-05-01', 49.99, 'Tarjeta de Crédito', 5);
--Datos recurso
INSERT INTO recurso (link_recurso, es_premium, es_favorito, id_estudiante, id_mentor) VALUES
                                                                                          ('https://recursos-mentoria.com/matematicas-avanzadas', true, true, 1, 1),
                                                                                          ('https://recursos-mentoria.com/fisica-basica', false, false, 2, 2),
                                                                                          ('https://recursos-mentoria.com/quimica-avanzada', true, true, 3, 3),
                                                                                          ('https://recursos-mentoria.com/biologia-molecular', false, true, 4, 4); -- Aquí agregué el punto y coma


--Datos reseña
INSERT INTO reseña (texto, calificacion, id_mentor, id_estudiante) VALUES
                                                                       ('El mentor fue excelente, muy claro en sus explicaciones.', 5, 1, 1),
                                                                       ('Me ayudó mucho en mi carrera. Muy recomendado.', 4, 2, 2),
                                                                       ('Fue muy útil, pero podría mejorar su puntualidad.', 3, 3, 3),
                                                                       ('Excelente asesoría. Resolví todas mis dudas.', 5, 4, 4),
                                                                       ('Muy atento y dedicado. Excelente mentor.', 5, 5, 5);


