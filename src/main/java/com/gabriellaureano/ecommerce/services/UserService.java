package com.gabriellaureano.ecommerce.services;

import com.gabriellaureano.ecommerce.domain.User;
import com.gabriellaureano.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User criarUser(User user){
        return userRepository.save(user);
    }

    public List<User> listarUsers(){
        return userRepository.findAll();
    }
}
