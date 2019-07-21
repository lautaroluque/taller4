package com.taller4.app.repositorios;

import com.taller4.app.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {
    Usuario findByUsername(String username);
}