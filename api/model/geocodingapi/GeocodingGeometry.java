package com.example.stoom.api.model.geocodingapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocodingGeometry {

    @JsonProperty("location")
    GeocodingLocation geocodeLocation;

    public GeocodingGeometry() {

    }

    public GeocodingLocation getGeocodeLocation() {
        return geocodeLocation;
    }

    public void setGeocodeLocation(GeocodingLocation geocodeLocation) {
        this.geocodeLocation = geocodeLocation;
    }
}
