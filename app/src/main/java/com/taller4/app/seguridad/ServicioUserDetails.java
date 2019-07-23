package com.taller4.app.seguridad;

import java.util.ArrayList;

import com.taller4.app.dominio.Usuario;
import com.taller4.app.excepciones.ItemNotFoundException;
import com.taller4.app.repositorios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServicioUserDetails implements UserDetailsService {
 
    @Autowired
    private UsuarioRepository repoUsuarios;
 
    @Autowired
    private PasswordEncoder bcryptEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws ItemNotFoundException {
        Usuario usuario = repoUsuarios.findByUsername(username);
        if (usuario != null)
        {
			return new User(usuario.getUsername(), bcryptEncoder.encode(usuario.getPassword()), new ArrayList<>());
        } 
        else 
        {
			throw new ItemNotFoundException(username);
		}
    }

    public Usuario save(Usuario usuario) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(usuario.getUsername());
        nuevoUsuario.setPassword(bcryptEncoder.encode(usuario.getPassword()));
        return repoUsuarios.save(nuevoUsuario);
    }
}