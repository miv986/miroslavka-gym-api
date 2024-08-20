package com.miroslavka.gym.service;

import com.miroslavka.gym.dtos.GrupoMuscularDto;
import com.miroslavka.gym.entity.Ejercicio;
import com.miroslavka.gym.entity.EjercicioData;
import com.miroslavka.gym.entity.GrupoMuscular;
import com.miroslavka.gym.repository.EjercicioDataRepository;
import com.miroslavka.gym.repository.EjercicioRepository;
import com.miroslavka.gym.repository.EntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EjercicioService {

    @Autowired
    private EntrenamientoRepository entrenamientoRepository;
    @Autowired
    private EjercicioDataRepository ejercicioDataRepository;
    @Autowired
    private EjercicioRepository ejercicioRepository;




}



