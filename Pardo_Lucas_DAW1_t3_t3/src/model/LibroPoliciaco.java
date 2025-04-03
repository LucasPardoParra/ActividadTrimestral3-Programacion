package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LibroPoliciaco extends Libro{
    String trama;
    ArrayList<String> personajes = new ArrayList<>();

    @Override
    public void mostrarDatos() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Trama: " + trama);
        System.out.print("Personajes: ");
        for (String personaje : personajes) {
            System.out.print(personaje + ", ");
        }
    }
}
