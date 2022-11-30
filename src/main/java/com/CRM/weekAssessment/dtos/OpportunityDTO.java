package com.CRM.weekAssessment.dtos;

import com.CRM.weekAssessment.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class OpportunityDTO {


    @Autowired
    private boolean client;

    @Autowired
    private long id;

    @Autowired
    private List<ContactDTO> contacts;

    @Autowired
    private String name;
    @Autowired
    private String lastName;

    @Autowired
    private String company;

    public OpportunityDTO() {
    }

    @Autowired
    public OpportunityDTO(boolean client, long id, List<ContactDTO> contacts, String name, String lastName, String company) {
        this.client = client;
        this.id = id;
        this.contacts = contacts;
        this.name = name;
        this.lastName = lastName;
        this.company = company;
    }

    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Oportunity{" +
                "client=" + client +
                ", id=" + id +
                ", contacts=" + contacts +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
