package com.taller4.api.dominio;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String nombre;
    private String email;
    private Date fechaDeNacimiento;

    public Usuario() {
    }

    public Usuario(String nombre, String email, Date fechaDeNacimiento) {
        this.nombre = nombre;
        this.email = email;
        this.fechaDeNacimiento = fechaDeNacimiento;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaDeNacimiento() {
        return this.fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Usuario id(Integer id) {
        this.id = id;
        return this;
    }

    public Usuario nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Usuario email(String email) {
        this.email = email;
        return this;
    }

    public Usuario fechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nombre, usuario.nombre) && Objects.equals(email, usuario.email) && Objects.equals(fechaDeNacimiento, usuario.fechaDeNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, fechaDeNacimiento);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", email='" + getEmail() + "'" +
            ", fechaDeNacimiento='" + getFechaDeNacimiento() + "'" +
            "}";
    }
}