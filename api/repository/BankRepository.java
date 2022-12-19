package com.example.stoom.api.repository;


import com.example.stoom.api.model.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository <Bank, Long> {
}
