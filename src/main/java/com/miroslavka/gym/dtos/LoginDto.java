package com.miroslavka.gym.dtos;

import jakarta.validation.constraints.NotBlank;

public class LoginDto {

    @NotBlank(message = "Email requerido")
    private String email;
    @NotBlank(message = "Contrasenya requerida")
    private String contrasenya;
    @NotBlank(message = "Nombre usuario requerido")
    private String nombre;

    // Constructor vacío
    public LoginDto() {
    }

    // Constructor con parámetros
    public LoginDto(String email, String contrasenya, String nombre) {
        this.email = email;
        this.contrasenya = contrasenya;
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
