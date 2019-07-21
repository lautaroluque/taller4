package com.taller4.app.repositorios;

import com.taller4.app.dominio.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Integer>  {

}