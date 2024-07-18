package com.miroslavka.gym.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "entrenamientos")
public class Entrenamiento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String entrenamiento;

    @CreatedDate
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

    @OneToMany(mappedBy = "entrenamiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ejercicio> ejerciciosRealizados;

    @Column(nullable = false)
    private String observaciones;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Entrenamiento() {
    }

    public Entrenamiento(LocalDate createdAt, String observaciones, String entrenamiento, Usuario usuario) {
        this.createdAt = createdAt;
        this.ejerciciosRealizados = ejerciciosRealizados;
        this.observaciones = observaciones;
        this.entrenamiento = entrenamiento;
        this.usuario = usuario;
    }

//GETTERS AND SETTERS

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate fecha) {
        this.createdAt = createdAt;
    }

    public List<Ejercicio> getEjerciciosRealizados() {
        return ejerciciosRealizados;
    }

    public void setEjerciciosRealizados(List<Ejercicio> ejerciciosRealizados) {
        this.ejerciciosRealizados = ejerciciosRealizados;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
