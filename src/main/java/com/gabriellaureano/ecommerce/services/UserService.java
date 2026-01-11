package com.gabriellaureano.ecommerce.services;

import com.gabriellaureano.ecommerce.domain.User;
import com.gabriellaureano.ecommerce.dto.UserCreateDTO;
import com.gabriellaureano.ecommerce.dto.UserResponseDTO;
import com.gabriellaureano.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User criarUser(UserCreateDTO userCreateDTO){
        User usuario = new User();

        usuario.setNome(userCreateDTO.getNome());
        usuario.setEmail(userCreateDTO.getEmail());
        usuario.setSenha(userCreateDTO.getSenha());

        return userRepository.save(usuario);
    }

    public List<UserResponseDTO> listarUsers(){
        return userRepository.findAll()
                .stream()
                .map(usuario -> new UserResponseDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail()
                ))
                .toList();
    }
}
