package com.ibs.kpitrackerservice.respository;

import com.ibs.kpitrackerservice.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {
}
