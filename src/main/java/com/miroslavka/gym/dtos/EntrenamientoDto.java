package com.miroslavka.gym.dtos;


import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntrenamientoDto {
    private int id;
    private LocalDate createdAt;
    @NotNull(message = "Entrenamiento debe tener un nombre")
    private String entrenamiento;
    private String observaciones;
    private List<EjercicioDto> ejerciciosRealizados = new ArrayList<>();
    @NotNull(message = "id de Usuario es requerido")
    private int usuarioId;


    public EntrenamientoDto() {
    }

    public EntrenamientoDto(LocalDate createdAt, String entrenamiento, String observaciones, int usuarioId) {
        this.createdAt = createdAt;
        this.entrenamiento = entrenamiento;
        this.observaciones = observaciones;
        this.usuarioId = usuarioId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEntrenamiento() {
        return entrenamiento;
    }

    public void setEntrenamiento(String entrenamiento) {
        this.entrenamiento = entrenamiento;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<EjercicioDto> getEjerciciosRealizados() {
        return ejerciciosRealizados;
    }

    public void setEjerciciosRealizados(List<EjercicioDto> ejerciciosRealizados) {
        this.ejerciciosRealizados = ejerciciosRealizados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
