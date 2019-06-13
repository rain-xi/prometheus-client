package com.nantian.entity;

import java.util.List;

public class MetricsMonitorInfo {

    private MetricsInfo metric;

    private List<List<Object>> values;

    private List<Object> value;

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

    public List<Object> getValue() {
        return value;
    }

    public void setValue(List<Object> value) {
        this.value = value;
    }
}
