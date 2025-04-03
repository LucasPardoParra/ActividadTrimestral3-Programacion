# 📚 Sistema de Gestión de Biblioteca 📖

Este proyecto es una aplicación de consola en Java que permite gestionar el catálogo de una biblioteca, facilitando operaciones como agregar, eliminar, buscar y listar libros.

## ✨ Características

- **Buscar un libro por ISBN**: Solicita el ISBN de un libro y muestra todos sus datos.
- **Construir un catálogo**: Permite definir el número máximo de libros que pueden almacenarse en la biblioteca.
- **Consultar el catálogo**: Muestra todos los libros disponibles en la biblioteca.
- **Agregar libros**: Permite añadir un libro al catálogo, siempre que haya espacio y no esté repetido.
- **Eliminar libros**: Permite eliminar un libro del catálogo por su ISBN.
- **Buscar libros**: Permite buscar un libro del catálogo por su ISBN.
- **Exportar el catálogo**: Guarda todos los libros en un fichero binario `libros.obj`.

## ⚙️ Funcionamiento

### 📋 Menú Principal

Al iniciar la aplicación, se presenta un menú con las siguientes opciones:

1. Crear una biblioteca
2. Construir un catálogo de libros
3. Agregar un libro
4. Eliminar un libro
5. Buscar un libro por ISBN
6. Mostrar todos los libros
7. Exportar catálogo a archivo
8. Salir

### 🏛️ Creación de la Biblioteca

Antes de operar con libros, se debe crear una biblioteca, la cual tendrá un nombre y un director. El resto de funciones no estarán disponibles si no se ha creado previamente una biblioteca. Una vez creada, esta función ya no estará disponible.

### 📖 Construcción del Catálogo

El usuario define el número máximo de libros que puede almacenar la biblioteca. Una vez creado el catálogo, esta función ya no estará disponible.

### ➕ Agregar un Libro

Para agregar un libro al catálogo, se solicita su información según su tipo:

- **Terror**: Autor, Número de Páginas, ISBN, Calificación.
- **Comedia**: Autor, Número de Páginas, ISBN, Tipo de Humor.
- **Policiaca**: Autor, Número de Páginas, ISBN, Trama (Misterio o Intriga), Personajes.

Si el catálogo está lleno o el libro ya existe, se lanza una excepción personalizada.

### 🔍 Buscar un Libro

Se solicita un ISBN y se muestran los datos del libro si existe en el catálogo. Si no se encuentra, se lanza una excepción personalizada.

### 📜 Listar Todos los Libros

Muestra en pantalla todos los libros almacenados en el catálogo.

### 🗑️ Eliminar un Libro

Se solicita el ISBN de un libro para eliminarlo del catálogo. Si el libro no existe, se lanza una excepción personalizada.

### 💾 Exportar Catálogo

Todos los libros se guardan en un archivo binario llamado `libros.obj`.

## 💻 Detalles Técnicos

El proyecto está compuesto por varias clases principales dentro de sus paquetes correspondientes:

- **Biblioteca (paquete _controller_)**: Representa la biblioteca con su nombre, director, catálogo y acciones correspondientes sobre los libros.
- **Libro (paquete _model_)**: Clase base para todos los libros, con atributos comunes.
- **LibroEspecializado**: Clase que extiende `Libro` según el género (Terror, Comedia, Policiaca).
- **Excepciones Personalizadas (paquete _utils_)**: Manejan errores como 'catálogo lleno' o 'libro no encontrado'.
- **Entrada**: Contiene la lógica del menú y las interacciones del usuario.

## ▶️ Ejecución

Para ejecutar la aplicación, compila y ejecuta el archivo principal que contiene el `main`. Sigue las instrucciones en pantalla para interactuar con el sistema.

Proyecto realizado por Lucas Pardo 😀
