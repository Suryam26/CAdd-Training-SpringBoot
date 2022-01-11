package com.consultadd.service;

import com.consultadd.model.User;
import com.consultadd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public String registerUser(User user){
        if(userRepository.existsByUsername(user.getUsername())){
            return "Username already exists.";
        } else {
            userRepository.save(user);
            return "User registered successfully.";
        }
    }
}
