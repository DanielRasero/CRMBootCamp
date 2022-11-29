package com.CRM.weekAssessment.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;


    @ManyToOne
    @JoinColumn(name = "opportunity_id")
    private Opportunity opportunity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private Date date;
    @Column
    private String description;

    public Contact() {
    }

    @Autowired
    public Contact(long id, Opportunity opportunity, User userId, Date date, String description) {
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
        return opportunity.getId();
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    public Long getUser() {
        return user.getId();
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
