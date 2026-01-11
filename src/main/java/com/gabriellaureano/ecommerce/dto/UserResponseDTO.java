package com.gabriellaureano.ecommerce.dto;

public class UserResponseDTO {
    private Long id;
    private String nome;
    private String email;

    public UserResponseDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public UserResponseDTO() {
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
