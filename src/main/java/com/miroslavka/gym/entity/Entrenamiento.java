package com.miroslavka.gym.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "entrenamientos")
public class Entrenamiento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate fecha;

//    @OneToMany(mappedBy = "entrenamiento", cascade = CascadeType.ALL, orphanRemoval = true)
//    private ArrayList<Ejercicio> ejerciciosRealizados;

    @Column(nullable = false)
    private String observaciones;


//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Usuario usuario;


    public Entrenamiento(LocalDate fecha, ArrayList<Ejercicio> ejerciciosRealizados, String observaciones, Usuario usuario) {
        this.fecha = fecha;
//        this.ejerciciosRealizados = ejerciciosRealizados;
        this.observaciones = observaciones;
//        this.usuario = usuario;
    }

//GETTERS AND SETTERS

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

//    public ArrayList<Ejercicio> getEjerciciosRealizados() {
//        return ejerciciosRealizados;
//    }
//
//    public void setEjerciciosRealizados(ArrayList<Ejercicio> ejerciciosRealizados) {
//        this.ejerciciosRealizados = ejerciciosRealizados;
//    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
