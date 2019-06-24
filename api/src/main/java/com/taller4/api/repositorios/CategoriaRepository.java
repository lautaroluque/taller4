package com.taller4.api.repositorios;

import com.taller4.api.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>  {

}