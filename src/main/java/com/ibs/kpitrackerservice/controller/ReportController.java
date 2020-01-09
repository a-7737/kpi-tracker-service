package com.ibs.kpitrackerservice.controller;

import com.ibs.kpitrackerservice.model.Report;
import com.ibs.kpitrackerservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping(path = "/addReportParameters")
    public ResponseEntity<String> addReportParameters(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.addReportParameters(report));
    }

    @PostMapping(path = "/report")
    public ResponseEntity<List<Report>> getReport(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.getReport(report));
    }
}
