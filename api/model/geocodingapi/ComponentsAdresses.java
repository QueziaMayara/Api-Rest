package com.example.stoom.api.model.geocodingapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ComponentsAdresses {

    @JsonProperty("long_name")
    String longName;

    @JsonProperty("short_name")
    String shortName;

    List<String> typesAddress;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<String> getTypesAddress() {
        return typesAddress;
    }

    public void setTypesAddress(List<String> typesAddress) {
        this.typesAddress = typesAddress;
    }
}
