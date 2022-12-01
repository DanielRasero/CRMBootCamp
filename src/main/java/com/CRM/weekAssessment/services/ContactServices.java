package com.CRM.weekAssessment.services;

import com.CRM.weekAssessment.converters.ContactConverter;
import com.CRM.weekAssessment.dtos.ContactDTO;
import com.CRM.weekAssessment.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServices {
    @Autowired
    private ContactRepository repository;

    public List<ContactDTO> getContacts() {

        return new ArrayList<>(ContactConverter.EntitiesToDTOs(repository.findAll()));
    }

    public ContactDTO getContactById(long id) {

        return ContactConverter.ToDTO(repository.findById(id).get());
    }

    public void addContact(ContactDTO contact) {

        repository.save(ContactConverter.ToEntity(contact));
    }

    public void updateContact(ContactDTO contact) {

        repository.save(ContactConverter.ToEntity(contact));
    }

    public void deleteContact(ContactDTO contact) {

        repository.delete(ContactConverter.ToEntity(contact));
    }
}
