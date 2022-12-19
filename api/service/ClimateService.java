package com.example.stoom.api.service;

import com.example.stoom.api.model.Climate;
import com.example.stoom.api.repository.ClimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClimateService {

    @Autowired
    ClimateRepository climateRepository;

    private Climate replaceInfo (Long id, Climate climateInformation) {
        climateInformation.setId(id);
        return climateInformation;
    }

    public List<Climate> searchClimate() {
        return (List<Climate>) climateRepository.findAll();
    }

    public Climate saveClimate (Climate climate) {
        climate.setSeason(getSeason(climate.getTemperature()));
        return climateRepository.save(climate);

    }

    private String getSeason(Integer temperature) {
        if (temperature <= 16) {
            return "Winter";
        } else if (temperature <= 19) {
            return "Spring";
        } else if (temperature <= 25) {
            return "Autumn";
        } else if (temperature <= 50) {
            return "Summer";
        } else {
            return null;
        }
    }

    public ResponseEntity<Climate> getClimateById(Long id) {
        try {
            Climate climate = climateRepository.findById(id)
                    .orElseThrow();
            return ResponseEntity.ok(climate);
        }catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private void deleteClimate (Climate climate) {
        climateRepository.delete(climate);
    }

    public ResponseEntity<Climate> updateClimate (Long id, Climate climateDetails) {
        Climate climate = replaceInfo(id, climateDetails);
        return ResponseEntity.ok(saveClimate(climate));
    }
    public ResponseEntity<?> deleteClimate (Long id) {
        try{
            Climate c = climateRepository.findById(id)
                    .orElseThrow();
            deleteClimate(c);
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
