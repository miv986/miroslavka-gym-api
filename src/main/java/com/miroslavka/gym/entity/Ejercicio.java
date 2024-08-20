package com.miroslavka.gym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.miroslavka.gym.repository.EjercicioDataRepository;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ejercicios")
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private List<Integer> series;
    @Column(nullable = true)
    private List<Integer> reps;
    @Column(nullable = true)
    private List<Integer> pesos;

    @ManyToOne
    @JoinColumn(name = "entrenamiento_id")
    @JsonBackReference
    private Entrenamiento entrenamiento;

    @Column()
    private String ejercicio;


    @ManyToOne
    @JoinColumn(name = "ejercicio_data_id")
    @JsonBackReference
    private EjercicioData ejercicioData;


    public Ejercicio() {
    }

    public Ejercicio(List<Integer> reps, List<Integer> pesos, List<Integer> series, String ejercicio) {
        this.reps = reps;
        this.pesos = pesos;
        this.series = series;
        this.ejercicio = ejercicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getSeries() {
        return series;
    }

    public void setSeries(List<Integer> series) {
        this.series = series;
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

    public Entrenamiento getEntrenamiento() {
        return entrenamiento;
    }

    public void setEntrenamiento(Entrenamiento entrenamiento) {
        this.entrenamiento = entrenamiento;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public EjercicioData getEjercicioData() {
        return ejercicioData;
    }

    public void setEjercicioData(EjercicioData ejercicioData) {
        this.ejercicioData = ejercicioData;
    }

}
