package com.nantian.enums;

public enum URLParamKey {

    QUERY("query"),

    START("start"),

    END("end"),

    STEP("step")
    ;

    String value;

    URLParamKey(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
