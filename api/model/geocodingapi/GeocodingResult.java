package com.example.stoom.api.model.geocodingapi;

import java.util.List;

public class GeocodingResult {

    List<Geocoding> listGeocoding;
    String statusOk;

    public GeocodingResult() {

    }

    public List<Geocoding> getListGeocoding() {
        return listGeocoding;
    }

    public void setListGeocoding(List<Geocoding> listGeocoding) {
        this.listGeocoding = listGeocoding;
    }

    public String getStatusOk() {
        return statusOk;
    }

    public void setStatusOk(String statusOk) {
        this.statusOk = statusOk;
    }
}
