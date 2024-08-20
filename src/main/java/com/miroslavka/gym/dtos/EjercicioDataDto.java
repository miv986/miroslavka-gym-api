package com.miroslavka.gym.dtos;

import com.miroslavka.gym.entity.GrupoMuscular;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.List;

public class EjercicioDataDto {
    @NotBlank(message = "Nombre de ejercicio requerido")
    private String nombre;
    @NotBlank(message = "Descripcion de ejercicio requerida")
    private String descripcion;
    @NotNull(message = "Grupo muscular requerido")
    private GrupoMuscular grupoMuscular;

    private List<String> imagen;
    private List<String> video;


    public EjercicioDataDto() {

    }

    public EjercicioDataDto(String nombre, List<String> video, GrupoMuscular grupoMuscular, String descripcion, List<String> imagen) {
        this.nombre = nombre;
        this.video = video;
        this.grupoMuscular = grupoMuscular;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {

        this.grupoMuscular = grupoMuscular;
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
}
