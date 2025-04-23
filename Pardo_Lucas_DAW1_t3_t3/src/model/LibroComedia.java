package model;

public class LibroComedia extends Libro {
    String tipoHumor;

    public LibroComedia() {
    }

    public LibroComedia(String titulo, String autor, String genero, long isbn, String tipoHumor) {
        super(titulo, autor, genero, isbn);
        this.tipoHumor = tipoHumor;
    }

    public String getTipoHumor() {
        return tipoHumor;
    }

    public void setTipoHumor(String tipoHumor) {
        this.tipoHumor = tipoHumor;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Tipo de humor: " + tipoHumor);
    }
}
