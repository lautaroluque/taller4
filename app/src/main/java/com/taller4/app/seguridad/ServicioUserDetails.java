package com.taller4.app.seguridad;

import com.taller4.app.dominio.Usuario;
import com.taller4.app.excepciones.ItemNotFoundException;
import com.taller4.app.repositorios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class ServicioUserDetails implements UserDetailsService {
 
    @Autowired
    private UsuarioRepository repoUsuarios;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = repoUsuarios.findByUsername(username);
        if (usuario == null) {
            throw new ItemNotFoundException(username);
        }
        return new UserPrincipal(usuario);
    }
}