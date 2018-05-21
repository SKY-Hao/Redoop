package com.redoop.modules.admin.news.entity;

/**
 * 说明：前端新闻展示
 * 包名：cn.itweet.tea.admin.news.entity
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/3.
 */
public class New {
    private String id;
    /* private String year;
     private String month;
     private String day;*/
    private String time;//更新时间

    private String title;   //标题
    private String picPath; //图片地址
    private String content; //内容

    @Override
    public String toString() {
        return "New{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", picPath='" + picPath + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
