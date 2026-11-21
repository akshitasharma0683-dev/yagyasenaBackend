package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Journal{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long journalID;
    @ManyToOne 
    @JoinColumn (name = "userID")
    private User userID;
    private String title;
    private String category;
    private String feeling;
    private String thought;

    public Journal() {

    }

    public Journal(User userID, String title, String category, String feeling, String thought){
        this.userID= userID;
        this.title = title;
        this.category=category;
        this.feeling= feeling;
        this.thought= thought;
            }
    
    public Long getJournalID(){
        return journalID;
    }

    public void setJournalID(Long journalID){
        this.journalID= journalID;
    }

    public User getUserID(){
        return userID;
    }

    public void setUserID(User userID){
        this.userID=userID;
    }

    public String getTitle(){
        return title;

    }

    public void setTitle(String title){
        this.title= title;
    }

    public String getCategory(){
        return category;

    }

    public void setCategory(String category){
        this.category=category;
    }

    public String getFeeling(){
        return feeling;    }

    public void setFeeling(String feeling)
    {
        this.feeling= feeling;
    }

    public String getThought(){
        return thought;
    }

    public void setThought(String thought){
        this.thought=thought;
    }
}