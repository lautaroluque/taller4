package com.taller4.api.repositorios;

import com.taller4.api.dominio.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Integer>  {

}