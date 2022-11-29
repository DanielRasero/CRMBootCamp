package com.CRM.weekAssessment.services;

import com.CRM.weekAssessment.entities.User;
import com.CRM.weekAssessment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices{

    @Autowired
    private UserRepository repository;


    public List<User> getUsers() {

        return new ArrayList<>(repository.findAll());
    }

    public User getUserById(long id) {

        return repository.findById(id).get();
    }

    public void addUser(User user) {

        repository.save(user);
    }

    public void updateUser(User user) {

        repository.save(user);
    }

    public void deleteUser(User user) {

        repository.delete(user);
    }

    public boolean loginUser(String email, String password) {

        List<User> users = new ArrayList<>(repository.findAll());
        boolean result = false;

        if(users.stream().anyMatch(user -> user.getEmail().equals(email))) {

            if(users.stream().anyMatch(user -> user.getPassword().equals(password))) {
                result = true;
            }
        };


        return result;
    }
}
