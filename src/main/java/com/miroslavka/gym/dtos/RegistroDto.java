package com.miroslavka.gym.dtos;

import jakarta.validation.constraints.NotBlank;

public class RegistroDto {
    @NotBlank(message = "Email requerido")
    private String email;
    @NotBlank(message = "Contrasenya requerida")
    private String contrasenya;
    @NotBlank(message = "Nombre de usuario requerido")
    private String usuario;

    public RegistroDto() {
    }

    public RegistroDto(String usuario, String contrasenya, String email) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.email = email;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
