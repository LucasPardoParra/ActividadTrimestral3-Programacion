package utils;

public class ExcepcionesPersonalizadas {
    public static class NoExisteCatalogo extends Exception {
        public NoExisteCatalogo(String mensaje) {
            super(mensaje);
        }
    }

    public static class CatalogoLleno extends Exception {
        public CatalogoLleno(String mensaje) {
            super(mensaje);
        }
    }

    public static class LibroNoEncontrado extends Exception {
        public LibroNoEncontrado(String mensaje) {
            super(mensaje);
        }
    }

}
