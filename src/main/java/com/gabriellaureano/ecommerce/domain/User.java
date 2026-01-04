package com.gabriellaureano.ecommerce.domain;

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
    private List<Order> orders;
}
