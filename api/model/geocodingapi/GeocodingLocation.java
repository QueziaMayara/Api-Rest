package com.example.stoom.api.model.geocodingapi;

import com.example.stoom.api.model.geocodingapi.GeocodingEnum;

public class GeocodingLocation {

    String latitude;
    String longitude;
    private String status;
    private boolean codeSucess;

    public GeocodingLocation() {
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

    public boolean isCodeSucess() {
        return codeSucess;
    }

    public void setCodeSucess(boolean codeSucess) {
        this.codeSucess = codeSucess;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCodeSucess() {
        if(status.equalsIgnoreCase(GeocodingEnum.OK.name())) {
            codeSucess = true;
        }
        return codeSucess;
    }
}
