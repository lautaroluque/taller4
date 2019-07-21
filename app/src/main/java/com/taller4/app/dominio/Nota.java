package com.taller4.app.dominio;

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
    private Integer[] audios;
    private Integer[] imagenes;
    private Integer dueño;
    private Integer[] categorias;

    public Nota() {
    }

    public Nota(Integer id, String nombre, String contenido, Integer[] audios, Integer[] imagenes, Integer dueño, Integer[] categorias) {
        this.id = id;
        this.nombre = nombre;
        this.contenido = contenido;
        this.audios = audios;
        this.imagenes = imagenes;
        this.dueño = dueño;
        this.categorias = categorias;
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

    public Integer[] getAudios() {
        return this.audios;
    }

    public void setAudios(Integer[] audios) {
        this.audios = audios;
    }

    public Integer[] getImagenes() {
        return this.imagenes;
    }

    public void setImagenes(Integer[] imagenes) {
        this.imagenes = imagenes;
    }

    public Integer getDueño() {
        return this.dueño;
    }

    public void setDueño(Integer dueño) {
        this.dueño = dueño;
    }

    public Integer[] getCategorias() {
        return this.categorias;
    }

    public void setCategorias(Integer[] categorias) {
        this.categorias = categorias;
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

    public Nota audios(Integer[] audios) {
        this.audios = audios;
        return this;
    }

    public Nota imagenes(Integer[] imagenes) {
        this.imagenes = imagenes;
        return this;
    }

    public Nota dueño(Integer dueño) {
        this.dueño = dueño;
        return this;
    }

    public Nota categorias(Integer[] categorias) {
        this.categorias = categorias;
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
        return Objects.equals(id, nota.id) && Objects.equals(nombre, nota.nombre) && Objects.equals(contenido, nota.contenido) && Objects.equals(audios, nota.audios) && Objects.equals(imagenes, nota.imagenes) && Objects.equals(dueño, nota.dueño) && Objects.equals(categorias, nota.categorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, contenido, audios, imagenes, dueño, categorias);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", contenido='" + getContenido() + "'" +
            ", audios='" + getAudios() + "'" +
            ", imagenes='" + getImagenes() + "'" +
            ", dueño='" + getDueño() + "'" +
            ", categorias='" + getCategorias() + "'" +
            "}";
    }

}