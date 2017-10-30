package com.redoop.modules.admin.component.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 说明：服务组件实体类
 * 包名：cn.itweet.modules.admin.component.entity
 * 项目名：License-Admin
 * 创建人：孙大飞
 * 创建时间：13/07/17.
 */
@Entity
@Table(name = "component")
public class Component implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;              //ID

    private Date adddate;           //添加时间
    private Date editdate;          //修改时间
    private String additive;        //添加者
    private String type;            //类型（0:组件  1:案例  2:行业版本）
    private String name;            //组件（案例）名称
    private String alias;           //组件（案例）别名
    private String subjection;      //组件（案例）所属
    private String open;           //是否开源（0：不开源1：开源）
    private String mpl;             //开源协议（若是开源，不开源为闭源）

    private String description;     //描述     (和简报更新概要同步)

    private int downloads;          //下载量（默认0）
    private String memorysize;      //存储大小
    private String picname;         //图片名称
    private String picurl;          //图片地址
    private String downurl;         //组件（案例）下载地址
    private int showstate;          //显示状态
    private String version;         //产品版本

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getAdditive() {
        return additive;
    }

    public void setAdditive(String additive) {
        this.additive = additive;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSubjection() {
        return subjection;
    }

    public void setSubjection(String subjection) {
        this.subjection = subjection;
    }

    public String getMpl() {
        return mpl;
    }

    public void setMpl(String mpl) {
        this.mpl = mpl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public String getMemorysize() {
        return memorysize;
    }

    public void setMemorysize(String memorysize) {
        this.memorysize = memorysize;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getDownurl() {
        return downurl;
    }

    public void setDownurl(String downurl) {
        this.downurl = downurl;
    }

    public int getShowstate() {
        return showstate;
    }

    public void setShowstate(int showstate) {
        this.showstate = showstate;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id='" + id + '\'' +
                ", adddate=" + adddate +
                ", editdate=" + editdate +
                ", additive='" + additive + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", subjection='" + subjection + '\'' +
                ", open=" + open +
                ", mpl='" + mpl + '\'' +
                ", description='" + description + '\'' +
                ", downloads=" + downloads +
                ", memorysize='" + memorysize + '\'' +
                ", picname='" + picname + '\'' +
                ", picurl='" + picurl + '\'' +
                ", downurl='" + downurl + '\'' +
                ", showstate=" + showstate +
                ", version='" + version + '\'' +
                '}';
    }
}
