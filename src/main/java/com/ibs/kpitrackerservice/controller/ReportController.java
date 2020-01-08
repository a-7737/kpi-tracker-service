package com.ibs.kpitrackerservice.controller;

import com.ibs.kpitrackerservice.model.Report;
import com.ibs.kpitrackerservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;;


@RestController
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping(path = "/updateKpiParameters")
    public ResponseEntity<String> updateReportParameters(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.updateReportParameters(report));
    }

    @PostMapping(path = "/report")
    public ResponseEntity<String> getReport(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.getReport(report));
    }
}
