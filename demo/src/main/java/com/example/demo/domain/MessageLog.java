package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiyajie on 16/8/9.
 */
public class MessageLog implements Serializable {

    private static final long serialVersionUID = -1254031385194090342L;
    private Long id;
    private Long messageId;
    private String userid;
    private String userName;
    private String sender;
    private Integer sendType;
    private Integer status;
    private String content;
    private Date createTime;
    private Date sendTime;
    private Integer syncSend;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSyncSend() {
        return syncSend;
    }

    public void setSyncSend(Integer syncSend) {
        this.syncSend = syncSend;
    }

    @Override
    public String toString() {
        return "MessageLog{" +
                "messageId=" + messageId +
                ", userid=" + userid +
                ", userName=" + userName +
                ", sendType=" + sendType +
                ", sender='" + sender + '\'' +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", syncSend='" + syncSend + '\'' +
                '}';
    }
}
