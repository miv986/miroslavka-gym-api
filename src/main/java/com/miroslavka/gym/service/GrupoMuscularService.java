package com.miroslavka.gym.service;

import com.miroslavka.gym.dtos.GrupoMuscularDto;
import com.miroslavka.gym.entity.GrupoMuscular;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GrupoMuscularService {

    public List<GrupoMuscularDto> obtenerTodosLosGruposMusculares() {
        return
                Stream.of(GrupoMuscular.values())
                        .map(grupoMuscular -> new GrupoMuscularDto(
                                grupoMuscular.getNombre(),
                                grupoMuscular.getDescripcion(),
                                grupoMuscular.getImagen(),grupoMuscular))
                        .collect(Collectors.toList());
    }
}