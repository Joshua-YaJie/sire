package com.example.demo.domain;

import java.io.Serializable;

/**
 * Created by jiyajie on 16/8/15.
 */
public class MessageLogDetail implements Serializable {
    private Integer syncSend;
    private Integer sendType;
    private String userName;

    public Integer getSyncSend() {
        return syncSend;
    }

    public void setSyncSend(Integer syncSend) {
        this.syncSend = syncSend;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
