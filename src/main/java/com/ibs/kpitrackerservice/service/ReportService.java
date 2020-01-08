package com.ibs.kpitrackerservice.service;

import com.ibs.kpitrackerservice.model.Report;
import com.ibs.kpitrackerservice.respository.KpiRepository;
import com.ibs.kpitrackerservice.respository.ReportRepository;
import com.ibs.kpitrackerservice.respository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    public String updateReportParameters(Report report) {
        try {
            reportRepository.save(report);
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
        catch (Exception ex) {
            return Events.getMessage(Events.OPERATION_FAILED);
        }
    }
    public String getReport(Report report) {
        try {
            System.out.println("Start Date : " +report.getStartDate());
            List<Report> reportList = reportRepository.findByStartDateAfterAndEndDateBefore(report.getStartDate(), report.getEndDate());
            //System.out.println("********** Printing List " +reportList+ " *******************");
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
        catch (Exception ex) {
            return Events.getMessage(Events.OPERATION_FAILED);
        }
    }

}
