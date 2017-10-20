package com.redoop.modules.admin.license.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 说明：注册许可实体类
 * 包名：cn.itweet.modules.admin.license
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
@Entity
@Table(name = "license")
public class License implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;                             //id

    @Column(name = "company")
    private String company;                     //公司名称

    @Column(name = "project")
    private String project;                     //项目名称

    @Column(name = "email")
    private String email;                       //邮箱

    @Column(name = "products")
    private String products;                    //所属产品

    @Column(name = "node")
    private int node;                           //节点数

    @Column(name = "create_date")
    private Date createDate;                    //申请时间

    @Column(name = "code",columnDefinition="TEXT")
    private String code;                        //授权码

    @Column(name = "version")
    private int version;                        //版本（正式版或者试用版）

    @Column(name = "status")
    private int status;                         //0为没有提交正式申请 1为提交正式申请 2已经授权

    @Column(name = "vaild")
    private String vaild;                       //有效期

    @Column(name = "ip")
    private String ip;                          //ip地址

    @Column(name = "mac")
    private String mac;                         //mac地址

    @Column(name = "trials")
    private int trials;                         //申请次数

    @Column(name = "vaild_days")
    private int vaildDays;                      //有效天数

    @Column(name = "update_time")
    private Date updateDate;                    //更新时间

    private String services;                    //授权组件

    @Column(name = "allow_pic")
    private int allowPic;                       //是否允许替换背景及Logo

    public int getAllowPic() {
        return allowPic;
    }

    public void setAllowPic(int allowPic) {
        this.allowPic = allowPic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getVaild() {
        return vaild;
    }

    public void setVaild(String vaild) {
        this.vaild = vaild;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getTrials() {
        return trials;
    }

    public void setTrials(int trials) {
        this.trials = trials;
    }

    public int getVaildDays() {
        return vaildDays;
    }

    public void setVaildDays(int vaildDays) {
        this.vaildDays = vaildDays;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "License{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", project='" + project + '\'' +
                ", email='" + email + '\'' +
                ", products='" + products + '\'' +
                ", node=" + node +
                ", createDate=" + createDate +
                ", code='" + code + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", vaild='" + vaild + '\'' +
                ", ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", trials=" + trials +
                ", vaildDays=" + vaildDays +
                ", updateDate=" + updateDate +
                ", services='" + services + '\'' +
                ", allowPic=" + allowPic +
                '}';
    }
}
