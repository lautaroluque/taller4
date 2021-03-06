package com.taller4.app.controladores;

import java.util.List;
import com.taller4.app.dominio.Usuario;
import com.taller4.app.repositorios.UsuarioRepository;
import com.taller4.app.excepciones.ItemNotFoundException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UsuarioController {
    private final UsuarioRepository repo;

    public UsuarioController(UsuarioRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/usuarios")
    List<Usuario> todas() {
        return repo.findAll();
    }

    @PostMapping("/usuarios")
    Usuario nueva(@RequestBody Usuario nuevoUsuario) {
        return repo.save(nuevoUsuario);
    }

    @GetMapping("/usuarios/{id}")
    Usuario una(@PathVariable Integer id) {
        return repo.findById(id)
        .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/usuarios/{id}")
    Usuario reemplazar(@RequestBody Usuario nuevoUsuario, @PathVariable Integer id) {
        return repo.findById(id)
        .map(usuario -> {
            usuario.setNombre(nuevoUsuario.getNombre());
            usuario.setAudios(nuevoUsuario.getAudios());
            usuario.setCategorias(nuevoUsuario.getCategorias());
            usuario.setEmail(nuevoUsuario.getEmail());
            usuario.setFavoritos(nuevoUsuario.getFavoritos());
            usuario.setFechaDeNacimiento(nuevoUsuario.getFechaDeNacimiento());
            usuario.setImagenes(nuevoUsuario.getImagenes());
            usuario.setNotas(nuevoUsuario.getNotas());
            return repo.save(usuario);
        })
        .orElseGet(() -> {
            nuevoUsuario.setId(id);
            return repo.save(nuevoUsuario);
        });
    }

    @DeleteMapping("/usuarios/{id}")
    void eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}