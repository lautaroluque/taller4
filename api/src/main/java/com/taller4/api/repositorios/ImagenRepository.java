package com.taller4.api.repositorios;

import com.taller4.api.dominio.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Integer>  {

}