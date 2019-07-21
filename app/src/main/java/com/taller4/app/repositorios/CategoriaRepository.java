package com.taller4.app.repositorios;

import com.taller4.app.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>  {

}