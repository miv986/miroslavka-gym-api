package com.miroslavka.gym.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "ejercicios")
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private ArrayList<Integer> series;
    @Column(nullable = true)
    private ArrayList<Integer> reps;
    @Column(nullable = true)
    private ArrayList<Integer> pesos;

//    @ManyToOne
//    @JoinColumn(name = "entrenamiento")
//    private Entrenamiento entrenamiento;

    private String ejercicioData;


    public Ejercicio(ArrayList<Integer> reps, ArrayList<Integer> pesos, ArrayList<Integer> series, String ejercicioData) {
        this.reps = reps;
        this.pesos = pesos;
        this.series = series;
        this.ejercicioData = ejercicioData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Entrenamiento getEntrenamiento() {
//        return entrenamiento;
//    }
//
//    public void setEntrenamiento(Entrenamiento entrenamiento) {
//        this.entrenamiento = entrenamiento;
//    }

    public ArrayList<Integer> getSeries() {
        return series;
    }

    public void setSeries(ArrayList<Integer> series) {
        this.series = series;
    }

    public ArrayList<Integer> getReps() {
        return reps;
    }

    public void setReps(ArrayList<Integer> reps) {
        this.reps = reps;
    }

    public ArrayList<Integer> getPesos() {
        return pesos;
    }

    public void setPesos(ArrayList<Integer> pesos) {
        this.pesos = pesos;
    }

    public String getEjercicioData() {
        return ejercicioData;
    }

    public void setEjercicioData(String ejercicioData) {
        this.ejercicioData = ejercicioData;
    }



}
