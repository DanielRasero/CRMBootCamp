package com.CRM.weekAssessment.services;

import com.CRM.weekAssessment.entities.Contact;
import com.CRM.weekAssessment.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServices {
    @Autowired
    private ContactRepository repository;

    public List<Contact> getContacts() {

        return new ArrayList<>(repository.findAll());
    }

    public Contact getContactById(long id) {

        return repository.findById(id).get();
    }

    public void addContact(Contact contact) {

        repository.save(contact);
    }

    public void updateContact(Contact contact) {

        repository.save(contact);
    }

    public void deleteContact(Contact contact) {

        repository.delete(contact);
    }
}
