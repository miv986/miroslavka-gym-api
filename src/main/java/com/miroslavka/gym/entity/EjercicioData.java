package com.miroslavka.gym.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ejercicio_data")
public class EjercicioData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "grupoMuscular")
    private GrupoMuscular grupoMuscular;

    @Column(name = "imagen")
    private List<String> imagen;
    @Column(name = "video")
    private List<String> video;


    @OneToOne
    @JoinColumn(name = "ejercicio_id", referencedColumnName = "id")
    private Ejercicio ejercicio;

    public EjercicioData() {
    }

    public EjercicioData(int id, String nombre, List<String> imagen, String descripcion, List<String> video, Ejercicio ejercicio) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.video = video;
        this.ejercicio = ejercicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getImagen() {
        return imagen;
    }

    public void setImagen(List<String> imagen) {
        this.imagen = imagen;
    }

    public List<String> getVideo() {
        return video;
    }

    public void setVideo(List<String> video) {
        this.video = video;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
}
