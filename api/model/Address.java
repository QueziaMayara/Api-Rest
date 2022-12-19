package com.example.stoom.api.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Address implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 80)
    private String streetName;

    @Column(nullable = false, length = 10)
    private String number;

    @Column(length = 15)
    private String complement;

    @Column(nullable = false, length = 30)
    private String neighbourhood;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String state;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false, length = 30)
    private String zipcode;

    private String latitude;

    private String longitude;

    public Address(Address addressDetails) {
        this.streetName = addressDetails.getStreetName();
        this.number = addressDetails.getNumber();
        this.complement = addressDetails.getComplement();
        this.neighbourhood = addressDetails.getNeighbourhood();
        this.city = addressDetails.getCity();
        this.state = addressDetails.getState();
        this.country = addressDetails.getCountry();
        this.zipcode = addressDetails.getZipcode();
    }

    public Address() {

    }

    public Address(Long id, String streetName, String number, String complement, String neighbourhood, String city, String state, String country, String zipCode, String latitude, String longitude) {
        this.id = id;
        this.streetName = streetName;
        this.number = number;
        this.complement = complement;
        this.neighbourhood = neighbourhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}