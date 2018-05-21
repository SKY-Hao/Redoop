package com.redoop.modules.admin.news.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 说明：新闻实体类
 * 包名：cn.itweet.tea.admin.news
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/2.
 */
@Entity
@Table(name = "sys_news")
public class News {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;              //ID
    private String title;           //标题

    @Column(name = "content",columnDefinition="TEXT")
    private String content;         //内容
    private String picpath;         //缩略图

    private String publisher;       //作者（发布人）
    private String date;            //时间
    private String time;

    private int state;
    private String outline;         //概要（和简报概要一样）

    private  String source;         //来源

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", picpath='" + picpath + '\'' +
                ", publisher='" + publisher + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", state=" + state +
                ", outline='" + outline + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOutline() {

        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
