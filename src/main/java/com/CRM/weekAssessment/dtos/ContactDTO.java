package com.CRM.weekAssessment.dtos;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

public class ContactDTO {

    @Autowired
    private long id;

    @Autowired
    private Long opportunity;

    @Autowired
    private Long user;

    @Autowired
    private LocalDate date;
    @Autowired
    private String description;

    public ContactDTO() {
    }

    @Autowired
    public ContactDTO(long id, Long opportunity, Long userId, LocalDate date, String description) {
        this.id = id;
        this.opportunity = opportunity;
        this.user = userId;
        this.date = date;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Long opportunity) {
        this.opportunity = opportunity;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long userId) {
        this.user = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", oportunity=" + opportunity +
                ", userId=" + user +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
