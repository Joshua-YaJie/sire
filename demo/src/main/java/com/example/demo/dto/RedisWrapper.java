package com.example.demo.dto;

import java.util.List;

/**
 * Created by jiyajie on 16/9/30.
 */
public class RedisWrapper {
    List<RedisConfig> wrapperList;

    public List<RedisConfig> getWrapperList() {
        return wrapperList;
    }

    public void setWrapperList(List<RedisConfig> wrapperList) {
        this.wrapperList = wrapperList;
    }
}
