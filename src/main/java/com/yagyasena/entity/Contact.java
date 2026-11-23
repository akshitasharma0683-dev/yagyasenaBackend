package com.yagyasena.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Contact{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long contactID;
    @ManyToOne 
    @JoinColumn (name="userID")
    private User userID;
    private String contactName;
    private String contactNumber;

    public Contact(){

    }

    public Contact(User userID, String contactName, String contactNumber){
        this.userID = userID;
        this.contactName= contactName;
        this.contactNumber= contactNumber;
    }

    public Long getContactID(){
        return contactID;
    }

    public void setContactID(Long contactID){
        this.contactID= contactID;
    }

    public String getContactName(){
        return contactName;
    }

    public void setContactName(String contactName){
        this.contactName= contactName;
    }

    public String getContactNumber()
    {
        return contactNumber;

    }

    public void setContactNumber(String contactNumber){
        this.contactNumber= contactNumber;
    }
}