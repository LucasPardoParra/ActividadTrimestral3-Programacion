package controller;

import model.Libro;
import model.LibroComedia;
import model.LibroPoliciaco;
import model.LibroTerror;
import model.LibroEnsayo;
import utils.ExcepcionesPersonalizadas;

import java.io.*;
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
                System.out.println("El catálogo de libros ha sido creado.");
                System.out.println();
            } else {
                System.out.println("El catálogo ya existía antes. Prueba a añadir libros.");
                System.out.println();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error al crear el catálogo. Escoja un nº de libros válido.");
            System.out.println();
            scanner.nextLine();
        }
    }

    public void agregarLibro() throws ExcepcionesPersonalizadas.NoExisteCatalogo, ExcepcionesPersonalizadas.CatalogoLleno {
        boolean opcionValida = false;
        long isbn;
        int generoOpcion;
        String genero = null;

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
            System.out.println();
            scanner.nextLine();
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
                generoOpcion = scanner.nextInt();
                scanner.nextLine();

                switch (generoOpcion) {
                    case 1:
                        genero = "Comedia";
                        System.out.print("Introduce el tipo de humor: ");
                        String tipoHumor = scanner.nextLine();
                        catalogo.add(new LibroComedia(titulo, autor, genero, isbn, tipoHumor));
                        System.out.println("Libro de comedia agregado con éxito.");
                        System.out.println();
                        opcionValida = true;
                        break;
                    case 2:
                        genero = "Terror";
                        System.out.print("Introduce la calificación: ");
                        String calificacion = scanner.nextLine();
                        catalogo.add(new LibroTerror(titulo, autor, genero, isbn, calificacion));
                        System.out.println("Libro de terror agregado con éxito.");
                        System.out.println();
                        opcionValida = true;
                        break;
                    case 3:
                        String trama;
                        boolean tramaValida = false;
                        genero = "Policiaco";
                        System.out.print("Introduce la trama: ");
                        do {
                            System.out.println("¿Qué tipo de trama es? (Misterio/Intriga)");
                            trama = scanner.nextLine();
                            if (trama.equalsIgnoreCase("misterio") || trama.equalsIgnoreCase("intriga")) {
                                tramaValida = true;
                            } else {
                                System.out.println("Error: tipo de trama no válido. Por favor, introduce 'misterio' o 'intriga'.");
                                System.out.println();
                            }
                        } while (!tramaValida);
                        catalogo.add(new LibroPoliciaco(titulo, autor, genero, isbn, trama));
                        System.out.println("Novela policiaca agregada con éxito.");
                        System.out.println();
                        opcionValida = true;
                        break;
                    case 4:
                        genero = "Ensayo";
                        System.out.print("Introduce el tema: ");
                        String tema = scanner.nextLine();
                        catalogo.add(new LibroEnsayo(titulo, autor, genero, isbn, tema));
                        System.out.println("Ensayo agregado con éxito.");
                        System.out.println();
                        opcionValida = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor intenta de nuevo.");
                        System.out.println();
                }
            } while (!opcionValida);
        } catch (InputMismatchException e) {
            System.out.println("Error al agregar el libro: introduzca un género válido (nº del 1 al 4).");
            System.out.println();
            scanner.nextLine();
        }

    }

    public void buscarLibro() throws ExcepcionesPersonalizadas.NoExisteCatalogo, ExcepcionesPersonalizadas.LibroNoEncontrado {
        if (!isCatalogo) {
            throw new ExcepcionesPersonalizadas.NoExisteCatalogo("No existe un catálogo creado. Por favor, crea un catálogo primero.");
        }

        try {
            System.out.print("Introduzca el ISBN del libro que desea buscar: ");
            long isbn = scanner.nextInt();
            System.out.println();

            boolean libroEncontrado = false;
            for (Libro libro : catalogo) {
                if (libro.getIsbn() == isbn) {
                    libro.mostrarDatos();
                    System.out.println();
                    libroEncontrado = true;
                    break;
                }
            }
            if (!libroEncontrado) {
                throw new ExcepcionesPersonalizadas.LibroNoEncontrado("Este libro no existe en el catálogo, lo sentimos.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error al buscar el libro. Por favor, introduce un ISBN válido.");
            System.out.println();
            scanner.nextLine();
        }
    }

    public void eliminarLibro() throws ExcepcionesPersonalizadas.NoExisteCatalogo {
        if (!isCatalogo) {
            throw new ExcepcionesPersonalizadas.NoExisteCatalogo("No existe un catálogo creado. Por favor, crea un catálogo primero.");
        }

        try {
            System.out.print("Introduzca el ISBN del libro que desea eliminar: ");
            long isbn = scanner.nextInt();
            System.out.println();

            boolean libroEncontrado = false;
            for (Libro libro : catalogo) {
                if (libro.getIsbn() == isbn) {
                    catalogo.remove(libro);
                    System.out.println("Libro eliminado con éxito.");
                    System.out.println();
                    libroEncontrado = true;
                    break;
                }
            }
            if (!libroEncontrado) {
                System.out.println("Este libro no existe en el catálogo, lo sentimos.");
                System.out.println();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error al eliminar el libro. Por favor, introduce un ISBN válido.");
            System.out.println();
            scanner.nextLine();
        }
    }

    public void listarLibros() throws ExcepcionesPersonalizadas.NoExisteCatalogo {
        if (!isCatalogo) {
            throw new ExcepcionesPersonalizadas.NoExisteCatalogo("No existe un catálogo creado. Por favor, crea un catálogo primero.");
        }

        try {
            if (catalogo.isEmpty()) {
                System.out.println("No hay libros en el catálogo.");
                System.out.println();
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
            System.out.println("Ha ocurrido un error al listar los libros.");
            System.out.println();
        }
    }

    public void exportarCatalogo(String path) throws ExcepcionesPersonalizadas.NoExisteCatalogo {
        if (!isCatalogo) {
            throw new ExcepcionesPersonalizadas.NoExisteCatalogo("No existe un catálogo creado. Por favor, crea un catálogo primero.");
        }

        if (catalogo.isEmpty()) {
            System.out.println("No hay libros en el catálogo para exportar.");
            System.out.println();
            return;
        }

        File ficheroLibros = new File(path);
        PrintWriter printWriter = null;

        if (!ficheroLibros.exists()) {
            try {
                ficheroLibros.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el fichero.");
                System.out.println();
            }
        }

        try {
            printWriter = new PrintWriter(new FileWriter(ficheroLibros, true));
            for (Libro libro : catalogo) {
                // Dependiendo del tipo de libro, se escribirá en el fichero unos datos u otros
                if (libro instanceof LibroComedia) {
                    printWriter.println(libro.getTitulo() + "," + libro.getAutor() + ","
                            + libro.getGenero() + "," + libro.getIsbn() + "," +
                            ((LibroComedia) libro).getTipoHumor());
                } else if (libro instanceof LibroTerror) {
                    printWriter.println(libro.getTitulo() + "," + libro.getAutor() + ","
                            + libro.getGenero() + "," + libro.getIsbn() + "," +
                            ((LibroTerror) libro).getCalificacion());
                } else if (libro instanceof LibroPoliciaco) {
                    printWriter.println(libro.getTitulo() + "," + libro.getAutor() + ","
                            + libro.getGenero() + "," + libro.getIsbn() + "," +
                            ((LibroPoliciaco) libro).getTrama());
                } else if (libro instanceof LibroEnsayo) {
                    printWriter.println(libro.getTitulo() + "," + libro.getAutor() + ","
                            + libro.getGenero() + "," + libro.getIsbn() + "," +
                            ((LibroEnsayo) libro).getTema());
                }
            }
        } catch (IOException e) {
            System.out.println("Error en la apertura del fichero");
        } catch (NullPointerException e) {
            System.out.println("Ha ocurrido un NullPointerException");
        } finally {
            try {
                printWriter.close();
            } catch (NullPointerException e) {
                System.out.println("Error al cerrar el fichero");
            }
        }
        System.out.println("El catálogo ha sido exportado con éxito a " + path);

    }

}

