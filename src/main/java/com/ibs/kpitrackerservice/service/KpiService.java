package com.ibs.kpitrackerservice.service;

import com.ibs.kpitrackerservice.model.Kpi;
import com.ibs.kpitrackerservice.respository.KpiRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.ibs.kpitrackerservice.service.Events.Error;

import java.util.List;

@Service
public class KpiService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KpiService.class);

    @Autowired
    private KpiRepository kpiRepository;

    public Kpi getKpi(String id) {
        final var existingKpi = kpiRepository.findById(id);
        if (existingKpi.isEmpty()) {
            LOGGER.warn(Error.getMessage(Error.KPI_NOT_FOUND));
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Error.getMessage(Error.KPI_NOT_FOUND));
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

    public String updateKpi(Kpi updatedKpi) {
        final var existingKpi = getKpi(updatedKpi.getId());
        updatedKpi.setId(new ObjectId(existingKpi.getId()));
        kpiRepository.save(updatedKpi);
        return Events.getMessage(Events.OPERATION_SUCCESSFUL);
    }

    public String deleteKpi(String id) {
        kpiRepository.delete(getKpi(id));
        return Events.getMessage(Events.OPERATION_SUCCESSFUL);
    }
}
