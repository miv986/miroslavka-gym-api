package com.miroslavka.gym.controller;


import com.miroslavka.gym.entity.Ejercicio;
import com.miroslavka.gym.entity.Entrenamiento;
import com.miroslavka.gym.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ejercicios")
public class EjercicioController {

    private EjercicioRepository ejercicioRepository;

    @Autowired
    public EjercicioController(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    //CREAR EJERCICO?
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Ejercicio crearEjercicio(@RequestBody Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    //RECUPERAR TODOS LOS EJERCICIOS
    @GetMapping()
    public List<Ejercicio> obtenerEjercicios() {
        List<Ejercicio> ejercicios = ejercicioRepository.findAll();
        if (!ejercicios.isEmpty()) {
            return ejercicios;
        }
        return null;
    }

    //RECUPERAR EJERCICO X ID
    @GetMapping("/{id}")
    public Ejercicio obtenerEntrenamientoPorId(@PathVariable int id) {
        var ejercicio = ejercicioRepository.findById(id);
        if (ejercicio.isPresent()) {
            return ejercicio.get();
        }
        return null;
    }

    //RECUPERAR EJERCICIO X NOMBRE
    @GetMapping("/nombre/{nombre}")
    public Optional<Ejercicio> obtenerEjercicioPorNombre(@PathVariable String nombre) {
        var ejercicio = ejercicioRepository.findByEjercicio(nombre);
        if (ejercicio.isPresent()) {
            return ejercicio;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void borrarEjercicoPorId(@PathVariable int id) {
        var ejercicio = ejercicioRepository.findById(id);
        if (ejercicio.isPresent()) {
            ejercicioRepository.deleteById(id);
        }
    }

}
