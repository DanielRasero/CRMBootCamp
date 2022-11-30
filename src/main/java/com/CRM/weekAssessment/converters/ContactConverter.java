package com.CRM.weekAssessment.converters;

import com.CRM.weekAssessment.dtos.ContactDTO;
import com.CRM.weekAssessment.entities.Contact;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ContactConverter {

    public static ContactDTO ToDTO(Contact contact) {

        ContactDTO dto = new ContactDTO();

        dto.setDescription(contact.getDescription());
        dto.setId(contact.getId());
        dto.setDate(contact.getDate());

        if (contact.getOpportunity() != null) {
            dto.setOpportunity(contact.getOpportunity().getId());
        }

        if (contact.getUser() != null) {
            dto.setUser(contact.getUser().getId());
        }

        return dto;
    }

    public static Contact ToEntity(ContactDTO dto) {
        Contact contact = new Contact();

        contact.setDescription(contact.getDescription());
        contact.setDate(Date.valueOf(dto.getDate()).toLocalDate());

        return contact;
    }

    public static List<ContactDTO> EntitiesToDTOs(List<Contact> contacts) {

        List<ContactDTO> dtoList = new ArrayList<ContactDTO>();

        for (Contact contact : contacts) {
            ContactDTO dto = ToDTO(contact);
            dtoList.add(dto);
        }

        return dtoList;
    }

}
