package com.taller4.api;

import com.taller4.api.repositorios.NotaRepository;
import com.taller4.api.repositorios.UsuarioRepository;
import java.util.Date;

import com.taller4.api.dominio.Nota;
import com.taller4.api.dominio.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LlenarDB {

  @Bean
  CommandLineRunner initDatabaseUsuarios(UsuarioRepository repoUsuarios) {
    return args -> {
      Usuario usuario = new Usuario();
      usuario.setNombre("Admin");
      usuario.setFechaDeNacimiento(new Date());
      usuario.setNotas(new Integer[200]);
      usuario.setAudios(new Integer[20]);
      usuario.setCategorias(new Integer[20]);
      usuario.setFavoritos(new Integer[20]);
      usuario.setImagenes(new Integer[20]);
      repoUsuarios.save(usuario);
    };
  }
  @Bean
  CommandLineRunner initDatabaseNotas(NotaRepository repoNotas) {
    return args -> {
      Nota nota = new Nota();
      nota.setNombre("Test");
      nota.setContenido("Testeo de nota");
      repoNotas.save(nota);

      Nota nota2 = new Nota();
      nota2.setNombre("Test2");
      nota2.setContenido("Testeo de nota 2");
      repoNotas.save(nota2);
    };
  }
}