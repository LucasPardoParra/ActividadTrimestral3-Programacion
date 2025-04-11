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
//      - Excepciones personalizadas:
//          - se actúa sobre un catálogo inexistente (runtime exception)
//          - no hay hueco en el catálogo para meter libros
//          - se busca un libro que no existe
//
// Clase "Libros":
//      - Subclases:
//          - terror: autor, numeroPaginas, ISBN, calificacion
//          - comedia: autor, numeroPaginas, ISBN, tipoHumor
//          - ensayo: autor, numeroPaginas, ISBN, tema
//          - policiaca: autor, numeroPaginas, ISBN, trama (misterio o intriga), personajes
//
// Acciones para el vídeo:
//      1. Crea una biblioteca
//      2. Crea un catálogo de 4 libros
//      3. Agregar 5 libros al catálogo
//      4. Muestra la información de todos los libros
//      5. Exporta todos los libros del catálogo a un fichero llamado libros.obj

import controller.Biblioteca;
import utils.ExcepcionesPersonalizadas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int isbn;
        int opcionMenu = 0;

        System.out.println("\n--------------------------------------------------");
        System.out.println("¡Bienvenido al Programa de Gestión de Bibliotecas!");
        System.out.println("Para empezar, crea tu primera biblioteca. Introduce los siguientes datos");
        System.out.println();
        System.out.print("Nombre de la biblioteca: ");
        String nombreBiblioteca = scanner.nextLine();
        System.out.print("Director de la biblioteca: ");
        String directorBiblioteca = scanner.nextLine();
        Biblioteca biblioteca = new Biblioteca(nombreBiblioteca, directorBiblioteca);
        System.out.println("Biblioteca creada con éxito");
        System.out.println();
        do {
            try {
                System.out.println("¿Qué deseas hacer?");
                System.out.println("1. Crear un catálogo");
                System.out.println("2. Añadir un libro al catálogo");
                System.out.println("3. Eliminar un libro del catálogo");
                System.out.println("4. Buscar un libro del catálogo");
                System.out.println("5. Listar todos los libros del catálogo");
                System.out.println("6. Exportar catálogo a un fichero");
                System.out.println("7. Salir del programa");
                System.out.print("Introduce una opción: ");

                opcionMenu = scanner.nextInt();
                switch (opcionMenu) {
                    case 1:
                        System.out.println();
                        biblioteca.crearCatalogo();
                        break;
                    case 2:
                        System.out.println();
                        try {
                            biblioteca.agregarLibro();
                        } catch (ExcepcionesPersonalizadas.NoExisteCatalogo |
                                 ExcepcionesPersonalizadas.CatalogoLleno e) {
                            System.out.println("⚠️ Error: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println();
                        System.out.print("Introduzca el ISBN del libro que desea buscar: ");
                        isbn = scanner.nextInt();
                        try {
                            biblioteca.buscarLibro(isbn);
                        } catch (ExcepcionesPersonalizadas.NoExisteCatalogo e) {
                            System.out.println("⚠️ Error: " + e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("Introduzca el ISBN del libro que desea eliminar: ");
                        isbn = scanner.nextInt();
                        try {
                            biblioteca.eliminarLibro(isbn);
                        } catch (ExcepcionesPersonalizadas.NoExisteCatalogo e) {
                            System.out.println("⚠️ Error: " + e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.println();
                        try {
                            biblioteca.listarLibros();
                        } catch (ExcepcionesPersonalizadas.NoExisteCatalogo e) {
                            System.out.println("⚠️ Error: " + e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println();
                        try {
                            biblioteca.exportarCatalogo();
                        } catch (ExcepcionesPersonalizadas.NoExisteCatalogo e) {
                            System.out.println("⚠️ Error: " + e.getMessage());
                        }
                        break;
                    case 7:
                        System.out.println();
                        System.out.println("Saliendo del programa...");
                        System.out.println("Gracias por usar el programa de gestión de bibliotecas. ¡Hasta pronto!");
                        System.out.println("--------------------------------------------------\n");
                        break;
                    default:
                        System.out.println();
                        System.out.println("Opción no válida, por favor introduce un número del 1 al 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("⚠️ Error: Has introducido un caracter incorrecto.");
                System.out.println("Por favor, introduce un número del 1 al 7.");
                System.out.println();
                scanner.nextLine(); // Limpiamos el buffer del scanner para que no ocurra un bucle infinito
            }
        } while (opcionMenu != 7);
    }
}
