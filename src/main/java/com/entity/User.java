package com.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_users")

public class User{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column (nullable = false)
    private String userName;
    @Column(unique=true, nullable = false)
    private String email;
    @Column (nullable = false)
    private String password;

    @OneToMany(mappedBy = "userID" , fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Contact> contacts = new ArrayList<> ();

    @OneToMany(mappedBy ="userID", fetch  = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Journal>  journals = new ArrayList<>();

    @OneToMany(mappedBy="user_id" , fetch = FetchType.LAZY,  cascade = CascadeType.REMOVE)
    private List<Journey> journeys = new ArrayList<>();
    @OneToMany(mappedBy="userid" , fetch = FetchType.LAZY,  cascade = CascadeType.REMOVE)

    private List<SOS> sos = new ArrayList<>();

    public User(){
        
    }

    public User(String userName, String email, String password ){
        this.userName = userName;
        this.email = email;
        this.password = password;

    }
     
    public Long getUserID(){
        return userID;
    }
    public void setUserID(Long userID){
        this.userID = userID;
    }

    public String getUserName(){
        return userName;

    }

    public void setUserName(String userName){
        this.userName= userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
            return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}