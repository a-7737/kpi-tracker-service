package com.ibs.kpitrackerservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;

@Document(collection = "report")
public class Report {
    @Id
    private ObjectId id;
    private String sprint;
    private LocalDate startDate;
    private LocalDate endDate;
    @DBRef
    private Team team ;
    @DBRef
    private Kpi kpi;
    Map<String, Integer> kpiValues;

    public String getSprint() {
        return sprint;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Kpi getKpi() {
        return kpi;
    }

    public void setKpi(Kpi kpi) {
        this.kpi = kpi;
    }

    public Map<String, Integer> getKpiValues() {
        return kpiValues;
    }

    public void setKpiValues(Map<String, Integer> kpiValues) {
        this.kpiValues = kpiValues;
    }
}
