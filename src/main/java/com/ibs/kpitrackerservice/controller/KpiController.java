package com.ibs.kpitrackerservice.controller;

import com.ibs.kpitrackerservice.model.Kpi;
import com.ibs.kpitrackerservice.service.KpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/kpi")
public class KpiController {
    @Autowired
    private KpiService kpiService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Kpi> getKpi(@PathVariable("id") String id) {
        return ResponseEntity.ok(kpiService.getKpi(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Kpi>> getAllKpis() {
        return ResponseEntity.ok(kpiService.getAllKpis());

    }

    @PostMapping(path = "/add")
    public ResponseEntity<Kpi> addKpi(@RequestBody Kpi kpi) {
        return ResponseEntity.ok(kpiService.addKpi(kpi));

    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateKpi(@PathVariable("id") String id, @RequestBody Kpi kpi) {
        return ResponseEntity.ok(kpiService.updateKpi(id, kpi));

    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteKpi(@PathVariable("id") String id) {
        return ResponseEntity.ok(kpiService.deleteKpi(id));
    }
}
