package com.taller4.app.dominio;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Audio 
{
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String ubicacion;


    public Audio() {
    }

    public Audio(Integer id, String ubicacion) {
        this.id = id;
        this.ubicacion = ubicacion;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Audio id(Integer id) {
        this.id = id;
        return this;
    }

    public Audio ubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Audio)) {
            return false;
        }
        Audio audio = (Audio) o;
        return Objects.equals(id, audio.id) && Objects.equals(ubicacion, audio.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ubicacion);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", ubicacion='" + getUbicacion() + "'" +
            "}";
    }

}