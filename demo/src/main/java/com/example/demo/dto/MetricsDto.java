package com.example.demo.dto;

import java.io.Serializable;

/**
 * Created by jiyajie on 16/8/30.
 */
public class MetricsDto implements Serializable{

    private Long metricsId;
    private String scheme;
    private String metricName;
    private String Description;
    private String Unit;

    public Long getMetricsId() {
        return metricsId;
    }

    public void setMetricsId(Long metricsId) {
        this.metricsId = metricsId;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }
}
