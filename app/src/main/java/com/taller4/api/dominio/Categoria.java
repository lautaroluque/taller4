package com.taller4.api.dominio;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private Integer[] notas;


    public Categoria() {
    }

    public Categoria(Integer id, String nombre, Integer[] notas) {
        this.id = id;
        this.nombre = nombre;
        this.notas = notas;
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

    public Integer[] getNotas() {
        return this.notas;
    }

    public void setNotas(Integer[] notas) {
        this.notas = notas;
    }

    public Categoria id(Integer id) {
        this.id = id;
        return this;
    }

    public Categoria nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Categoria notas(Integer[] notas) {
        this.notas = notas;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Categoria)) {
            return false;
        }
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) && Objects.equals(nombre, categoria.nombre) && Objects.equals(notas, categoria.notas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, notas);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", notas='" + getNotas() + "'" +
            "}";
    }
    
}