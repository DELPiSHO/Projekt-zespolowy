package com.forex.repository;

import com.forex.domain.Currency;
import com.forex.domain.RealData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RealDataRepository extends MongoRepository<RealData, String> {
    List<RealData> findByCurrency(String currency);

    List<RealData> findByCurrencyAndDateBetweenOrderByDateAsc(String currency, String dateBefore, String dateAfter);
}
