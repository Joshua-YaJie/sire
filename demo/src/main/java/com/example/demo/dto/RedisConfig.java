package com.example.demo.dto;


import java.util.List;

/**
 * Created by jiyajie on 16/9/28.
 */
public class RedisConfig {
    private String serverIp;
    private String serverPort;
    private Integer cluster;
    private Integer ID;
    private Integer redisId;
    private List<RedisKeys> redisKeyList;

    public List<RedisKeys> getRedisKeyList() {
        return redisKeyList;
    }

    public void setRedisKeyList(List<RedisKeys> redisKeyList) {
        this.redisKeyList = redisKeyList;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCluster() {
        return cluster;
    }

    public void setCluster(Integer cluster) {
        this.cluster = cluster;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public Integer getRedisId() {
        return redisId;
    }

    public void setRedisId(Integer redisId) {
        this.redisId = redisId;
    }
}
