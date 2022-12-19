package com.example.stoom.api.controller;

import com.example.stoom.api.model.Climate;
import com.example.stoom.api.service.ClimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/climate")
public class ClimateController {

    @Autowired
    ClimateService climateService;

    @GetMapping()
    public List<Climate> searchClimate() {
        return climateService.searchClimate();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Climate> getClimateById(@PathVariable(value = "id") Long id) {
        return climateService.getClimateById(id);
    }

    @PostMapping()
    public Climate saveClimate(@RequestBody Climate climate) {
        return climateService.saveClimate(climate);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Climate> updateClimate(@PathVariable(value = "id") Long id, @RequestBody Climate climateDetails) {
        return climateService.updateClimate(id, climateDetails);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable(value = "id") Long id) {
        return climateService.deleteClimate(id);
    }
}
