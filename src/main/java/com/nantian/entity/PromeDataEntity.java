package com.nantian.entity;

import java.util.List;

public class PromeDataEntity {

    private String resultType;

    private List<MetricsMonitorInfo> result;

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public List<MetricsMonitorInfo> getResult() {
        return result;
    }

    public void setResult(List<MetricsMonitorInfo> result) {
        this.result = result;
    }
}
