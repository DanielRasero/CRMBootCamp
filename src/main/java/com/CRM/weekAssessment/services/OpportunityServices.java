package com.CRM.weekAssessment.services;

import com.CRM.weekAssessment.entities.Opportunity;
import com.CRM.weekAssessment.repositories.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpportunityServices {

    @Autowired
    private OpportunityRepository repository;


    public List<Opportunity> getOpportunities() {

        return new ArrayList<>(repository.findAll());
    }

    public Opportunity getOpportunityById(long id) {

        return repository.findById(id).get();
    }

    public void addOpportunity(Opportunity opportunity) {

        repository.save(opportunity);
    }

    public void updateOpportunity(Opportunity opportunity) {

        repository.save(opportunity);
    }

    public void deleteOpportunity(Opportunity opportunity) {

        repository.delete(opportunity);
    }


}
