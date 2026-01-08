package com.gabriellaureano.ecommerce.controllers;

import com.gabriellaureano.ecommerce.domain.User;
import com.gabriellaureano.ecommerce.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User criar(@RequestBody User user){
        return userService.criarUser(user);
    }

    @GetMapping
    public List<User> listar() {
        return userService.listarUsers();
    }
}
