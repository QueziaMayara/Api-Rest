package com.example.stoom.api.model;

import ch.qos.logback.core.net.SyslogOutputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Climate {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;


    @Column(name = "temperature")
    private Integer temperature;

    @Column(name = "season")
    private String season;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature() {
        this.temperature = temperature;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
        this.setTemperature();
    }

}