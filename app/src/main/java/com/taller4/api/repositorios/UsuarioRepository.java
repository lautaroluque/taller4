package com.taller4.api.repositorios;

import com.taller4.api.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {

}