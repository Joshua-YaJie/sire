package com.example.demo.domain;

/**
 * Created by jiyajie on 16/10/10.
 */
public class DeviceInfo {
    /**
     *id
     */
    private Integer id;
    /**
     *设备类型
     */
    private String deviceInfo;
    /**
     *品牌
     */
    private String brand;
    /**
     *设备型号
     */
    private String deviceType;
    /**
     *序列号
     */
    private String serialNum;
    /**
     *机柜号
     */
    private String cabinetNum;
    /**
     *实验室编号
     */
    private String laboratoryNum;
    /**
     *管理ip地址
     */
    private String manageIp;
    /**
     *设备ip地址
     */
    private String deviceIp;
    /**
     *业务分类
     */
    private String businessClassfy;
    /**
     *业务明细
     */
    private String businessDetail;
    /**
     *维护人
     */
    private String maintain;
    /**
     *设备所在地
     */
    private String deviceLocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getCabinetNum() {
        return cabinetNum;
    }

    public void setCabinetNum(String cabinetNum) {
        this.cabinetNum = cabinetNum;
    }

    public String getLaboratoryNum() {
        return laboratoryNum;
    }

    public void setLaboratoryNum(String laboratoryNum) {
        this.laboratoryNum = laboratoryNum;
    }

    public String getManageIp() {
        return manageIp;
    }

    public void setManageIp(String manageIp) {
        this.manageIp = manageIp;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getBusinessClassfy() {
        return businessClassfy;
    }

    public void setBusinessClassfy(String businessClassfy) {
        this.businessClassfy = businessClassfy;
    }

    public String getBusinessDetail() {
        return businessDetail;
    }

    public void setBusinessDetail(String businessDetail) {
        this.businessDetail = businessDetail;
    }

    public String getMaintain() {
        return maintain;
    }

    public void setMaintain(String maintain) {
        this.maintain = maintain;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }
}
