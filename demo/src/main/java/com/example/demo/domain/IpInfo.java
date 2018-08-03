package com.example.demo.domain;

/**
 * Created by jiyajie on 16/10/10.
 */
public class IpInfo {
    /**
     *ip
     */
    private String ip;
    /**
     *系统
     */
    private String os;
    /**
     *备注
     */
    private String description;
    /**
     *业务名称
     */
    private String businessName;
    /**
     *ip段业务分类
     */
    private String ipBusClassfy;
    /**
     * 主键
     */
    private Integer id;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getIpBusClassfy() {
        return ipBusClassfy;
    }

    public void setIpBusClassfy(String ipBusClassfy) {
        this.ipBusClassfy = ipBusClassfy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
