package com.taller4.api.excepciones;

public class NotaNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotaNotFoundException(Integer id) {
        super("Nota no encontrada " + id);
    }
}