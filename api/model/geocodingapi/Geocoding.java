package com.example.stoom.api.model.geocodingapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Geocoding {

    @JsonProperty("place_id")
    String placeId;

    @JsonProperty("formatted_address")
    String formatAddress;

    @JsonProperty("address_components")
    List<ComponentsAdresses> listComponents;

    GeocodingGeometry codingGeometry;

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getFormatAddress() {
        return formatAddress;
    }

    public void setFormatAddress(String formatAddress) {
        this.formatAddress = formatAddress;
    }

    public List<ComponentsAdresses> getListComponents() {
        return listComponents;
    }

    public void setListComponents(List<ComponentsAdresses> listComponents) {
        this.listComponents = listComponents;
    }

    public GeocodingGeometry getCodingGeometry() {
        return codingGeometry;
    }

    public void setCodingGeometry(GeocodingGeometry codingGeometry) {
        this.codingGeometry = codingGeometry;
    }
}
