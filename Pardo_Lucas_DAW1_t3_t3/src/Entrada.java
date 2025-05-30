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
        System.out.println("Para empezar, crea tu primera biblioteca. Introduce los siguientes datos.");
        System.out.println();
        System.out.print("Nombre de la biblioteca: ");
        String nombreBiblioteca = scanner.nextLine();
        System.out.print("Director de la biblioteca: ");
        String directorBiblioteca = scanner.nextLine();
        Biblioteca biblioteca = new Biblioteca(nombreBiblioteca, directorBiblioteca);
        System.out.println("Biblioteca creada con éxito.");
        System.out.println();
        do {
            try {
                System.out.println("¿Qué deseas hacer?");
                System.out.println("1. Crear un catálogo.");
                System.out.println("2. Añadir un libro al catálogo.");
                System.out.println("3. Buscar un libro del catálogo.");
                System.out.println("4. Eliminar un libro del catálogo.");
                System.out.println("5. Listar todos los libros del catálogo.");
                System.out.println("6. Exportar catálogo.");
                System.out.println("7. Salir del programa.");
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
                            System.out.println();
                        }
                        break;
                    case 3:
                        System.out.println();
                        try {
                            biblioteca.buscarLibro();
                        } catch (ExcepcionesPersonalizadas.NoExisteCatalogo |
                                 ExcepcionesPersonalizadas.LibroNoEncontrado e) {
                            System.out.println("⚠️ Error: " + e.getMessage());
                            System.out.println();
                        }
                        break;
                    case 4:
                        System.out.println();
                        try {
                            biblioteca.eliminarLibro();
                        } catch (ExcepcionesPersonalizadas.NoExisteCatalogo e) {
                            System.out.println("⚠️ Error: " + e.getMessage());
                            System.out.println();
                        }
                        break;
                    case 5:
                        System.out.println();
                        try {
                            biblioteca.listarLibros();
                        } catch (ExcepcionesPersonalizadas.NoExisteCatalogo e) {
                            System.out.println("⚠️ Error: " + e.getMessage());
                            System.out.println();
                        }
                        break;
                    case 6:
                        System.out.println();
                        try {
                            biblioteca.exportarCatalogo("src/resources/ficheroLibros.txt");
                        } catch (ExcepcionesPersonalizadas.NoExisteCatalogo e) {
                            System.out.println("⚠️ Error: " + e.getMessage());
                            System.out.println();
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
                        System.out.println();
                        break;
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
