package com.miroslavka.gym.controller;

import com.miroslavka.gym.dtos.GrupoMuscularDto;
import com.miroslavka.gym.entity.GrupoMuscular;
import com.miroslavka.gym.service.GrupoMuscularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grupos-musculares")
public class GrupoMuscularController {

    private final GrupoMuscularService grupoMuscularService;

    @Autowired
    public GrupoMuscularController(GrupoMuscularService grupoMuscularService) {
        this.grupoMuscularService = grupoMuscularService;
    }


    @GetMapping
    public List<GrupoMuscularDto> getGruposMusculares() {
        return Arrays.stream(GrupoMuscular.values())
                .map(grupo -> new GrupoMuscularDto(grupo.getNombre(), grupo.getDescripcion(), grupo.getImagen(),grupo))
                .collect(Collectors.toList());
    }
}
