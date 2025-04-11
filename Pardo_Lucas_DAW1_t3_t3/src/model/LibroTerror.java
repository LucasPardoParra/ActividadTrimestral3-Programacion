package model;

public class LibroTerror extends Libro {
    String calificacion;

    public LibroTerror() {
    }

    public LibroTerror(String titulo, String autor, String genero, long isbn, String calificacion) {
        super(titulo, autor, genero, isbn);
        this.calificacion = calificacion;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Calificación: " + calificacion);
    }
}
