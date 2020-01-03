package com.ibs.kpitrackerservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "kpi")
public class Kpi {

    @Id
    private ObjectId id;
    private String kpi;
    private List<String> kpiParams;

    public Kpi() {

    }

    public Kpi(ObjectId id, String kpi, List<String> kpiParams) {
        this.id = id;
        this.kpi = kpi;
        this.kpiParams = kpiParams;
    }

    //Converting ObjectId to HexString inorder to keep the primary identifier more readable while converting it as json
    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getKpi() {
        return kpi;
    }

    public void setKpi(String kpi) {
        this.kpi = kpi;
    }

    public List<String> getKpiParams() {
        return kpiParams;
    }

    public void setKpiParams(List<String> kpiParams) {
        this.kpiParams = kpiParams;
    }
}
