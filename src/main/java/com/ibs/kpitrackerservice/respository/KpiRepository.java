package com.ibs.kpitrackerservice.respository;

import com.ibs.kpitrackerservice.model.Kpi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KpiRepository extends MongoRepository<Kpi, String> {

    Optional<Kpi> findById(String id);

    List<Kpi> findAll();

    Kpi save(Kpi kpi);

    Kpi insert(Kpi kpi);

    void delete(Kpi kpi);
}

