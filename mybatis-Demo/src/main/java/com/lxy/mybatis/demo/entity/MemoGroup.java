package com.lxy.mybatis.demo.entity;

import java.util.Date;

public class MemoGroup {
    private Integer id;

    private String name;

    private Date createdTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "MemoGroup{" + "id=" + id + ", name='" + name + '\'' +
                ", createdTime=" + createdTime + ", modifyTime=" + modifyTime + '}';
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
