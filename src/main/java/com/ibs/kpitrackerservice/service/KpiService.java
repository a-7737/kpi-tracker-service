package com.ibs.kpitrackerservice.service;

import com.ibs.kpitrackerservice.model.Kpi;
import com.ibs.kpitrackerservice.respository.KpiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KpiService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KpiService.class);

    @Autowired
    private KpiRepository kpiRepository;

    public Kpi getKpi(String id) {
        Optional<Kpi> existingKpi = kpiRepository.findById(id);
        if (existingKpi.isEmpty()) {
            LOGGER.info(Events.OPERATION_FAILED.toString());
            return null;
        } else {
            return existingKpi.get();
        }
    }

    public List<Kpi> getAllKpis() {
        return kpiRepository.findAll();
    }

    public Kpi addKpi(Kpi kpi) {
        return kpiRepository.insert(kpi);
    }

    public String updateKpi(String id, Kpi kpi) {
        Kpi existingKpi = getKpi(id);
        if(existingKpi != null){
            existingKpi.setKpi(kpi.getKpi());
            existingKpi.setKpiParams(kpi.getKpiParams());
            kpiRepository.save(existingKpi);
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
        return Events.getMessage(Events.OPERATION_FAILED);
    }

    public String deleteKpi(String id) {
        Kpi kpi = getKpi(id);

        if (kpi != null) {
            kpiRepository.delete(kpi);
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
        return Events.getMessage(Events.OPERATION_FAILED);
    }
}
