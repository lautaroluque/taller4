package com.taller4.app.controladores;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.taller4.app.FileStorageService;
import com.taller4.app.dominio.Audio;
import com.taller4.app.dominio.Imagen;
import com.taller4.app.dominio.UploadResponse;
import com.taller4.app.repositorios.AudioRepository;
import com.taller4.app.repositorios.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
public class FilesController {
    @Autowired
    private FileStorageService fileStorageService;

    private final ImagenRepository imagenRepository;
    private final AudioRepository audioRepository;

    public FilesController(ImagenRepository repoImagenes, AudioRepository repoAudios) {
        this.audioRepository = repoAudios;
        this.imagenRepository = repoImagenes;
    }

    @PostMapping("/subir/{username}")
    public UploadResponse subir(@PathVariable String username, @RequestParam("file") MultipartFile imagen,
            HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        if (currentPrincipalName.equals(username)) {
            String fileName = fileStorageService.storeFile(imagen);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/descargar/")
                    .path(username).path("/").path(fileName).toUriString();
            String mimeType = request.getServletContext().getMimeType(fileName);
            if (mimeType.startsWith("image/")) {
                Imagen nuevaImagen = new Imagen();
                nuevaImagen.setDueño(username);
                nuevaImagen.setUbicacion(fileName);
                imagenRepository.save(nuevaImagen);
            } else if (mimeType.startsWith("audio/")) {
                Audio nuevoAudio = new Audio();
                nuevoAudio.setDueño(username);
                nuevoAudio.setUbicacion(fileName);
                audioRepository.save(nuevoAudio);
            } else {
                return null;
            }
            return new UploadResponse(fileName, fileDownloadUri, imagen.getContentType(), imagen.getSize());
        } else {
            return null;
        }

    }

    @PostMapping("/subirmulti/{username}")
    public List<UploadResponse> subirMulti(@PathVariable String username,
            @RequestParam("files") MultipartFile[] imagenes, HttpServletRequest request) {
        return Arrays.asList(imagenes).stream().map(file -> subir(username, file, request))
                .collect(Collectors.toList());
    }

    @GetMapping("/descargar/{username}/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String username, @PathVariable String fileName,
            HttpServletRequest request) {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}