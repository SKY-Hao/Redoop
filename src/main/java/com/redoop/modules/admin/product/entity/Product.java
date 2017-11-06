package com.redoop.modules.admin.product.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 说明：产品资料实体类
 * 包名：cn.itweet.modules.admin.product
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间：2017/10/10.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String      id;             //ID
    private String      producttype;    //文档类型  （0:产品文档  1:产品技术文档  2:测试报告）
    private String      productname;    //文档名称
    private String      producttime;    //文档发布时间


    private String      producturl;    //文档(下载)地址（下载目录:http://archive.redoop.com/crh/rpm/5.0.2.4/CRH/x86_64/centos6/）
    private String      productauthor; //文档发布人
    private String      protype;       //文档发布状态（0 发布 1 不发布）
    private int         productcount; //文档下载次数

    private String      productpeople; //文档下载人（用户id.. ）
    private String      productupload; //文档上传

    private String      outline;    //概要（和简报更新概要同步）

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", producttype='" + producttype + '\'' +
                ", productname='" + productname + '\'' +
                ", producttime='" + producttime + '\'' +
                ", producturl='" + producturl + '\'' +
                ", productauthor='" + productauthor + '\'' +
                ", protype='" + protype + '\'' +
                ", productcount=" + productcount +
                ", productpeople='" + productpeople + '\'' +
                ", productupload='" + productupload + '\'' +
                ", outline='" + outline + '\'' +
                '}';
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
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

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProducttime() {
        return producttime;
    }

    public void setProducttime(String producttime) {
        this.producttime = producttime;
    }

    public String getProducturl() {
        return producturl;
    }

    public void setProducturl(String producturl) {
        this.producturl = producturl;
    }

    public String getProductauthor() {
        return productauthor;
    }

    public void setProductauthor(String productauthor) {
        this.productauthor = productauthor;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public int getProductcount() {
        return productcount;
    }

    public void setProductcount(int productcount) {
        this.productcount = productcount;
    }

    public String getProductpeople() {
        return productpeople;
    }

    public void setProductpeople(String productpeople) {
        this.productpeople = productpeople;
    }

    public String getProductupload() {
        return productupload;
    }

    public void setProductupload(String productupload) {
        this.productupload = productupload;
    }

}