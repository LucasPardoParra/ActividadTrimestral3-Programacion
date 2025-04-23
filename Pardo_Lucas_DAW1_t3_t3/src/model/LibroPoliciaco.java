package model;

public class LibroPoliciaco extends Libro {
    String trama;

    public LibroPoliciaco() {
    }

    public LibroPoliciaco(String titulo, String autor, String genero, long isbn, String trama) {
        super(titulo, autor, genero, isbn);
        this.trama = trama;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Trama: " + trama);
    }
}
