package com.CRM.weekAssessment.converters;

import com.CRM.weekAssessment.dtos.OpportunityDTO;
import com.CRM.weekAssessment.dtos.UserDTO;
import com.CRM.weekAssessment.entities.Opportunity;
import com.CRM.weekAssessment.entities.User;

import java.util.ArrayList;
import java.util.List;

public class OpportunityConverter {

    public static OpportunityDTO toDTO(Opportunity opportunity) {

        OpportunityDTO dto = new OpportunityDTO();

        dto.setId(opportunity.getId());
        dto.setCompany(opportunity.getCompany());
        dto.setName(opportunity.getName());
        dto.setLastName(opportunity.getLastName());
        dto.setClient(opportunity.isClient());
        dto.setContacts(ContactConverter.EntitiesToDTOs(opportunity.getContacts()));

        return dto;
    }

    public static Opportunity toEntity(OpportunityDTO dto) {

        Opportunity opp = new Opportunity();

        opp.setCompany(dto.getCompany());
        opp.setName(dto.getName());
        opp.setClient(dto.isClient());
        opp.setLastName(dto.getLastName());

        return opp;
    }

    public static List<OpportunityDTO> EntitiesToDTOs(List<Opportunity> opportunities) {

        List<OpportunityDTO> dtoList = new ArrayList<>();

        for (Opportunity opportunity : opportunities) {
            OpportunityDTO dto = toDTO(opportunity);
            dtoList.add(dto);
        }

        return dtoList;
    }

}
