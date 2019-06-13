package com.nantian.entity;

public class PromeResultEntity {

    private String status;

    private PromeDataEntity data;

    private String errorType;

    private String error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PromeDataEntity getData() {
        return data;
    }

    public void setData(PromeDataEntity data) {
        this.data = data;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
