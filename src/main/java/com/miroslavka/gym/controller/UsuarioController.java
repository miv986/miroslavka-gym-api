package com.miroslavka.gym.controller;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.miroslavka.gym.entity.Usuario;
import com.miroslavka.gym.repository.UsuarioRepository;
import com.miroslavka.gym.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.MarshalledObject;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @PostMapping("/registro")
    public ResponseEntity<String> registro(@Valid @RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        String usuario = request.get("usuario");


        boolean estaRegistrado = usuarioService.registrarUsuario(email, password, usuario);
        if (estaRegistrado) {
            return ResponseEntity.ok("Usuario registrado existosamente");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya existe");
        }
    }


    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email y contraseña son obligatorios");
        }
        boolean logueado = usuarioService.loginUsuario(email, password);
        if (logueado) {
            Usuario usuario = usuarioService.getUserByEmail(email);
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }

    //CREAR USUARIO
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
//}
//    //RECUPERAR TODOS LOS USUARIOS
//    @GetMapping()
//    public List<Usuario> obtenerUsuarios() {
//        List<Usuario> usuarios = usuarioRepository.findAll();
//
//        if (!usuarios.isEmpty()) {
//            return usuarios;
//        }
//        return null;
//    }
//
//    //RECUPERAR USUARIO CONCRETO X ID
//
//    @GetMapping("/{id}")
//    public Usuario obtenerUsuarioPorId(@PathVariable int id) {
//        var usuario = usuarioRepository.findById(id);
//        if (usuario.isPresent()) {
//            return usuario.get();
//        }
//        return null;
//    }
//
//
//    //RECUPERAR USUARIO X NOMBRE
//
//    @GetMapping("/nombre/{nombre}")
//    public Optional<Usuario> obtenerUsuarioPorNombre(@PathVariable String nombre) {
//        var usuario = usuarioRepository.findByUsuario(nombre);
//        if (usuario.isPresent()) {
//            return usuario;
//        }
//
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public void borrarUsuarioPorId(@PathVariable int id) {
//        var usuario = usuarioRepository.findById(id);
//        if (usuario.isPresent()) {
//            usuarioRepository.deleteById(id);
//
//        }
//    }

}
