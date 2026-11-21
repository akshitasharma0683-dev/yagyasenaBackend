package com.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class SOS {
    @Id 
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID SosID;
    @ManyToOne 
    @JoinColumn (name="userid")
    private User userid;
    @ManyToOne 
    @JoinColumn (name="jID" )
    private Journey jID;
   
    private Double latitute;
    private Double longitute;
    private LocalDateTime triggeredAt;
    @Enumerated (EnumType.STRING)
    private SOSStatus Status = SOSStatus.TRIGGERED;



     public SOS() {
    }

     public SOS(User userid, Journey jID, Double latitute, Double longitute, LocalDateTime triggeredAt) {
        this.userid = userid;
        this.jID = jID;
        this.latitute = latitute;
        this.longitute = longitute;
        this.triggeredAt = triggeredAt;
     }

     public UUID getSosID() {
         return SosID;
     }

     public void setSosID(UUID sosID) {
         SosID = sosID;
     }

     public User getUserId() {
         return userid;
     }

     public void setUserId(User userId) {
         this.userid = userId;
     }

     public Journey getjID() {
         return jID;
     }

     public void setjID(Journey jID) {
         this.jID = jID;
     }

     public Double getLatitute() {
         return latitute;
     }

     public void setLatitute(Double latitute) {
         this.latitute = latitute;
     }

     public Double getLongitute() {
         return longitute;
     }

     public void setLongitute(Double longitute) {
         this.longitute = longitute;
     }

     public LocalDateTime getTriggeredAt() {
         return triggeredAt;
     }

     public void setTriggeredAt(LocalDateTime triggeredAt) {
         this.triggeredAt = triggeredAt;
     }

     public SOSStatus getStatus() {
         return Status;
     }

     public void setStatus(SOSStatus status) {
         Status = status;
     }

     
    
    
}
