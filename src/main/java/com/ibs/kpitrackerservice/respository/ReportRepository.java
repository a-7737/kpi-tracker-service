package com.ibs.kpitrackerservice.respository;

import com.ibs.kpitrackerservice.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDate;
import java.util.List;

public interface ReportRepository extends MongoRepository<Report, String> {

    List<Report> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate startDate, LocalDate endDate);
}
