package com.forex.repository;

import com.forex.domain.PredictionData;
import com.forex.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PredictionRepository extends MongoRepository<PredictionData, String> {

    PredictionData findByCurrency(String currency);
}

