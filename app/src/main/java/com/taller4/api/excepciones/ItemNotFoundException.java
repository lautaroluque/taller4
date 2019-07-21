package com.taller4.api.excepciones;

public class ItemNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(Integer id) {
        super("Item no encontrado " + id);
    }
}