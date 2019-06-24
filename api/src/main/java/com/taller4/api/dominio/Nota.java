package com.taller4.api.dominio;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nota
{
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String contenido;

    public Nota() {
    }

    public Nota(String nombre, String contenido) {
        this.nombre = nombre;
        this.contenido = contenido;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Nota id(Integer id) {
        this.id = id;
        return this;
    }

    public Nota nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Nota contenido(String contenido) {
        this.contenido = contenido;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Nota)) {
            return false;
        }
        Nota nota = (Nota) o;
        return Objects.equals(id, nota.id) && Objects.equals(nombre, nota.nombre) && Objects.equals(contenido, nota.contenido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, contenido);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", contenido='" + getContenido() + "'" +
            "}";
    }
}