package com.example.demo.dto;

/**
 * Created by jiyajie on 16/9/29.
 */
public class RedisKey {
    private String keyName;
    private String keyType;

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }
}
