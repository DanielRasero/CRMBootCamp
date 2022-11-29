package com.CRM.weekAssessment.controllers;

import com.CRM.weekAssessment.entities.Contact;
import com.CRM.weekAssessment.services.ContactServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactServices service = new ContactServices();

    @GetMapping("/")
    public List<Contact> getContacts() {

        return service.getContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable("id") Long id) {

        return service.getContactById(id);
    }

    @PostMapping("/registerContact")
    public void registerContact(@RequestBody Contact contact) {

        service.addContact(contact);
    }

    @PutMapping("/updateContact")
    public void updateContact(@RequestBody Contact contact) {

        service.updateContact(contact);
    }

    @DeleteMapping("/deleteContact/{contactId}")
    public void deleteContact(@PathVariable("id") Long id) {

        service.deleteContact(service.getContactById(id));
    }


}
