package com.CRM.weekAssessment.converters;

import com.CRM.weekAssessment.dtos.UserDTO;
import com.CRM.weekAssessment.entities.User;

public class UserConverter {

    public static UserDTO ToDTO(User user) {

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setContacts(ContactConverter.EntitiesToDTOs(user.getContacts()));
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        return dto;
    }

    public static User ToEntity(UserDTO dto) {

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return user;
    }
}
