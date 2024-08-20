package com.miroslavka.gym.service;

import com.miroslavka.gym.entity.Ejercicio;
import com.miroslavka.gym.entity.EjercicioData;
import com.miroslavka.gym.entity.GrupoMuscular;
import com.miroslavka.gym.repository.EjercicioDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EjercicioDataService {


    @Autowired
    private EjercicioDataRepository ejercicioDataRepository;


    //Filtrar x grupo muscular
    public List<EjercicioData> obtenerEjerciciosXGrupoMuscular(GrupoMuscular grupoMuscular) {

        if (ejercicioDataRepository.findByGrupoMuscular(grupoMuscular).isEmpty()) {
            throw new IllegalArgumentException("El grupo muscular no existe");
        }
        List<EjercicioData> ejerciciosGrupoMuscular = ejercicioDataRepository.findByGrupoMuscular(grupoMuscular);
        if (ejerciciosGrupoMuscular.isEmpty()) {
            throw new IllegalArgumentException("No hay ejercicios en el grupo muscular");
        }


        return ejerciciosGrupoMuscular;
    }

}
