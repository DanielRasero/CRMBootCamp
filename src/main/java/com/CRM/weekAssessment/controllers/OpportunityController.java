package com.CRM.weekAssessment.controllers;

import com.CRM.weekAssessment.dtos.ContactDTO;
import com.CRM.weekAssessment.dtos.OpportunityDTO;
import com.CRM.weekAssessment.services.OpportunityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opportunities")
public class OpportunityController {

    @Autowired
    private OpportunityServices services = new OpportunityServices();

    @GetMapping("/")
    public List<OpportunityDTO> getOpportunities() {

        return services.getOpportunities();
    }

    @GetMapping("/{id}")
    public OpportunityDTO getOpportunityById(@PathVariable("id") Long id) {

        return services.getOpportunityById(id);
    }

    @GetMapping("/findContacts/{id}")
    public List<ContactDTO> findContacts(@PathVariable("id") Long id){

        return services.findContactsById(id);
    }

    @PostMapping("registerOpportunity")
    public void registerOpportunity(@RequestBody OpportunityDTO opportunity) {

        services.addOpportunity(opportunity);
    }

    @PutMapping("/updateOpportunity")
    public void updateOpportunity(@RequestBody OpportunityDTO opportunity) {

        services.updateOpportunity(opportunity);
    }

    @DeleteMapping("/deleteOpportunity/{id}")
    public void deleteOpportunity(@PathVariable("id") Long id) {
        services.deleteOpportunity(services.getOpportunityById(id));
    }


}
