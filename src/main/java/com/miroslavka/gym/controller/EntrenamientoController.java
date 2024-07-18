package com.miroslavka.gym.controller;


import com.miroslavka.gym.entity.Entrenamiento;
import com.miroslavka.gym.repository.EntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrenamientos")
public class EntrenamientoController {
    private EntrenamientoRepository entrenamientoRepository;

    @Autowired
    public EntrenamientoController(EntrenamientoRepository entrenamientoRepository) {
        this.entrenamientoRepository = entrenamientoRepository;

    }

    //CREAR ENTRENAMIENTO
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Entrenamiento crearEntrenamiento(@RequestBody Entrenamiento entrenamiento) {
        return entrenamientoRepository.save(entrenamiento);
    }

    //RECUPERAR TODOS LOS ENTRENAMIENTOS
    @GetMapping()
    public List<Entrenamiento> obtenerEntrenamientos() {
        List<Entrenamiento> entrenamientos = entrenamientoRepository.findAll();
        if (!entrenamientos.isEmpty()) {
            return entrenamientos;
        }
        return null;
    }


    //RECUPERAR ENTRENAMIENTO CONCRETO X ID

    @GetMapping("/{id}")
    public Entrenamiento obtenerEntrenamientoPorId(@PathVariable int id) {
        var entrenamiento = entrenamientoRepository.findById(id);
        if (entrenamiento.isPresent()) {
            return entrenamiento.get();
        }
        return null;
    }


    //RECUPERAR ENTRENAMIENTO X NOMBRE
    @GetMapping("/nombre/{nombre}")
    public Optional<Entrenamiento> obtenerEntrenamientoPorNombre(@PathVariable String nombre) {
        var entrenamiento = entrenamientoRepository.findByEntrenamiento(nombre);
        if (entrenamiento.isPresent()) {
            return entrenamiento;
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public void borrarEntrenamientoPorId(@PathVariable int id) {
        var entrenamiento = entrenamientoRepository.findById(id);
        if (entrenamiento.isPresent()) {
            entrenamientoRepository.deleteById(id);
        }
    }

}
