package com.ibs.kpitrackerservice.respository;

import com.ibs.kpitrackerservice.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface ReportRepository extends MongoRepository<Report, String> {

    @Query("select report from Report report where report.startDate >= :startDate and report.endDate <= :endDate")
    List<Report> findByStartDateAfterAndEndDateBefore(
            @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
