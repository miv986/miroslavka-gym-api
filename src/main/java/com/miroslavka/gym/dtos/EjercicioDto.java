package com.miroslavka.gym.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class EjercicioDto {

    private int id;
    @NotNull(message = "Los sets son requeridos")
    private List<Integer> sets;
    @NotNull(message = "Repeticiones ejercicio requeridos")
    private List<Integer> reps;
    @NotNull(message = "Peso ejercicio requerido")
    private List<Integer> pesos;
    private int entrenamientoId;
    private String nombreEjercicio;

    @NotNull(message = "El ID de EjercicioData es requerido")
    private int ejercicioDataId;


    // Empty constructor
    public EjercicioDto() {
    }

    // Constructor with parameters
    public EjercicioDto(int id, List<Integer> sets, List<Integer> reps, List<Integer> pesos, String nombreEjercicio) {
        this.id = id;
        this.sets = sets;
        this.reps = reps;
        this.pesos = pesos;
        this.nombreEjercicio = nombreEjercicio;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getSets() {
        return sets;
    }

    public void setSets(List<Integer> sets) {
        this.sets = sets;
    }

    public List<Integer> getReps() {
        return reps;
    }

    public void setReps(List<Integer> reps) {
        this.reps = reps;
    }

    public List<Integer> getPesos() {
        return pesos;
    }

    public void setPesos(List<Integer> pesos) {
        this.pesos = pesos;
    }

    public int getEntrenamientoId() {
        return entrenamientoId;
    }

    public void setEntrenamientoId(int entrenamientoId) {
        this.entrenamientoId = entrenamientoId;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }


    public int getEjercicioDataId() {
        return ejercicioDataId;
    }

    public void setEjercicioDataId( int ejercicioDataId) {
        this.ejercicioDataId = ejercicioDataId;
    }
}
