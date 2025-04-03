// Catálogo de una biblioteca:
// 1. agregar libros
// 2. eliminar libros
// 3. buscar libros
// 4. mostrar todos los libros disponibles.
//
// Clase "Biblioteca":
//      - Variables: nombre, director, catálogo.
//      - Funcionalidades:
//          - mostrar datos(String ISBN)
//          - construir catálogo: crear un array con n libros (no más)
//          - Consultar número de libros del catálogo
//          - Agregar libros al catálogo si hay sitio y no está repetido
//          - eliminar libro
//          - buscar libro (por nombre, o isbn)
//      - A tener en cuenta:
//          - Puede no haber catálogo, habrá que lanzar dicha excepción
//          - No hay catálogo sin biblioteca
//          - se puede obtener información de un libro sin estar en la biblioteca
//          - hay bibliotecas especializadas y bibliotecas generales
//      - Excepciones personalizadas:
//          - no hay hueco en el catálogo para meter libros
//          - no existe el libro
//          - se actúa sobre un catálogo inexistente (runtime exception)
//
// Clase "Libros":
//      - Subclases:
//          - terror: autor, numeroPaginas, ISBN, calificacion
//          - comedia: autor, numeroPaginas, ISBN, tipoHumor
//          - ensayo: autor, numeroPaginas, ISBN, tema
//          - policiaca: autor, numeroPaginas, ISBN, trama (misterio o intriga), personajes
//
// Clase "Entrada":
//      - Acciones:
//          1. Crea una biblioteca
//          2. Crea un catálogo de 4 libros
//          3. Agregar 5 libros al catálogo
//          4. Muestra la información de todos los libros
//          5. Exporta todos los libros del catálogo a un fichero llamado libros.obj

import controller.Biblioteca;
import model.Libro;
import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);
    static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        bienvenida();
        menuIterativo();

    }

    public static void bienvenida() {
        System.out.println("¡Bienvenido al Programa de Gestión de Bibliotecas!");
        System.out.println("Para empezar, crea tu primera biblioteca. Introduce los siguientes datos");
        System.out.println();
        System.out.print("Nombre de la biblioteca: ");
        biblioteca.setNombre(scanner.next());
        System.out.println();
        System.out.print("Director de la biblioteca");
        biblioteca.setDirector(scanner.next());
        System.out.println();
        System.out.println("Biblioteca creada con éxito");
        System.out.println();
    }

    public static void menuIterativo() {
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Crear un catálogo");
        System.out.println("2. Añadir un libro al catálogo");
        System.out.println("3. Buscar un libro del catálogo");
        System.out.println("4. Eliminar un libro del catálogo");
        System.out.println("5. Listar todos los libros del catálogo");
        System.out.println("6. Salir del programa");
    }

}
