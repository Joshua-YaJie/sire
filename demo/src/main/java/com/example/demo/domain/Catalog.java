package com.example.demo.domain;

import java.util.List;

/**
 * Created by jiyajie on 16/9/8.
 */
public class Catalog {
    private Integer id;
    private Integer parentId;
    private String path;
    private Integer priority;
    private String text;
    private List<Catalog> nodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public List<Catalog> getNodes() {
        return nodes;
    }

    public void setNodes(List<Catalog> nodes) {
        this.nodes = nodes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
