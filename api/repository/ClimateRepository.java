package com.example.stoom.api.repository;

import com.example.stoom.api.model.Climate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimateRepository extends CrudRepository<Climate, Long> {
}
