package com.taller4.api.controladores;

import java.util.List;
import com.taller4.api.dominio.Nota;
import com.taller4.api.repositorios.NotaRepository;
import com.taller4.api.excepciones.NotaNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotaController {
    private final NotaRepository repo;

    public NotaController(NotaRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/notas")
    List<Nota> todas() {
        return repo.findAll();
    }

    @PostMapping("/notas")
    Nota nueva(@RequestBody Nota nuevaNota) {
        return repo.save(nuevaNota);
    }

    @GetMapping("/notas/{id}")
    Nota una(@PathVariable Integer id) {
        return repo.findById(id)
        .orElseThrow(() -> new NotaNotFoundException(id));
    }

    @PutMapping("/notas/{id}")
    Nota reemplazar(@RequestBody Nota nuevaNota, @PathVariable Integer id) {
        return repo.findById(id)
        .map(nota -> {
            nota.setNombre(nuevaNota.getNombre());
            nota.setContenido(nuevaNota.getContenido());
            return repo.save(nota);
        })
        .orElseGet(() -> {
            nuevaNota.setId(id);
            return repo.save(nuevaNota);
        });
    }

    @DeleteMapping("/notas/{id}")
    void eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}