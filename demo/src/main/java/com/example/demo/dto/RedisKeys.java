package com.example.demo.dto;

/**
 * Created by jiyajie on 16/9/28.
 */
public class RedisKeys {
    private Integer redisId;
    private String keyName;
    private Integer keyType;
    private Integer ID;
    public Integer getKeyType() {
        return keyType;
    }

    public void setKeyType(Integer keyType) {
        this.keyType = keyType;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getRedisId() {
        return redisId;
    }

    public void setRedisId(Integer redisId) {
        this.redisId = redisId;
    }
}
