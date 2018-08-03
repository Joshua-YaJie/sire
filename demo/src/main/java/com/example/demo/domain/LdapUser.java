package com.example.demo.domain;

/**
 * Created by jiyajie on 16/9/10.
 */
public class LdapUser {
    /**
     * 用户名称
     */
    private String displayName;
    /**
     * 邮箱
     */
    private String userPrincipalName;
    /**
     * ID
     */
    private Integer ID;
    /**
     * 角色
     */
    private String roleName;

    public String getUserPrincipalName() {
        return userPrincipalName;
    }

    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    public String getDisplayName() {

        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
