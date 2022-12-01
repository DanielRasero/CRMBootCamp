package com.CRM.weekAssessment.services;

import com.CRM.weekAssessment.converters.ContactConverter;
import com.CRM.weekAssessment.converters.UserConverter;
import com.CRM.weekAssessment.dtos.ContactDTO;
import com.CRM.weekAssessment.dtos.UserDTO;
import com.CRM.weekAssessment.entities.Contact;
import com.CRM.weekAssessment.entities.User;
import com.CRM.weekAssessment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;


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

    public void updateUser(User user) {

        repository.save(user);
    }

    public void deleteUser(UserDTO user) {

        repository.delete(UserConverter.ToEntity(user));
    }

    public List<ContactDTO> findContactsById(Long id) {

       // List<Contact> contacts = repository.findContactsById(id);
        //return ContactConverter.EntitiesToDTOs(contacts);
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
