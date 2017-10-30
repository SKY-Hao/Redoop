package com.redoop.modules.admin.mess.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 说明：简报实体类
 * 包名：cn.itweet.modules.admin.mess
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间： 2017年10月23日10:04:23
 */
@Entity
@Table(name = "mess")
public class Mess implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String      id;             //ID

    private String      tablename;      //tableName(对应的表名)
    private String      tableid;        //tableid（对应表名的id)
    private String      title;          //title (对应表的标题）
    private String      content;        //content(对应表的内容)
    private String      date;           //显示时间（每周）

    private String      outline;        //更新（概要）

    private int         state;          //是否展示0:展示 1：不展示
    private String      author;         //作者

    private Date        authortime;     //更新时间

    private Date        starttime;      //开始时间
    private Date        endtime;        //结束时间

    @Override
    public String toString() {
        return "Mess{" +
                "id='" + id + '\'' +
                ", tablename='" + tablename + '\'' +
                ", tableid='" + tableid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", outline='" + outline + '\'' +
                ", state=" + state +
                ", author='" + author + '\'' +
                ", authortime=" + authortime +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }


    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getAuthortime() {
        return authortime;
    }

    public void setAuthortime(Date authortime) {
        this.authortime = authortime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
