package com.taller4.app.excepciones;

public class ItemNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(Integer id) {
        super("Item no encontrado " + id);
    }

	public ItemNotFoundException(String item) {
        super("Item no encontrado " + item);
	}
}