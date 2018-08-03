package com.example.demo.domain;

/**
 * Created by jiyajie on 16/10/8.
 */
public class ZombieInfo{
    /**
     * 主键ID
     */
    private Integer id;
    /**
     *系统
     */
    private String os;
    /**
     *远程端口
     */
    private String ip;
    /**
     *端口
     */
    private String port;
    /**
     *肉鸡类型
     */
    private String zombieType;
    /**
     *内网地址
     */
    private String innerIp;
    /**
     *计算机名称
     */
    private String computer;
    /**
     *地区
     */
    private String location;
    /**
     *到期日
     */
    private String expireDate;
    /**
     *使用人
     */
    private String userStr;
    /**
     *淘宝网店地址
     */
    private String taobaoUrl;
    /**
     *淘宝网店名
     */
    private String shopName;
    /**
     *价格
     */
    private String price;
    /**
     *备注
     */
    private String descrption;
    /**
     *ip:端口
     */
    private String address;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getZombieType() {
        return zombieType;
    }

    public void setZombieType(String zombieType) {
        this.zombieType = zombieType;
    }

    public String getInnerIp() {
        return innerIp;
    }

    public void setInnerIp(String innerIp) {
        this.innerIp = innerIp;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

    public String getTaobaoUrl() {
        return taobaoUrl;
    }

    public void setTaobaoUrl(String taobaoUrl) {
        this.taobaoUrl = taobaoUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
