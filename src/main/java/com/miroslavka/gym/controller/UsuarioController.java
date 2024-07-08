package com.miroslavka.gym.controller;


import com.miroslavka.gym.entity.Usuario;
import com.miroslavka.gym.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    @Autowired
public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    //CREAR USUARIO
    @PostMapping("/usuarios")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //RECUPERAR TODOS LOS USUARIOS
    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios(){
      List<Usuario> usuarios = usuarioRepository.findAll();

        if (!usuarios.isEmpty()){
            return usuarios;
        }
        return null;
    }

    //RECUPERAR USUARIO CONCRETO X ID

    @GetMapping("/usuarios/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable int id){
        var usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            return usuario.get();
        }
        return null;
    }


    //RECUPERAR USUARIO X NOMBRE

    @GetMapping("/usuarios/{usuario}")
    public Optional<Usuario> obtenerUsuarioPorNombre(@PathVariable String nombre){
        var usuario = usuarioRepository.findByUsuario(nombre);
        if (usuario.isPresent()){
            return usuario;
        }

        return null;
    }

@DeleteMapping("usuarios/{id}")
    public void borrarUsuarioPorId(@PathVariable int id){
        var usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            usuarioRepository.deleteById(id);

        }
    }

    }
