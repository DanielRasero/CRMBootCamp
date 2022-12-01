package com.CRM.weekAssessment.services;

import com.CRM.weekAssessment.converters.ContactConverter;
import com.CRM.weekAssessment.converters.UserConverter;
import com.CRM.weekAssessment.dtos.ContactDTO;
import com.CRM.weekAssessment.dtos.UserDTO;
import com.CRM.weekAssessment.entities.User;
import com.CRM.weekAssessment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final UserRepository repository;

    @Autowired
    public UserServices(UserRepository repository) {
        this.repository = repository;
    }


    public List<UserDTO> getUsers() {

        List<User> users = repository.findAll();

        return new ArrayList<>(UserConverter.EntitiesToDTOs(users));
    }

    public UserDTO getUserById(long id) {

        Optional<User> optional = repository.findById(id);

        return optional.map(UserConverter::ToDTO).orElse(null);
    }

    public void addUser(UserDTO user) {

        repository.save(UserConverter.ToEntity(user));
    }

    public void updateUser(UserDTO user) {

        repository.save(UserConverter.ToEntity(user));
    }

    public void deleteUser(UserDTO user) {

        repository.delete(UserConverter.ToEntity(user));
    }

    public Boolean getUserByEmail(String email) {

        boolean result= false;

        User user = repository.findUserByEmail(email);

        if (user != null)
          return true;

        return result ;
    }

    public List<ContactDTO> findContactsById(Long id) {

        Optional<User> optional = repository.findById(id);

        return optional.map(user -> ContactConverter.EntitiesToDTOs(user.getContacts())).orElseGet(ArrayList::new);
    }

    public boolean loginUser(String email, String password) {

        List<User> users = new ArrayList<>(repository.findAll());
        boolean result = false;

        if (users.stream().anyMatch(user -> user.getEmail().equals(email))) {

            if (users.stream().anyMatch(user -> user.getPassword().equals(password))) {
                result = true;
            }
        }
        ;


        return result;
    }

}
