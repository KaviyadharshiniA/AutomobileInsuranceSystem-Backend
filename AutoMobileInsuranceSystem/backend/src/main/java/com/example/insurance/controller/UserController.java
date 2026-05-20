package com.example.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.insurance.entity.User;
import com.example.insurance.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    UserService service;


    @GetMapping
    public List<User> getAllUsers(){

        return service.getAllUsers();

    }


    @GetMapping("/{id}")
    public User getUserById(
            @PathVariable Long id){

        return service.getUserById(id);

    }


    @PutMapping("/{id}")
    public User updateUser(

            @PathVariable Long id,

            @RequestBody
            User user){

        return service.updateUser(
                id,
                user);

    }


    @DeleteMapping("/{id}")
    public String deleteUser(
            @PathVariable Long id){

        service.deleteUser(id);

        return "User Deleted";

    }

}