package com.CRM.weekAssessment.controllers;

import com.CRM.weekAssessment.entities.User;
import com.CRM.weekAssessment.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices service = new UserServices();

    public UserController(UserServices service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {return service.getUserById(id);}

    @PostMapping("/registerUser")
    public void registerUser(@RequestBody User persona) {service.addUser(persona);}

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User persona) {service.updateUser(persona);}

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable long id){
        service.deleteUser(service.getUserById(id));
    }

    @PostMapping("/loginUser")
    public boolean loginUser(@RequestParam String email, @RequestParam String password) {
        return service.loginUser(email, password);
    }
}
