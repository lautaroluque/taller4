package com.taller4.app.controladores;

import java.util.List;
import com.taller4.app.dominio.Categoria;
import com.taller4.app.repositorios.CategoriaRepository;
import com.taller4.app.excepciones.ItemNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
    private final CategoriaRepository repo;

    public CategoriaController(CategoriaRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/categorias")
    List<Categoria> todas() {
        return repo.findAll();
    }

    @PostMapping("/categorias")
    Categoria nueva(@RequestBody Categoria nuevaCategoria) {
        return repo.save(nuevaCategoria);
    }

    @GetMapping("/categorias/{id}")
    Categoria una(@PathVariable Integer id) {
        return repo.findById(id)
        .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/categorias/{id}")
    Categoria reemplazar(@RequestBody Categoria nuevaCategoria, @PathVariable Integer id) {
        return repo.findById(id)
        .map(categoria -> {
            categoria.setNombre(nuevaCategoria.getNombre());
            categoria.setNotas(nuevaCategoria.getNotas());
            return repo.save(categoria);
        })
        .orElseGet(() -> {
            nuevaCategoria.setId(id);
            return repo.save(nuevaCategoria);
        });
    }

    @DeleteMapping("/categorias/{id}")
    void eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}