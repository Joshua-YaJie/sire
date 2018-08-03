package com.example.demo.domain;

import java.io.Serializable;

/**
 * Created by jiyajie on 16/8/11.
 */
public class DashboardChild implements Serializable{

    private String  categoryName;
    private String  principalName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

}
