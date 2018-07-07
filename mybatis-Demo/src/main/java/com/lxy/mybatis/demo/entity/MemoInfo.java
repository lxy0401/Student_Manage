package com.lxy.mybatis.demo.entity;

import com.lxy.mybatis.demo.common.backGround;

import java.util.Date;

public class MemoInfo {
    private Integer id;
    private Integer group_id;
    private String title;
    private String content;
    private Character isprotected;
    private backGround background;
    private Character remind;
    private Date reminTime;
    private Date createdTime;
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Character getIsprotected() {
        return isprotected;
    }

    public void setIsprotected(Character isprotected) {
        this.isprotected = isprotected;
    }

    public backGround getBackground() {
        return background;
    }

    public void setBackground(backGround background) {
        this.background = background;
    }

    public Character getRemind() {
        return remind;
    }

    public void setRemind(Character remind) {
        this.remind = remind;
    }

    public Date getReminTime() {
        return reminTime;
    }

    public void setReminTime(Date reminTime) {
        this.reminTime = reminTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "MemoInfo{" +
                "id=" + id +
                ", group_id=" + group_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isprotected=" + isprotected +
                ", background=" + background +
                ", remind=" + remind +
                ", reminTime=" + reminTime +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
