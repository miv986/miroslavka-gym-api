package com.miroslavka.gym.controller;


import com.miroslavka.gym.entity.Ejercicio;
import com.miroslavka.gym.entity.EjercicioData;
import com.miroslavka.gym.entity.GrupoMuscular;
import com.miroslavka.gym.repository.EjercicioDataRepository;
import com.miroslavka.gym.service.EjercicioDataService;
import com.miroslavka.gym.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ejercicio_data")
public class EjercicioDataController {

    @Autowired
    private EjercicioDataRepository ejercicioDataRepository;

    @Autowired
    private EjercicioDataService ejercicioDataService;


    //CREAR EJERCICIODATA
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EjercicioData crearEjercicioData(@RequestBody EjercicioData ejercicioData) {
        return ejercicioDataRepository.save(ejercicioData);
    }


    //RECUPERAR TODOS LOS EJERCICIODATA

    @GetMapping()
    public List<EjercicioData> obtenerEjerciciosData() {
        List<EjercicioData> ejerciciosData = ejercicioDataRepository.findAll();
        if (!ejerciciosData.isEmpty()) {
            return ejerciciosData;
        }
        return null;
    }


    //RECUPERAR EJERCICO X ID
    @GetMapping("/{id}")
    public EjercicioData obtenerEjercicoDataPorId(@PathVariable int id) {
        var ejercicioData = ejercicioDataRepository.findById(id);
        if (ejercicioData.isPresent()) {
            return ejercicioData.get();
        }
        return null;
    }


    //RECUPERAR EJERCICIO X NOMBRE
    @GetMapping("/nombre/{nombre}")
    public Optional<EjercicioData> obtenerEjercicioDataPorNombre(@PathVariable String nombre) {
        var ejercicioData = ejercicioDataRepository.findByNombre(nombre);
        if (ejercicioData.isPresent()) {
            return ejercicioData;
        }
        return null;
    }

    //Filtrar x grupo muscular
    @GetMapping("/grupoMuscular/{grupoMuscular}")
    public ResponseEntity<List<EjercicioData>> obtenerEjerciciosXGrupoMuscular(@PathVariable GrupoMuscular grupoMuscular) {
        List<EjercicioData> listaEjercicioData = ejercicioDataService.obtenerEjerciciosXGrupoMuscular(grupoMuscular);

        if (listaEjercicioData.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay ejercicios");
        }

        return ResponseEntity.ok(listaEjercicioData);
    }


    @DeleteMapping("/{id}")
    public void borrarEjercicioDataPorId(@PathVariable int id) {
        var ejercicioData = ejercicioDataRepository.findById(id);
        if (ejercicioData.isPresent()) {
            ejercicioDataRepository.deleteById(id);
        }
    }


}
