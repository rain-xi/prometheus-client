package com.nantian.enums;

public enum PromeInfoEnum {

    URL("http://nt.prometheus:9090"),

    PATH("/api/v1"),

    GET("get"),

    POST("post"),

    QUERY("/query"),

    QUERY_RANGE("/query_range"),

    ALERTS("/alerts"),

    LABELS_VALUE("/label/&labelName&/values"),

    NODE_EXPORTER_PORT("9100"),

    ALERT_YAML_NAME("global-rule.yml"),

    PROM_CM_NAME("prometheus-config"),

    PROM_CM_NAMESPACE("monitor"),

    ;

    private String value;

    PromeInfoEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
