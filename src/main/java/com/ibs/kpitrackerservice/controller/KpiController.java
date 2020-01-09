package com.ibs.kpitrackerservice.controller;

import com.ibs.kpitrackerservice.model.Kpi;
import com.ibs.kpitrackerservice.service.KpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/kpi")
public class KpiController {
    @Autowired
    private KpiService kpiService;

    @GetMapping(path = "/kpi/{id}")
    public ResponseEntity<Kpi> getKpi(@PathVariable("id") String id) {
        return ResponseEntity.ok(kpiService.getKpi(id));
    }

    @GetMapping(path = "/kpi")
    public ResponseEntity<List<Kpi>> getAllKpis() {
        return ResponseEntity.ok(kpiService.getAllKpis());

    }

    @PostMapping(path = "/kpi")
    public ResponseEntity<Kpi> addKpi(@RequestBody Kpi kpi) {
        return ResponseEntity.ok(kpiService.addKpi(kpi));

    }

    @PutMapping(path = "/kpi")
    public ResponseEntity<String> updateKpi(@RequestBody Kpi kpi) {
        return ResponseEntity.ok(kpiService.updateKpi(kpi));

    }

    @DeleteMapping(path = "/kpi/{id}")
    public ResponseEntity<String> deleteKpi(@PathVariable("id") String id) {
        return ResponseEntity.ok(kpiService.deleteKpi(id));
    }
}
