package com.redoop.modules.admin.download.entity;


import com.redoop.modules.admin.system.entity.Tag;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 说明：CRH||AI实体类
 * 包名：cn.itweet.modules.admin.download
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间： 2017/9/22.
 */
@Entity
@Table(name = "download")
public class Download implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String      id;             //ID
    private String      producttype;    //产品类型  （0:CRH  1:AI）
    private String      platformtype;   //平台类型  （0:X64   1:OpenPower  2:ARM/飞腾   3:申威  4:龙芯(敬请期待) ）
    private String      productversion; //产品版本  （0:CRH5.0   1:CRH4.9 ）
    private String      producttime;    //产品发布时间


    private String      documentname;   //文档名称(操作系统)
    private String      sysversion;     //操作系统支持版本编号


    private String      documenturl;    //文档(下载)地址（下载目录:http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/）
    private String      see;            //查看地址
    private String      documentauthor; //文档发布人
    private String      documenttype;   //文档发布状态（0 发布 1 不发布）
    private int         docudowncount;  //文档下载次数


    private String      docudownpeople; //文档下载人（用户id.. ）
    private String      documentupload; //文档上传

    private String      systempic;   //系统图片
    private String      systempicname; //系统图片名称

    private String      chippic;   //芯片图片
    private String      chippicname; //芯片图片名称

    private String      outline;    //简报更新(和简报更新概要同步)

    @Override
    public String toString() {
        return "Download{" +
                "id='" + id + '\'' +
                ", producttype='" + producttype + '\'' +
                ", platformtype='" + platformtype + '\'' +
                ", productversion='" + productversion + '\'' +
                ", producttime='" + producttime + '\'' +
                ", documentname='" + documentname + '\'' +
                ", sysversion='" + sysversion + '\'' +
                ", documenturl='" + documenturl + '\'' +
                ", see='" + see + '\'' +
                ", documentauthor='" + documentauthor + '\'' +
                ", documenttype='" + documenttype + '\'' +
                ", docudowncount=" + docudowncount +
                ", docudownpeople='" + docudownpeople + '\'' +
                ", documentupload='" + documentupload + '\'' +
                ", systempic='" + systempic + '\'' +
                ", systempicname='" + systempicname + '\'' +
                ", chippic='" + chippic + '\'' +
                ", chippicname='" + chippicname + '\'' +
                ", outline='" + outline + '\'' +
                ", tag=" + tag +
                '}';
    }

    public String getOutline() {

        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    @ManyToOne
    @JoinColumn(name = "tag_value")
    private Tag tag;

    public String getSee() {
        return see;
    }

    public void setSee(String see) {
        this.see = see;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getPlatformtype() {
        return platformtype;
    }

    public void setPlatformtype(String platformtype) {
        this.platformtype = platformtype;
    }

    public String getProductversion() {
        return productversion;
    }

    public void setProductversion(String productversion) {
        this.productversion = productversion;
    }

    public String getProducttime() {
        return producttime;
    }

    public void setProducttime(String producttime) {
        this.producttime = producttime;
    }


    public String getSysversion() {
        return sysversion;
    }

    public void setSysversion(String sysversion) {
        this.sysversion = sysversion;
    }

    public String getDocumentname() {
        return documentname;
    }

    public void setDocumentname(String documentname) {
        this.documentname = documentname;
    }

    public String getDocumenturl() {
        return documenturl;
    }

    public void setDocumenturl(String documenturl) {
        this.documenturl = documenturl;
    }

    public String getDocumentauthor() {
        return documentauthor;
    }

    public void setDocumentauthor(String documentauthor) {
        this.documentauthor = documentauthor;
    }

    public String getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(String documenttype) {
        this.documenttype = documenttype;
    }

    public int getDocudowncount() {
        return docudowncount;
    }

    public void setDocudowncount(int docudowncount) {
        this.docudowncount = docudowncount;
    }

    public String getDocudownpeople() {
        return docudownpeople;
    }

    public void setDocudownpeople(String docudownpeople) {
        this.docudownpeople = docudownpeople;
    }

    public String getDocumentupload() {
        return documentupload;
    }

    public void setDocumentupload(String documentupload) {
        this.documentupload = documentupload;
    }

    public String getSystempic() {
        return systempic;
    }

    public void setSystempic(String systempic) {
        this.systempic = systempic;
    }

    public String getSystempicname() {
        return systempicname;
    }

    public void setSystempicname(String systempicname) {
        this.systempicname = systempicname;
    }

    public String getChippic() {
        return chippic;
    }

    public void setChippic(String chippic) {
        this.chippic = chippic;
    }

    public String getChippicname() {
        return chippicname;
    }

    public void setChippicname(String chippicname) {
        this.chippicname = chippicname;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

}
