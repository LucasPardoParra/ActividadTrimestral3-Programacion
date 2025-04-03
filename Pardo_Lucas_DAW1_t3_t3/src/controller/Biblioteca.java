package controller;

import model.Libro;

import java.util.ArrayList;

public class Biblioteca {
    String nombre, director;
    ArrayList<Libro> catalogo = new ArrayList<>();
    boolean isCatalogo = false;

    public Biblioteca() {
    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }

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

    public void crearCatalogo() {
        try {
            if (!isCatalogo) {
                this.catalogo = new ArrayList<>();
                System.out.println("El catálogo de libros ha sido creado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
