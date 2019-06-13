package com.nantian.enums;

public enum PromeInfoEnum {

    URL("http://10.10.47.12:9090"),

    PATH("/api/v1"),

    GET("get"),

    POST("post"),

    QUERY("/query"),

    QUERY_RANGE("/query_range"),

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
