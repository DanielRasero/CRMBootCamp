package com.CRM.weekAssessment.converters;

import com.CRM.weekAssessment.dtos.OpportunityDTO;
import com.CRM.weekAssessment.entities.Opportunity;

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

        opp.setId(dto.getId());
        opp.setCompany(dto.getCompany());
        opp.setName(dto.getName());
        opp.setClient(dto.isClient());
        opp.setLastName(dto.getLastName());

        return opp;
    }

}
