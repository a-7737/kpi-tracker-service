package com.ibs.kpitrackerservice.service;

import com.ibs.kpitrackerservice.model.Report;
import com.ibs.kpitrackerservice.respository.ReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);

    public String addReportParameters(Report report) {
        try {
            reportRepository.insert(report);
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
        catch (Exception ex) {
            return Events.getMessage(Events.OPERATION_FAILED);
        }
    }
    public List<Report> getReport(Report report) {
        try {
            System.out.println("Start Date : " +report.getStartDate());
            List<Report> reportList = reportRepository.
                    findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(report.getStartDate(), report.getEndDate());
            return reportList;
        }
        catch (Exception ex) {
            LOGGER.info(Events.getMessage(Events.OPERATION_FAILED));
            return  null;
        }
    }

}
