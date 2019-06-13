package com.nantian.entity;

import java.util.List;

public class MetricsMonitorInfo {

    private MetricsInfo metric;

    private List<List<Object>> values;

    public MetricsInfo getMetric() {
        return metric;
    }

    public void setMetric(MetricsInfo metric) {
        this.metric = metric;
    }

    public List<List<Object>> getValues() {
        return values;
    }

    public void setValues(List<List<Object>> values) {
        this.values = values;
    }
}
