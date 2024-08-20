package com.miroslavka.gym.controller;


import com.miroslavka.gym.dtos.EjercicioDto;
import com.miroslavka.gym.entity.Ejercicio;
import com.miroslavka.gym.entity.EjercicioData;
import com.miroslavka.gym.entity.Entrenamiento;
import com.miroslavka.gym.entity.GrupoMuscular;
import com.miroslavka.gym.repository.EjercicioDataRepository;
import com.miroslavka.gym.repository.EjercicioRepository;
import com.miroslavka.gym.service.EjercicioService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ejercicios")
public class EjercicioController {
    @Autowired
    private EjercicioRepository ejercicioRepository;

    private EjercicioService ejercicioService;
    private List<EjercicioData> ejercicios;

    @Autowired
    private EjercicioDataRepository ejercicioDataRepository;

    @Autowired
    public EjercicioController(EjercicioService ejercicioService) {
        this.ejercicioService = ejercicioService;
    }

    //CREAR EJERCICIO
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Ejercicio crearEjercicio(@Valid @RequestBody EjercicioDto ejercicioDto) {
        // Obtener el EjercicioData correspondiente al ID proporcionado
        Optional<EjercicioData> ejercicioDataOptional = ejercicioDataRepository.findById(ejercicioDto.getEjercicioDataId());

        // Verificar que se hayan encontrado todos los EjercicioData
        if (!ejercicioDataOptional.isPresent()) {
            throw new IllegalArgumentException("EjercicioData no encontrado");
        }
        EjercicioData ejercicioData = ejercicioDataOptional.get();

        // Crear un nuevo Ejercicio
        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setSeries(ejercicioDto.getSets());
        ejercicio.setReps(ejercicioDto.getReps());
        ejercicio.setPesos(ejercicioDto.getPesos());
        ejercicio.setEjercicio(ejercicioDto.getNombreEjercicio());
        ejercicio.setEjercicioData(ejercicioData); // Establecer la lista de EjercicioData

        ejercicioDataRepository.save(ejercicioData);
        // Guardar el Ejercicio en el repositorio
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

    public EjercicioRepository getEjercicioRepository() {
        return ejercicioRepository;
    }

    public void setEjercicioRepository(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    public EjercicioService getEjercicioService() {
        return ejercicioService;
    }

    public void setEjercicioService(EjercicioService ejercicioService) {
        this.ejercicioService = ejercicioService;
    }
}
