package com.miroslavka.gym.dtos;

import com.miroslavka.gym.entity.GrupoMuscular;

public class GrupoMuscularDto {
    private String nombre;
    private String descripcion;
    private String imagen;
    private GrupoMuscular grupoMuscular;

    public GrupoMuscularDto() {
    }

    public GrupoMuscularDto(String nombre, String descripcion, String imagen, GrupoMuscular grupoMuscular) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.grupoMuscular = grupoMuscular;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }
}
