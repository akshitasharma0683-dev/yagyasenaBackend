package com.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity 
public class Location {
    @Id 
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID LocationID;
    @ManyToOne 
    @JoinColumn (name= "journey")
    private Journey journey;
    private Double longitute;
    private Double latitude;
    private LocalDateTime recordedAT;

    

    public Location() {
    }
    public Location(Journey journey, Double longitute, Double latitude, LocalDateTime recordedAT) {
        this.journey = journey;
        this.longitute = longitute;
        this.latitude = latitude;
        this.recordedAT = recordedAT;
    }
    public UUID getLocationID() {
        return LocationID;
    }
    public void setLocationID(UUID locationID) {
        LocationID = locationID;
    }
    public Journey getJourney() {
        return journey;
    }
    public void setJourney(Journey journey) {
        this.journey = journey;
    }
    public Double getLongitute() {
        return longitute;
    }
    public void setLongitute(Double longitute) {
        this.longitute = longitute;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public LocalDateTime getRecordedAT() {
        return recordedAT;
    }
    public void setRecordedAT(LocalDateTime recordedAT) {
        this.recordedAT = recordedAT;
    }


}
