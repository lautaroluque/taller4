package com.taller4.app.dominio;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario{
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column
    private String password;
    private String nombre;
    private String email;
    private Date fechaDeNacimiento;
    private Integer[] notas;
    private Integer[] favoritos;
    private Integer[] imagenes;
    private Integer[] audios;
    private Integer[] categorias;


    public Usuario() {
    }

    public Usuario(Integer id, String username, String password, String nombre, String email, Date fechaDeNacimiento, Integer[] notas, Integer[] favoritos, Integer[] imagenes, Integer[] audios, Integer[] categorias) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.notas = notas;
        this.favoritos = favoritos;
        this.imagenes = imagenes;
        this.audios = audios;
        this.categorias = categorias;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer[] getNotas() {
        return this.notas;
    }

    public void setNotas(Integer[] notas) {
        this.notas = notas;
    }

    public Integer[] getFavoritos() {
        return this.favoritos;
    }

    public void setFavoritos(Integer[] favoritos) {
        this.favoritos = favoritos;
    }

    public Integer[] getImagenes() {
        return this.imagenes;
    }

    public void setImagenes(Integer[] imagenes) {
        this.imagenes = imagenes;
    }

    public Integer[] getAudios() {
        return this.audios;
    }

    public void setAudios(Integer[] audios) {
        this.audios = audios;
    }

    public Integer[] getCategorias() {
        return this.categorias;
    }

    public void setCategorias(Integer[] categorias) {
        this.categorias = categorias;
    }

    public Usuario id(Integer id) {
        this.id = id;
        return this;
    }

    public Usuario username(String username) {
        this.username = username;
        return this;
    }

    public Usuario password(String password) {
        this.password = password;
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

    public Usuario notas(Integer[] notas) {
        this.notas = notas;
        return this;
    }

    public Usuario favoritos(Integer[] favoritos) {
        this.favoritos = favoritos;
        return this;
    }

    public Usuario imagenes(Integer[] imagenes) {
        this.imagenes = imagenes;
        return this;
    }

    public Usuario audios(Integer[] audios) {
        this.audios = audios;
        return this;
    }

    public Usuario categorias(Integer[] categorias) {
        this.categorias = categorias;
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
        return Objects.equals(id, usuario.id) && Objects.equals(username, usuario.username) && Objects.equals(password, usuario.password) && Objects.equals(nombre, usuario.nombre) && Objects.equals(email, usuario.email) && Objects.equals(fechaDeNacimiento, usuario.fechaDeNacimiento) && Objects.equals(notas, usuario.notas) && Objects.equals(favoritos, usuario.favoritos) && Objects.equals(imagenes, usuario.imagenes) && Objects.equals(audios, usuario.audios) && Objects.equals(categorias, usuario.categorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, nombre, email, fechaDeNacimiento, notas, favoritos, imagenes, audios, categorias);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", email='" + getEmail() + "'" +
            ", fechaDeNacimiento='" + getFechaDeNacimiento() + "'" +
            ", notas='" + getNotas() + "'" +
            ", favoritos='" + getFavoritos() + "'" +
            ", imagenes='" + getImagenes() + "'" +
            ", audios='" + getAudios() + "'" +
            ", categorias='" + getCategorias() + "'" +
            "}";
    }
    
}