package com.example.stoom.api.controller;

import com.example.stoom.api.model.Bank;
import com.example.stoom.api.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {


    @Autowired
    BankService bankService;

    @GetMapping()
    public List<Bank> searchBank() {
        return bankService.searchBank();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable(value = "id") Long id) {
        return bankService.getBankById(id);
    }

    @PostMapping()
    public Bank saveBank(@RequestBody Bank bank) {
        return bankService.saveBank(bank);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable(value = "id") Long id, @RequestBody Bank bankDetails) {
        return bankService.updateBank(id, bankDetails);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteBank(@PathVariable(value = "id") Long id) {
        return bankService.deleteBank(id);
    }
}
