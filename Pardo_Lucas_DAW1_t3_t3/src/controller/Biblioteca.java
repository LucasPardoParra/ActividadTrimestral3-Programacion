package controller;

import model.Libro;
import model.LibroComedia;
import model.LibroPoliciaco;
import model.LibroTerror;
import model.LibroEnsayo;
import utils.ExcepcionesPersonalizadas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Biblioteca {
    String nombre, director;
    ArrayList<Libro> catalogo;
    boolean isCatalogo = false;
    int catalogoMaxSize;
    Scanner scanner = new Scanner(System.in);

    // Constructores
    public Biblioteca() {
    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    // Metodos

    public void crearCatalogo() {
        try {
            if (!isCatalogo) {
                System.out.println("¿Cuántos libros tendrá tu catálogo?");
                catalogoMaxSize = scanner.nextInt();
                this.catalogo = new ArrayList<>();
                this.isCatalogo = true;
                System.out.println("El catálogo de libros ha sido creado");
                System.out.println();
            } else {
                System.out.println("El catálogo ya existía antes. Prueba a añadir libros.");
                System.out.println();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error al crear el catálogo. Escoja un nº de libros válido.");
            System.out.println();
        }
    }

    public void agregarLibro() throws ExcepcionesPersonalizadas.NoExisteCatalogo, ExcepcionesPersonalizadas.CatalogoLleno {
        boolean opcionValida = false;
        long isbn;

        if (!isCatalogo) {
            throw new ExcepcionesPersonalizadas.NoExisteCatalogo("No existe un catálogo creado. Por favor, crea un catálogo primero.");
        }

        if (catalogoMaxSize == catalogo.size()) {
            throw new ExcepcionesPersonalizadas.CatalogoLleno("El catálogo está lleno. No se pueden añadir más libros.");
        }

        try {
            System.out.print("Introduce el ISBN del libro: ");
            isbn = scanner.nextLong();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error al agregar el libro: introduzca un ISBN válido.");
            return;
        }
        System.out.print("Introduce el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.println();

        try {
            do {
                System.out.println("Escoge el género del libro:");
                System.out.println("1. Comedia");
                System.out.println("2. Terror");
                System.out.println("3. Policiaco");
                System.out.println("4. Ensayo");
                String genero = scanner.nextLine();

                switch (genero) {
                    case "1":
                        System.out.print("Introduce el tipo de humor: ");
                        String tipoHumor = scanner.nextLine();
                        catalogo.add(new LibroComedia(titulo, autor, genero, isbn, tipoHumor));
                        System.out.println("Libro de comedia agregado con éxito");
                        opcionValida = true;
                        break;
                    case "2":
                        System.out.print("Introduce la calificación: ");
                        String calificacion = scanner.nextLine();
                        catalogo.add(new LibroTerror(titulo, autor, genero, isbn, calificacion));
                        System.out.println("Libro de terror agregado con éxito");
                        opcionValida = true;
                        break;
                    case "3":
                        System.out.print("Introduce la trama: ");
                        String trama = scanner.nextLine();
                        catalogo.add(new LibroPoliciaco(titulo, autor, genero, isbn, trama));
                        opcionValida = true;
                        break;
                    case "4":
                        System.out.print("Introduce el tema: ");
                        String tema = scanner.nextLine();
                        catalogo.add(new LibroEnsayo(titulo, autor, genero, isbn, tema));
                        opcionValida = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor intenta de nuevo.");
                }
            } while (!opcionValida);
        } catch (InputMismatchException e) {
            System.out.println("Error al agregar el libro: introduzca un género válido (nº del 1 al 4");
        }

    }

    public void buscarLibro(int isbn) throws ExcepcionesPersonalizadas.NoExisteCatalogo {
        if (!isCatalogo) {
            throw new ExcepcionesPersonalizadas.NoExisteCatalogo("No existe un catálogo creado. Por favor, crea un catálogo primero.");
        }

        try {
            boolean libroEncontrado = false;
            for (Libro libro : catalogo) {
                if (libro.getIsbn() == isbn) {
                    libro.mostrarDatos();
                    libroEncontrado = true;
                    break;
                }
            }
            if (!libroEncontrado) {
                System.out.println("Lo sentimos, el libro que buscas no está en el catálogo");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error al buscar el libro. Por favor, introduce un ISBN válido.");
        }
    }

    public void eliminarLibro(int isbn) throws ExcepcionesPersonalizadas.NoExisteCatalogo {
        if (!isCatalogo) {
            throw new ExcepcionesPersonalizadas.NoExisteCatalogo("No existe un catálogo creado. Por favor, crea un catálogo primero.");
        }

        try {
            boolean libroEncontrado = false;
            for (Libro libro : catalogo) {
                if (libro.getIsbn() == isbn) {
                    catalogo.remove(libro);
                    System.out.println("Libro eliminado con éxito");
                    libroEncontrado = true;
                    break;
                }
            }
            if (!libroEncontrado) {
                System.out.println("Este libro no existe en el catálogo, lo sentimos");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error al eliminar el libro. Por favor, introduce un ISBN válido.");
        }
    }

    public void listarLibros() throws ExcepcionesPersonalizadas.NoExisteCatalogo {
        if (!isCatalogo) {
            throw new ExcepcionesPersonalizadas.NoExisteCatalogo("No existe un catálogo creado. Por favor, crea un catálogo primero.");
        }

        try {
            if (catalogo.isEmpty()) {
                System.out.println("No hay libros en el catálogo.");
            } else {
                System.out.println("Hay " + catalogo.size() + " libros en el catálogo.");
                System.out.println("Aquí tienes una lista de todos ellos:");
                System.out.println();
                for (Libro libro : catalogo) {
                    libro.mostrarDatos();
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al listar los libros.");
        }
    }

    public void exportarCatalogo() throws ExcepcionesPersonalizadas.NoExisteCatalogo {
        if (!isCatalogo) {
            throw new ExcepcionesPersonalizadas.NoExisteCatalogo("No existe un catálogo creado. Por favor, crea un catálogo primero.");
        }

        try {
            // Implementar la lógica para exportar el catálogo a un fichero
            System.out.println("Catálogo exportado con éxito");
        } catch (Exception e) {
            System.out.println("Error al exportar el catálogo: " + e.getMessage());
        }
    }
}
