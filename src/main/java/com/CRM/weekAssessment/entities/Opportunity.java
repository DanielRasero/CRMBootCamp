package com.CRM.weekAssessment.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "opportunity")
public class Opportunity {

    @Column
    private boolean client = false;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "opportunity")
    private List<Contact> contacts;

    @Column
    private String name;
    @Column
    private String lastName;

    @Column
    private String company;

    public Opportunity() {
    }

    @Autowired
    public Opportunity(boolean client, long id, ArrayList<Contact> contacts, String name, String lastName, String company) {
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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
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
