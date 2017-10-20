package com.redoop.modules.admin.news.entity;

/**
 * 说明：前端新闻展示
 * 包名：cn.itweet.modules.admin.news.entity
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/3.
 */
public class New {
    private String id;
    private String year;
    private String month;
    private String day;

    private String title;   //标题
    private String picPath; //图片地址
    private String content; //内容

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
