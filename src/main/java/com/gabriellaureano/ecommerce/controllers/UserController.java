package com.gabriellaureano.ecommerce.controllers;

import com.gabriellaureano.ecommerce.domain.User;
import com.gabriellaureano.ecommerce.dto.UserCreateDTO;
import com.gabriellaureano.ecommerce.dto.UserResponseDTO;
import com.gabriellaureano.ecommerce.services.UserService;
import jakarta.validation.Valid;
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
    public User criar(@RequestBody @Valid UserCreateDTO userCreateDTO){
        return userService.criarUser(userCreateDTO);
    }

    @GetMapping
    public List<UserResponseDTO> listar() {
        return userService.listarUsers();
    }
}
