package com.example.demo.domain;


import java.io.Serializable;
import java.util.List;

/**
 * Created by jiyajie on 16/8/11.
 */
public class DashboardUser implements Serializable {


    private List<DashboardChild> children;

    public List<DashboardChild> getChildren() {
        return children;
    }

    public void setChildren(List<DashboardChild> children) {
        this.children = children;
    }

}
