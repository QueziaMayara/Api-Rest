package com.example.stoom.api.service;

import com.example.stoom.api.model.Address;
import com.example.stoom.api.model.geocodingapi.Geocoding;
import com.example.stoom.api.model.geocodingapi.GeocodingEnum;
import com.example.stoom.api.model.geocodingapi.GeocodingResult;
import com.example.stoom.api.repository.AddressRepository;
import com.example.stoom.api.model.geocodingapi.GeocodingLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

@Service
public class GeocodingService {

    @Autowired
    AddressRepository repository;

    private String key =  "AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";

    public GeocodingLocation getGeocoding (Address address) {
        GeocodingLocation geocoding = new GeocodingLocation();
        String stringAddress = addressGenerated(address);
        final  String uri = "https://maps.googleapis.com/maps/api/geocode/json?address=" + stringAddress + "&key=" + key;

        GeocodingResult geoResult = new RestTemplate().getForObject(uri, GeocodingResult.class);
        geocoding.setStatus(geoResult.getStatusOk());


        if(geoResult.getStatusOk().equalsIgnoreCase(GeocodingEnum.OK.name())) {
            Optional<Geocoding> listGeocoding = geoResult.getListGeocoding().stream().findFirst();
            GeocodingLocation location = listGeocoding.map(i -> i.getCodingGeometry()).map( i -> i.getGeocodeLocation()).orElse(null);

            if(geocoding != null) {
                geocoding.setLatitude(geocoding.getLatitude());
                geocoding.setLongitude(geocoding.getLongitude());
            }
        }
        return geocoding;
    }

    private String addressGenerated(Address address) {
        String encodeAddress;
        String stringAddress = String.format(address.getState(), address.getNumber(), address.getComplement(),
                address.getNeighbourhood(), address.getCity(), address.getState(), address.getCountry(), address.getZipcode());
        try {
            encodeAddress = URLEncoder.encode(stringAddress,"UTF-8");
        }catch (UnsupportedEncodingException e) {
            encodeAddress = null;
        }
        return encodeAddress;
    }

}
