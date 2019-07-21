package com.taller4.app.repositorios;

import com.taller4.app.dominio.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Integer>  {

}