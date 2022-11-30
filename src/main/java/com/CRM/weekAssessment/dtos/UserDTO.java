package com.CRM.weekAssessment.dtos;

import com.CRM.weekAssessment.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    @Autowired
    private long id;
    @Autowired
    private String username;
    @Autowired
    private String email;
    @Autowired
    private String password;
    @Autowired
    private List<ContactDTO> contacts;

    public UserDTO() {
    }

    @Autowired
    public UserDTO(long id, String username, String email, String password, List<ContactDTO> contacts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.contacts = contacts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
