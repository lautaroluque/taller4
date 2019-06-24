package com.taller4.api;

import com.taller4.api.repositorios.UsuarioRepository;
import java.util.Date;
import com.taller4.api.dominio.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LlenarDB {

  @Bean
  CommandLineRunner initDatabase(UsuarioRepository repoUsuarios) {
    return args -> {
      repoUsuarios.save(new Usuario("Admin", "admin@admin", new Date()));
    };
  }
}