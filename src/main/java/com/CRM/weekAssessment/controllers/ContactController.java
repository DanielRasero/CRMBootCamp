package com.CRM.weekAssessment.controllers;

import com.CRM.weekAssessment.dtos.ContactDTO;
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
    public List<ContactDTO> getContacts() {

        return service.getContacts();
    }

    @GetMapping("/{id}")
    public ContactDTO getContactById(@PathVariable("id") Long id) {

        return service.getContactById(id);
    }

    @PostMapping("/registerContact")
    public void registerContact(@RequestBody ContactDTO contact) {

        service.addContact(contact);
    }

    @PutMapping("/updateContact")
    public void updateContact(@RequestBody ContactDTO contact) {

        service.updateContact(contact);
    }

    @DeleteMapping("/deleteContact/{contactId}")
    public void deleteContact(@PathVariable("id") Long id) {

        service.deleteContact(service.getContactById(id));
    }


}
