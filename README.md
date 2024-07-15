Cliente API Gutendex
Descripción
Este proyecto es un cliente Java que se conecta a la API de Gutendex para buscar información sobre libros y autores. Utiliza Spring Boot para la estructura del proyecto, realiza solicitudes HTTP con HttpClient y maneja respuestas JSON utilizando la biblioteca Jackson. Además, almacena la información en una base de datos PostgreSQL.

Características
Búsqueda de libros por título en la API de Gutendex.
Almacenamiento de información de libros y autores en una base de datos PostgreSQL.
Consulta de libros por idioma.
Listado de autores vivos en un año específico.
Estadísticas sobre la cantidad de libros en determinados idiomas.
Requisitos
Java 11 o superior
Maven
PostgreSQL
Conexión a Internet para acceder a la API de Gutendex

Una vez que la aplicación esté en funcionamiento, puedes interactuar con ella desde la consola:

Buscar libro por título: Ingresa el título de un libro y la aplicación buscará y almacenará el primer resultado encontrado.
Listar todos los libros: Muestra todos los libros almacenados en la base de datos.
Salir: Termina la ejecución de la aplicación.
Estructura del Proyecto
src/main/java/: Contiene el código fuente del proyecto.
controller/: Controladores REST para manejar las solicitudes HTTP.
model/: Clases de entidad para representar los objetos Libro y Autor.
repository/: Interfaces de repositorio para la interacción con la base de datos.
service/: Servicios para la lógica de negocio.
client/: Cliente HTTP para realizar solicitudes a la API de Gutendex.
Application.java: Clase principal de la aplicación.
Ejemplos de Uso
Buscar Libro por Título
Al seleccionar la opción "1. Buscar libro por título" en el menú, se te pedirá que ingreses el título del libro. La aplicación buscará el libro en la API de Gutendex y lo almacenará en la base de datos.

Listar Todos los Libros
Al seleccionar la opción "2. Listar todos los libros" en el menú, la aplicación mostrará todos los libros almacenados en la base de datos.
