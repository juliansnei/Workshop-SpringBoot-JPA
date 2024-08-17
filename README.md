# Workshop-SpringBoot-JPA

Creación de una Aplicación CRUD con 
Spring Boot y Thymeleaf usando 
MySQL
Objetivo del Taller:
Desarrollar una aplicación web utilizando Spring Boot y Thymeleaf para gestionar 
una lista de tareas diarias, utilizando MySQL como sistema de gestión de bases 
de datos. La aplicación permitirá realizar operaciones CRUD (Crear, Leer, 
Actualizar, Eliminar) sobre las tareas, ademas de una operacion para 
buscarTareas por nombre y ver el detalle de una especial.
Descripción:
En este taller, los coders crearán una aplicación web que integra el backend con 
Spring Boot y el frontend con Thymeleaf, aplicando prácticas comunes en el 
desarrollo profesional de software. Los estudiantes trabajarán con MySQL para 
manejar las operaciones de base de datos.
Tareas a Desarrollar:
Los participantes deberán configurar un proyecto Spring Boot, incluyendo las 
dependencias necesarias para Spring Web, Thymeleaf, Spring Data JPA, y el 
Driver de MySQL. La configuración de la conexión a la base de datos deberá 
especificarse en application.properties.
Atributos de la Clase Tarea
 id (Long): Identificador único de la tarea. Este campo será la clave 
primaria.
Anotaciones: @Id, @GeneratedValue(strategy = 
GenerationType.IDENTITY)
 titulo (String): Título de la tarea. Este campo almacenará un breve 
encabezado de lo que involucra la tarea.
o Anotaciones: @Column(length = 100, nullable = false)
 descripcion (String): Descripción detallada de la tarea. Este campo 
permitirá una explicación más extensa sobre la tarea.
o Anotaciones: @Column(length = 255, nullable = true)
 fechaCreacion (LocalDate): Fecha en la que la tarea fue creada o 
registrada en el sistema.
o Anotaciones: @Column(nullable = false)
 horaCreacion (LocalTime): Hora exacta en que la tarea fue registrada. 
Este campo complementa la fechaCreacion para tener un registro más 
preciso del momento de creación.
o Anotaciones: @Column(nullable = false)
 estado (String): Estado actual de la tarea, que puede incluir valores como 
"pendiente", "completada", o "cancelada".
o Anotaciones: @Column(length = 50, nullable = false)
