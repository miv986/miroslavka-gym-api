package com.miroslavka.gym.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.miroslavka.gym.entity.Usuario;
import com.miroslavka.gym.repository.UsuarioRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    public boolean registrarUsuario(String email, String password, String nombre) {

        if (usuarioRepository.findByEmail(email).isPresent()) {
            return false;
        }

        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        Usuario usuario = new Usuario(nombre, bcryptHashString, email);
        usuarioRepository.save(usuario);
        return true;
    }


    public boolean loginUsuario(String email, String password) {
        Optional<Usuario> usuarioOpcional = usuarioRepository.findByEmail(email);
        if (usuarioOpcional.isPresent()) {
            Usuario usuario = usuarioOpcional.get();

            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), usuario.getPassword());
            return result.verified;

        }
        return false;
    }


    public Usuario getUserByEmail(String email) {

        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email);

        if (optionalUsuario.isPresent()) {

            Usuario usuario = optionalUsuario.get();
            return usuario;
        }
        return null;
    }
}
