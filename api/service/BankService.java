package com.example.stoom.api.service;


import com.example.stoom.api.model.Bank;
import com.example.stoom.api.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;


    private Bank replaceInfo(Long id, Bank bankInformation) {
        bankInformation.setId(id);
        return bankInformation;
    }

    public List<Bank> searchBank() {
        return (List<Bank>) bankRepository.findAll();
    }

    public ResponseEntity<Bank> getBankById(Long id) {
        try {
            Bank b = bankRepository.findById(id)
                    .orElseThrow();
            return ResponseEntity.ok(b);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public ResponseEntity<Bank> updateBank(Long id, Bank bankDetails) {
        Bank bank = replaceInfo(id, bankDetails);
        return ResponseEntity.ok(saveBank(bank));
    }

    public ResponseEntity<?> deleteBank(Long id) {
        try{
            Bank b = bankRepository.findById(id)
                    .orElseThrow();
            deleteBank(b);
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    private void deleteBank(Bank b) {
        bankRepository.delete(b);
    }

}
