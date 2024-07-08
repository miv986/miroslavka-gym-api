package com.miroslavka.gym.entity;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {


//
//    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
//    private ArrayList<Entrenamiento> entrenamientos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false, name = "contrasenya")
    private String contrasenyaEncriptada;

    @Column(nullable = false, updatable = true)
    private String email;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Usuario(LocalDateTime createdAt, String email, String contrasenyaEncriptada, String usuario, int id) {
        this.createdAt = createdAt;
        this.email = email;
        this.contrasenyaEncriptada = contrasenyaEncriptada;
        this.usuario = usuario;
        this.id = id;
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenyaEncriptada() {
        return contrasenyaEncriptada;
    }

    public void setContrasenyaEncriptada(String contrasenyaEncriptada) {
        this.contrasenyaEncriptada = contrasenyaEncriptada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

//    public ArrayList<Entrenamiento> getEntrenamientos() {
//        return entrenamientos;
//    }
//
//    public void setEntrenamientos(ArrayList<Entrenamiento> entrenamientos) {
//        this.entrenamientos = entrenamientos;
//    }

}
