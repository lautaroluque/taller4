package com.taller4.api.controladores;

import java.util.List;
import com.taller4.api.dominio.Audio;
import com.taller4.api.repositorios.AudioRepository;
import com.taller4.api.excepciones.ItemNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AudioController {
    private final AudioRepository repo;

    public AudioController(AudioRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/audios")
    List<Audio> todas() {
        return repo.findAll();
    }

    @PostMapping("/audios")
    Audio nueva(@RequestBody Audio nuevoAudio) {
        return repo.save(nuevoAudio);
    }

    @GetMapping("/audios/{id}")
    Audio una(@PathVariable Integer id) {
        return repo.findById(id)
        .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/audios/{id}")
    Audio reemplazar(@RequestBody Audio nuevoAudio, @PathVariable Integer id) {
        return repo.findById(id)
        .map(audio -> {
            audio.setUbicacion(nuevoAudio.getUbicacion());
            return repo.save(audio);
        })
        .orElseGet(() -> {
            nuevoAudio.setId(id);
            return repo.save(nuevoAudio);
        });
    }

    @DeleteMapping("/audios/{id}")
    void eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}