package model;

public class LibroEnsayo extends Libro {
    String tema;

    public LibroEnsayo() {
    }

    public LibroEnsayo(String titulo, String autor, String genero, long isbn, String tema) {
        super(titulo, autor, genero, isbn);
        this.tema = tema;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Tema: " + tema);
    }
}
