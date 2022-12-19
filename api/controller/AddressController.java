package com.example.stoom.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stoom.api.service.AddressService;
import com.example.stoom.api.model.Address;


@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping()
    public List<Address> searchAddresses() {
        return addressService.searchAddresses();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable(value = "id") Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping()
    public Address saveAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") Long id, @RequestBody Address addressDetails) {
        return addressService.updateAddress(id, addressDetails);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable(value = "id") Long id) {
        return addressService.deleteAddress(id);
    }
}

