package com.taller4.app;

import com.taller4.app.repositorios.NotaRepository;
import com.taller4.app.repositorios.UsuarioRepository;
import java.util.Date;

import com.taller4.app.dominio.Nota;
import com.taller4.app.dominio.Usuario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LlenarDB {

  @Bean
  CommandLineRunner initDatabaseUsuarios(UsuarioRepository repoUsuarios) {
    return args -> {
      Usuario usuario = new Usuario();
      usuario.setId(1);
      usuario.setUsername("admin");
      usuario.setPassword("1234");
      usuario.setNombre("Admin");
      usuario.setFechaDeNacimiento(new Date());
      usuario.setNotas(new Integer[] { 1, 2 });
      usuario.setAudios(new Integer[1]);
      usuario.setCategorias(new Integer[1]);
      usuario.setFavoritos(new Integer[1]);
      usuario.setImagenes(new Integer[1]);
      repoUsuarios.save(usuario);

      Usuario usuario2 = new Usuario();
      usuario2.setId(2);
      usuario2.setUsername("usuario");
      usuario2.setPassword("1234");
      usuario2.setNombre("Usuario");
      usuario2.setFechaDeNacimiento(new Date());
      usuario2.setNotas(new Integer[] { 3 });
      usuario2.setAudios(new Integer[1]);
      usuario2.setCategorias(new Integer[1]);
      usuario2.setFavoritos(new Integer[1]);
      usuario2.setImagenes(new Integer[1]);
      repoUsuarios.save(usuario2);
    };
  }
  @Bean
  CommandLineRunner initDatabaseNotas(NotaRepository repoNotas) {
    return args -> {
      Nota nota = new Nota();
      nota.setId(1);
      nota.setNombre("Test");
      nota.setContenido("Testeo de nota");
      nota.setDueño("admin");
      repoNotas.save(nota);

      Nota nota2 = new Nota();
      nota2.setId(2);
      nota2.setNombre("Test2");
      nota2.setContenido("Testeo de nota 2");
      nota2.setDueño("admin");
      repoNotas.save(nota2);

      Nota nota3 = new Nota();
      nota3.setId(2);
      nota3.setNombre("Test2");
      nota3.setContenido("Testeo de nota 3");
      nota3.setDueño("usuario");
      repoNotas.save(nota3);
    };
  }
}