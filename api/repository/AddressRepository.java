package com.example.stoom.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stoom.api.model.Address;

@Repository
public interface AddressRepository extends CrudRepository <Address, Long> {

}
