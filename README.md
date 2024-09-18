## Introducción

**TrueTest U** es una aplicación web diseñada para facilitar tanto a los estudiantes de cualquier etapa academica a solventar sus dudas por medio de un cuestionario, asi mismo los profesores pueden ofrecer su material de trabajo para orientar a los que esten interesados en la carrera pero con un costo que desbloqueara algunos de los materiales. Para estos mismos procesos se ve la opcion de pagos de diferentes entidades para la facilidad los alumnos(clientes), apartados donde estara su registro de pagos y carreras de interes e similares a los puestos. 

El proposito de **TrueTest U** es orientar de manera adecuada a los estudiantes que no tienen una idea clara de que carrera estudiar usando como medio una plataforma que sea accesible a todo publico y una gran cantidad de informacion dadá por los mismos profesores/profesionales con experiencia para asesoras a los mismos con un pago adicional.

### Colaboradores del Proyecto

| **Nombre**                          | **Rol**                           | **Perfil**                                                   |
|-------------------------------------|---------------------------        |------------------------------------------------------------|
| Oncoy Patricio Angelmauricio Rogger | Desarrallador de software         |[LinkedIn](https://www.linkedin.com/in/angel-oncoy-0843822a6/)|
| Dávila Ortiz Briyan Anthony         | Desarrallador de software         | [LinkedIn](https://www.linkedin.com/in/briyan-dávila-ortiz)           |
| Vidal Rodríguez Fabrizio            | Desarrallador de software         | [LinkedIn](https://www.linkedin.com/in/fabrizio-vidal-rodriguez-b8aa98328/)|
| Salirrosas Vasquez Jhordy           | Desarrallador de software         | [LinkedIn](https://www.linkedin.com/in/jhordy-salirrosas-30b52b259/)           |
| Rodriguez Lara Franklin Renato      | Desarrallador de software         | [LinkedIn](https://www.linkedin.com/in/hampcode/)           |

### Revisa el Progreso del Proyecto TrueTest U

| **Columna**       | **Descripción**                                                                                                                                    |
|-------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| **Backlog**       | Contiene todas las historias de usuario, tareas y características que deben desarrollarse. Es el listado de todo el trabajo pendiente.              |
| **En Progreso**   | Incluye las tareas que están actualmente en desarrollo. Visualiza el trabajo en curso para asegurar el flujo continuo de trabajo.                   |
| **Revisión**      | Después de completar una tarea, se mueve aquí para una revisión de código y revisión por pares (peer review). Esta fase incluye la creación de **pull requests** para asegurar que el código cumpla con los estándares de calidad antes de integrarse al proyecto principal. |
| **En Pruebas**    | Contiene las tareas que han pasado la revisión de código y necesitan pruebas exhaustivas (unitarias, de integración y de aceptación) para garantizar su calidad. |
| **Hecho**         | Las tareas completamente desarrolladas, revisadas y probadas se mueven aquí, indicando que están listas y finalizadas.                               |

Mira cómo va avanzando nuestro trabajo visitando el siguiente enlace: [Tablero de Trello](https://trello.com/b/pC5te4pD/grupo04-transa).


### Funcionalidades de la Aplicación TestTrue U

#### **Módulo de Gestión de Usuarios:**

- **Creación de Estudiantes e Inicio de Sesión:**
    - Permitir a los Estudiantes registrarse en la plataforma.
    - Facilitar el inicio de sesión para acceder a la cuenta personal.
    - Mantener la seguridad de las credenciales de los usuarios.
    - Poder inhabilitar y eliminar la cuenta.
      
- **Informacion de la Sesión:**
    - Permitir a los Estudiantes editar informacion de su perfil creado.
    - Mostrar los resultados de la Evaluacion Vocacional.
    - Opcion de poder comparar las opciones de carreras.
      
#### **Módulo de Evaluación Vocacional:**

- **Evaluacion Vocacional funcional**
    - Realizar una Prueba Vocacional que muestre resultados de carreras.
    - Los de plan premium pueden tener la opcion de realizar nuevamente las pruebas.
    - Se pueda Visualizar 3 carreras como opcion.

#### **Módulo de Conexión con Expertos:**

- **Gestión de Expertos:**
    - Opcion de agendar sesiones con expertos con notificaciones.
    - Mostrar la informacion de los expertos para los Alumnos.
    - Permitir inicios de sesion de los orientadores ya seleccionados por la empresa.
      
- **Funciones para el perfil de Expertos:**
    - Buscar los expertos requeridos en el campo necesario segun los resultados.
    - Generar reseñas para los orientadores.

#### **Módulo de Recursos Educativos:**

- **Gestión de Informacion de las Carreras:**
    - Visualizar una descripcion detallada con videos e imganes.
    - Visualizar enlaces a articulos sobre el mercado laboral de la carrera.
    - Detalles con opciones de las especialidades de las Carreras.
    - Personalizar los recursos que se desea observar.
    - Poder guardar los recursos de las carreras para su revision despues.

#### **Módulo de Pagos en Línea: **

- **Gestion de pagos en Línea:**
    - Escoger entre diferentes planes de suscripcion.
    - Integracion con Paypal y otros metodos de pago.
    - Procesamiento de transacciones para el pago de la suspcripcion.
    - Desbloquear opciones y recursos al ser usuario Premium.
    - Registrar los pagos en un historial.

### Diagramas de la Aplicación

Para entender mejor la estructura y diseño de la aplicación "TrueTest-u", revisa los siguientes diagramas:

### Diagrama de Clases

![Diagrama de Clases]()


### Diagrama de Base de Datos

![Diagrama de Base de Datos]()

Este diagrama ilustra el esquema de la base de datos utilizada por la aplicación, mostrando las tablas, columnas, y relaciones entre las entidades.

### Descripción de Capas del Proyecto

| capa        | descripción                                                                                  |
|-------------|----------------------------------------------------------------------------------------------|
| api         | Contiene los controladores REST que manejan las solicitudes HTTP y las respuestas.            |
| entity      | Define las entidades del modelo de datos que se mapean a las tablas de la base de datos.      |
| repository  | Proporciona la interfaz para las operaciones CRUD y la interacción con la base de datos.      |
| service     | Declara la lógica de negocio y las operaciones que se realizarán sobre las entidades.         |
| service impl| Implementa la lógica de negocio definida en los servicios, utilizando los repositorios necesarios. |

# Asignación de Historias de Usuario

**Sprint 1:** Funcionalidades Básicas  
  *Enfocado en implementar las funcionalidades esenciales de CRUD para la gestión de categorías, libros, autores, usuarios, y el flujo inicial de compras, asegurando que el producto esté listo para un uso básico.*


| Integrante  | Módulo                       | Historia de Usuario                                                   | Descripción                                                                                                                                      | Tipo  |
|-------------|------------------------------|----------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|-------|
| Integrante 1| Gestión de Categorías         | Historia de Usuario 1: Crear categorías.                              | Como administrador, quiero poder crear, leer, actualizar y eliminar categorías para mantener organizada la colección de libros.                   | CRUD  |
|             | Gestión de Libros             | Historia de Usuario 2: Crear libros.                                  | Como administrador, quiero poder crear, leer, actualizar y eliminar libros para mantener actualizada la oferta disponible en la plataforma.       | CRUD  |
| Integrante 2| Gestión de Autores            | Historia de Usuario 3: Crear autores.                                 | Como administrador, quiero poder crear, leer, actualizar y eliminar información de autores para mantener actualizada la base de datos de autores de libros. | CRUD  |
|             | Gestión de Reportes           | Historia de Usuario 4: Generar reportes básicos de libros por categoría. | Como administrador, quiero generar reportes de libros filtrados por categoría para obtener información sobre el catálogo disponible.              | CRUD  |
| Integrante 3| Gestión de Usuarios           | Historia de Usuario 5: Registrar usuarios.                            | Como usuario, quiero poder registrarme en la plataforma para acceder a las funcionalidades disponibles.                                           | CRUD  |
|             | Gestión de Usuarios           | Historia de Usuario 6: Permitir a los usuarios actualizar su información personal. | Como usuario, quiero poder actualizar mi información personal para mantener mis datos al día en la plataforma.                                    | CRUD  |
|             | Gestión de Usuarios           | Historia de Usuario 9: Ver Detalles de mi Perfil.                     | Como usuario, quiero poder ver todos los detalles de mi perfil en una sección dedicada para revisar mi información personal y mi historial de actividad en la plataforma. | CRUD  |
| Integrante 4| Gestión de Compras            | Historia de Usuario 10: Configurar flujo inicial de compra de libros (sin integración de pago). | Como usuario, quiero poder seleccionar libros para comprarlos, simulando el flujo de compra inicial antes de integrar los métodos de pago.       | Core  |
|             | Gestión de Reportes           | Historia de Usuario 11: Generar reporte de historial de compras.       | Como usuario, quiero generar un reporte de mi historial de compras para revisar las transacciones realizadas en la plataforma.                    | Core  |
| Integrante 5| Gestión de Colección de Libros | Historia de Usuario 12: Añadir libros a la colección del usuario.      | Como usuario, quiero poder añadir libros a mi colección personal para organizar mis lecturas y favoritos en un solo lugar.                        | Core  |
|             | Gestión de Colección de Libros | Historia de Usuario 13: Eliminar libros de la colección del usuario.   | Como usuario, quiero poder eliminar libros de mi colección personal cuando ya no los necesite o no desee tenerlos en mi lista.                    | Core  |
|             | Gestión de Colección de Libros | Historia de Usuario 14: Ver la lista de libros en la colección del usuario. | Como usuario, quiero ver la lista completa de libros en mi colección para gestionar y revisar fácilmente mis libros favoritos.                    | CRUD  |




 **Sprint 2:** Integración de Funcionalidades y Optimización del Producto  
  *Orientado a la implementación de funcionalidades adicionales, como filtros, reportes detallados, integración de métodos de pago, autenticación y autorización de usuarios, optimización del sistema, y exportación de datos, para garantizar un producto final completo y funcional.*

| Integrante  | Módulo                       | Historia de Usuario                                                   | Descripción                                                                                                                                      | Tipo  |
|-------------|------------------------------|----------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|-------|
| Integrante 1| Gestión de Categorías         | Historia de Usuario 21: Filtrar categorías por criterios específicos. | Como administrador, quiero poder filtrar categorías por criterios específicos para gestionar mejor la organización del catálogo de libros.        | CRUD  |
|             | Gestión de Libros             | Historia de Usuario 22: Implementar paginación en la lista de libros. | Como administrador, quiero poder ver la lista de libros con paginación para facilitar la gestión de grandes volúmenes de datos en la plataforma.  | Core  |
|             | Gestión de Reportes           | Historia de Usuario 23: Exportar reportes de libros por categoría en PDF y Excel. | Como administrador, quiero exportar reportes de libros por categoría en formatos PDF y Excel para facilitar la presentación y análisis de datos. | Core  |
| Integrante 2| Gestión de Autores            | Historia de Usuario 24: Buscar y filtrar autores por nombre o nacionalidad. | Como administrador, quiero poder buscar y filtrar autores por nombre o nacionalidad para mejorar la gestión y actualización de la base de datos de autores. | CRUD  |
|             | Gestión de Reportes           | Historia de Usuario 25: Generar reportes avanzados de libros por autor. | Como administrador, quiero generar reportes avanzados que muestren los libros agrupados por autor para analizar el inventario de la biblioteca.   | Core  |
|             | Gestión de Compras            | Historia de Usuario 26: Integrar métodos de pago adicionales.          | Como usuario, quiero contar con diferentes métodos de pago para poder elegir la opción más conveniente al realizar una compra.                    | Core  |
| Integrante 3| Gestión de Usuarios           | Historia de Usuario 27: Implementar autenticación y autorización con roles. | Como administrador, quiero poder gestionar los accesos de los usuarios mediante roles y permisos para asegurar la seguridad y privacidad de la información. | Core  |
|             | Gestión de Usuarios           | Historia de Usuario 28: Inicio de sesión con Google.                  | Como usuario, quiero iniciar sesión en la plataforma utilizando mi cuenta de Google para mayor comodidad y seguridad.                              | Core  |
|             | Gestión de Reportes           | Historia de Usuario 29: Generar reporte de historial de compras del usuario en PDF. | Como usuario, quiero generar un reporte en formato PDF que detalle todas mis compras realizadas en la plataforma, para tener un registro claro de mis transacciones. | Core  |
| Integrante 4| Gestión de Compras            | Historia de Usuario 30: Integrar funcionalidad completa de pagos con PayPal. | Como usuario, quiero poder completar mi compra de libros utilizando PayPal, asegurando una transacción segura y fluida.                           | Core  |
|             | Gestión de Compras            | Historia de Usuario 31: Generar reportes de ventas detallados con filtros avanzados. | Como administrador, quiero generar reportes de ventas detallados que incluyan filtros avanzados para analizar mejor las transacciones y el comportamiento del cliente. | Core  |
|             | Gestión de Reportes           | Historia de Usuario 32: Generar reporte de ventas totales por periodo en PDF. | Como administrador, quiero generar un reporte en formato PDF que muestre las ventas totales por un periodo determinado para evaluar el rendimiento de la tienda. | Core  |
| Integrante 5| Gestión de Colección de Libros | Historia de Usuario 33: Implementar filtros avanzados en la colección de libros del usuario. | Como usuario, quiero poder filtrar mi colección de libros utilizando múltiples criterios como género, autor, y fecha de adición para una mejor organización. | Core  |
|             | Gestión de Colección de Libros | Historia de Usuario 34: Exportar la colección de libros a diferentes formatos. | Como usuario, quiero poder exportar mi colección de libros en formatos como CSV y PDF para tener una copia personal de mis libros organizados.     | Core  |
|             | Gestión de Colección de Libros | Historia de Usuario 35: Compartir la colección de libros con otros usuarios. | Como usuario, quiero poder compartir mi colección de libros con otros usuarios para recomendar libros y discutir lecturas.                        | Core  |


## Recomendaciones 

1. **Comunicación Constante:** Mantener una comunicación abierta y constante entre todos los miembros del equipo para resolver dudas y compartir avances. Utilizar herramientas colaborativas como Slack o Microsoft Teams para facilitar la interacción.

2. **Revisión de Código:** Implementar prácticas de revisión de código entre pares para asegurar la calidad del software y fomentar el aprendizaje mutuo. Esto ayudará a detectar errores a tiempo y a mejorar la calidad del código entregado.

3. **Gestión del Tiempo:** Planificar y gestionar bien el tiempo para cada historia de usuario, priorizando aquellas que son críticas para el funcionamiento básico del sistema. Utilizar técnicas como el método Pomodoro para mantener la concentración y eficiencia.

4. **Pruebas Continuas:** Realizar pruebas continuas de las funcionalidades desarrolladas para identificar y corregir errores tempranamente. Asegurar que cada historia de usuario esté completamente probada antes de considerarla terminada.

5. **Documentación Clara:** Mantener una documentación clara y actualizada del código y de las decisiones tomadas durante el desarrollo. Esto facilitará el mantenimiento y futuras mejoras del producto.

6. **Retroalimentación Regular:** Programar sesiones regulares de retroalimentación al final de cada sprint para evaluar lo que funcionó bien y qué se puede mejorar. Utilizar estas sesiones para ajustar las estrategias y métodos de trabajo según sea necesario.

7. **Enfoque en el Usuario:** Mantener siempre al usuario final en mente durante el desarrollo. Asegurar que todas las funcionalidades implementadas aporten valor al usuario y mejoren su experiencia con la plataforma.

8. **Gestión de Riesgos:** Identificar posibles riesgos que puedan afectar el desarrollo del proyecto y planificar estrategias para mitigarlos. Esto incluye problemas técnicos, falta de recursos o cambios en los requisitos.

9. **Optimización del Rendimiento:** Asegurarse de que las funcionalidades añadidas no comprometan el rendimiento del sistema. Realizar pruebas de carga y optimización cuando sea necesario para garantizar una experiencia de usuario fluida.


