package com.taller4.api.controladores;

import java.util.List;
import com.taller4.api.dominio.Imagen;
import com.taller4.api.repositorios.ImagenRepository;
import com.taller4.api.excepciones.ItemNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImagenController {
    private final ImagenRepository repo;

    public ImagenController(ImagenRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/imagenes")
    List<Imagen> todas() {
        return repo.findAll();
    }

    @PostMapping("/imagenes")
    Imagen nueva(@RequestBody Imagen nuevaImagen) {
        return repo.save(nuevaImagen);
    }

    @GetMapping("/imagenes/{id}")
    Imagen una(@PathVariable Integer id) {
        return repo.findById(id)
        .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/imagenes/{id}")
    Imagen reemplazar(@RequestBody Imagen nuevaImagen, @PathVariable Integer id) {
        return repo.findById(id)
        .map(imagen -> {
            imagen.setUbicacion(nuevaImagen.getUbicacion());
            return repo.save(imagen);
        })
        .orElseGet(() -> {
            nuevaImagen.setId(id);
            return repo.save(nuevaImagen);
        });
    }

    @DeleteMapping("/imagenes/{id}")
    void eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}