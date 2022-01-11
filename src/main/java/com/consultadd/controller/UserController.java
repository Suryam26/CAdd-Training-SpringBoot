package com.consultadd.controller;

import com.consultadd.model.User;
import com.consultadd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> userList = userService.getUsers();
        return userList;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        return userService.registerUser(user);
    }
}
