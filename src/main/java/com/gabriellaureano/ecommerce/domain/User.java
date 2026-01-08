package com.gabriellaureano.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Order> orders;

    public User() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
