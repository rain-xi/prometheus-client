package com.nantian.entity;

public class MetricsInfo {

    private String addonmanager_kubernetes_io_mode;

    private String instance;

    private String job;

    private String kubernetes_io_cluster_service;

    private String kubernetes_io_name;

    private String kubernetes_name;

    private String kubernetes_namespace;

    private String device;

    private String fstype;

    private String mountpoint;

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public String getAddonmanager_kubernetes_io_mode() {
        return addonmanager_kubernetes_io_mode;
    }

    public void setAddonmanager_kubernetes_io_mode(String addonmanager_kubernetes_io_mode) {
        this.addonmanager_kubernetes_io_mode = addonmanager_kubernetes_io_mode;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getKubernetes_io_cluster_service() {
        return kubernetes_io_cluster_service;
    }

    public void setKubernetes_io_cluster_service(String kubernetes_io_cluster_service) {
        this.kubernetes_io_cluster_service = kubernetes_io_cluster_service;
    }

    public String getKubernetes_io_name() {
        return kubernetes_io_name;
    }

    public void setKubernetes_io_name(String kubernetes_io_name) {
        this.kubernetes_io_name = kubernetes_io_name;
    }

    public String getKubernetes_name() {
        return kubernetes_name;
    }

    public void setKubernetes_name(String kubernetes_name) {
        this.kubernetes_name = kubernetes_name;
    }

    public String getKubernetes_namespace() {
        return kubernetes_namespace;
    }

    public void setKubernetes_namespace(String kubernetes_namespace) {
        this.kubernetes_namespace = kubernetes_namespace;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getFstype() {
        return fstype;
    }

    public void setFstype(String fstype) {
        this.fstype = fstype;
    }

    public String getMountpoint() {
        return mountpoint;
    }

    public void setMountpoint(String mountpoint) {
        this.mountpoint = mountpoint;
    }
}
