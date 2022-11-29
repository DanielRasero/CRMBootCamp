package com.CRM.weekAssessment.controllers;

import com.CRM.weekAssessment.entities.Opportunity;
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
    public List<Opportunity> getOpportunities() {

        return services.getOpportunities();
    }

    @GetMapping("/{id}")
    public Opportunity getOpportunityById(@PathVariable("id") Long id) {

        return services.getOpportunityById(id);
    }

    @PostMapping("registerOpportunity")
    public void registerOpportunity(@RequestBody Opportunity opportunity) {

        services.addOpportunity(opportunity);
    }

    @PutMapping("/updateOpportunity")
    public void updateOpportunity(@RequestBody Opportunity opportunity) {

        services.updateOpportunity(opportunity);
    }

    @DeleteMapping("/deleteOpportunity/{id}")
    public void deleteOpportunity(@PathVariable("id") Long id) {
        services.deleteOpportunity(services.getOpportunityById(id));
    }


}
