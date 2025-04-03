package model;

public class LibroComedia extends Libro {
    String tipoHumor;

    @Override
    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Tipo de humor: " + tipoHumor);
    }
}
