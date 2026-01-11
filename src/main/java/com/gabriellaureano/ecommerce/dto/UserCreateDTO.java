package com.gabriellaureano.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateDTO {

    @NotBlank(message = "Nome invalido")
    private String nome;

    @Email
    @NotBlank(message = "Email invalido")
    private String email;

    @NotBlank
    @Size(min = 3,message = "Senha fraca, tente outra!")
    private String senha;

    public UserCreateDTO(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public UserCreateDTO() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
