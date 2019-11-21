package com.ibs.kpitrackerservice.respository;

import com.ibs.kpitrackerservice.model.Kpi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiRepository extends MongoRepository<Kpi, String> {
}
