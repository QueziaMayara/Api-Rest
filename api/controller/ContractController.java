package com.example.stoom.api.controller;

import java.util.List;


import com.example.stoom.api.model.Contract;
import com.example.stoom.api.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/api/contract")
class ContractController {

        @Autowired
        ContractService contractService;

        @GetMapping()
        public List<Contract> searchContract() {
                return contractService.searchContract();
        }

        @GetMapping(path = "{id}")
        public ResponseEntity<Contract> getContractById(@PathVariable(value = "id") Long id) {
                return contractService.getContractById(id);
        }

        @PostMapping()
        public Contract saveContract (@RequestBody Contract contract) {
                return contractService.saveContract(contract);
        }

        @PutMapping(path = "{id}")
        public ResponseEntity<Contract> updateContract (@PathVariable(value = "id") Long id, @RequestBody Contract contractDetails) {
                return contractService.updateContract(id, contractDetails);
        }

        @DeleteMapping(path = "{id}")
        public ResponseEntity<?> deleteAContract(@PathVariable(value = "id") Long id) {
                return contractService.deleteContract(id);
        }

}
