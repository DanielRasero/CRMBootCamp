package com.CRM.weekAssessment.services;

import com.CRM.weekAssessment.converters.ContactConverter;
import com.CRM.weekAssessment.converters.OpportunityConverter;
import com.CRM.weekAssessment.dtos.ContactDTO;
import com.CRM.weekAssessment.dtos.OpportunityDTO;
import com.CRM.weekAssessment.entities.Opportunity;
import com.CRM.weekAssessment.repositories.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OpportunityServices {

    @Autowired
    private OpportunityRepository repository;


    public List<OpportunityDTO> getOpportunities() {

        return new ArrayList<>(OpportunityConverter.EntitiesToDTOs(repository.findAll()));
    }

    public OpportunityDTO getOpportunityById(long id) {

        return OpportunityConverter.toDTO(repository.findById(id).get());
    }

    public void addOpportunity(OpportunityDTO opportunity) {

        repository.save(OpportunityConverter.toEntity(opportunity));
    }

    public void updateOpportunity(OpportunityDTO opportunity) {

        repository.save(OpportunityConverter.toEntity(opportunity));
    }

    public void deleteOpportunity(OpportunityDTO opportunity) {

        repository.delete(OpportunityConverter.toEntity(opportunity));
    }

    public List<ContactDTO> findContactsById(Long id) {

        Optional<Opportunity> optional = repository.findById(id);

        return optional.map(opportunity -> ContactConverter.EntitiesToDTOs(opportunity.getContacts())).orElseGet(ArrayList::new);
    }
}
