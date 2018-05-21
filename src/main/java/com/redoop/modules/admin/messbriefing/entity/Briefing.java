package com.redoop.modules.admin.messbriefing.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 说明：最终周报实体类(前端单独页面用)
 * 包名：cn.itweet.tea.admin.briefing
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间： 2017年10月31日15:58:08
 */
@Entity
@Table(name = "briefing")
public class Briefing {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String      id;             //ID

    private String      tablename;      //tableName(对应的表名)
    private String      tableid;        //tableid（对应表名的id)
    private String      tabletitle;     //tabletitle (对应表的标题）

    @Column(name = "tablecontents",columnDefinition="TEXT")
    private String      tablecontents;  //tablecontents(对应表的内容)
    private String      date;           //显示时间（每周）

    private String      outline;        //更新（概要）

    private int         state;          //是否展示0:展示 1：不展示
    private String      author;         //作者
    private Date        authortime;     //更新时间

    private String      jumpurl;        //路径

    public String getJumpurl() {
        return jumpurl;
    }

    public void setJumpurl(String jumpurl) {
        this.jumpurl = jumpurl;
    }

    @Override
    public String toString() {
        return "Briefing{" +
                "id='" + id + '\'' +
                ", tablename='" + tablename + '\'' +
                ", tableid='" + tableid + '\'' +
                ", tabletitle='" + tabletitle + '\'' +
                ", tablecontents='" + tablecontents + '\'' +
                ", date='" + date + '\'' +
                ", outline='" + outline + '\'' +
                ", state=" + state +
                ", author='" + author + '\'' +
                ", authortime=" + authortime +
                ", jumpurl='" + jumpurl + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTabletitle() {
        return tabletitle;
    }

    public void setTabletitle(String tabletitle) {
        this.tabletitle = tabletitle;
    }

    public String getTablecontents() {
        return tablecontents;
    }

    public void setTablecontents(String tablecontents) {
        this.tablecontents = tablecontents;
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

}
