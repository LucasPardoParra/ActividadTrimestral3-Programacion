package model;

public class LibroTerror extends Libro{
    String calificacion;

    @Override
    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Calificación: " + calificacion);
    }
}
