package com.example.stoom.api.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.stoom.api.model.Address;
import com.example.stoom.api.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    GeocodingService service;

    private Address replaceInfo(Long id, Address addressInformation) {
        addressInformation.setId(id);
        return addressInformation;
    }

    public List<Address> searchAddresses() {
        return (List<Address>) repository.findAll();
    }

    public ResponseEntity<Address> getAddressById(Long id) {
        try {
            Address address = repository.findById(id)
                    .orElseThrow();
            return ResponseEntity.ok(address);
        }catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public Address saveAddress(Address address) {
        return repository.save(address);
    }

    private void deleteAddress(Address address) {
        repository.delete(address);
    }

    public ResponseEntity<Address> updateAddress(Long id, Address addressDetails) {
        Address address = replaceInfo(id, addressDetails);
        return ResponseEntity.ok(saveAddress(address));
    }

    public ResponseEntity <?> deleteAddress(Long id) {
         try{
             Address address = repository.findById(id)
                     .orElseThrow();
             deleteAddress(address);
         }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok().build();
    }
}

