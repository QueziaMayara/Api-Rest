package com.example.stoom.api.service;

import com.example.stoom.api.model.Contract;
import com.example.stoom.api.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ContractService {

    @Autowired
    private ContractRepository repository;

    GeocodingService service;

    private Contract replaceInfo (Long id, Contract contractInformation) {
        contractInformation.setId(id);
        return contractInformation;
    }

    public List<Contract> searchContract() {
        return (List<Contract>) repository.findAll();
    }

    public ResponseEntity<Contract> getContractById(Long id) {
        try {
            Contract c = repository.findById(id)
                    .orElseThrow();
            return ResponseEntity.ok(c);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public Contract saveContract (Contract contract) {
        return repository.save(contract);
    }

    private void deleteContract (Contract contract) {
        repository.delete(contract);
    }

    public ResponseEntity<Contract> updateContract (Long id, Contract contractDetails) {
        Contract contract = replaceInfo(id, contractDetails);
        return ResponseEntity.ok(saveContract(contract));
    }

    public ResponseEntity<?> deleteContract (Long id) {
        try{
            Contract c = repository.findById(id)
                    .orElseThrow();
            deleteContract(c);
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
