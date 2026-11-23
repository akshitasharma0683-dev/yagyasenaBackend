package com.yagyasena.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity 
public class Journey {
    @Id 
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID journeyID;
    @ManyToOne 
    @JoinColumn (name = "user_id")
    private User user_id;
    private String destination;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    @Enumerated (EnumType.STRING)
    private JourneyStatus jstatus =JourneyStatus.ACTIVE;

    @OneToMany(mappedBy = "journey", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) 
    private List<Location> location = new ArrayList<>(); 
    @OneToMany(mappedBy = "jID", fetch = FetchType.LAZY) 

    private List<SOS> sos = new ArrayList<>();

   public  Journey(){

    }

    public Journey(User user_id, String destination, LocalDateTime starttime, LocalDateTime endtime){
        this.user_id= user_id;
        this.destination=destination;
        this.starttime=starttime;
        this.endtime=endtime;
    }

    public User getUser(){
        return user_id;
    }

    public void setUser(User user_id){
        this.user_id=user_id;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination){
        this.destination=destination;
    }

    public LocalDateTime getStartTime(){
        return starttime;
    }
    public void setStartTime(LocalDateTime starttime){
        this.starttime=starttime;
    }

    public LocalDateTime getEndTime(){
        return endtime;
    }
    public void setEndTime(LocalDateTime endtime){
        this.endtime=endtime;
    }
    public JourneyStatus getJstatus(){
        return jstatus;
    }
    public void setJstatus(JourneyStatus jstatus){
        this.jstatus=jstatus;
    }

}
