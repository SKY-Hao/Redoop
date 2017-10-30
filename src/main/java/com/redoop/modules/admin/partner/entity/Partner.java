package com.redoop.modules.admin.partner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import java.util.Date;
/**
 * 说明：合作伙伴实体类
 * 包名：cn.itweet.modules.admin.customer.entity
 * 项目名：License-Admin
 * 创建人：黄天浩
 * 创建时间：2017年9月7日16:36:32
 */
@Entity
@Table(name = "partner")
public class Partner implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;               //ID

    private String  companyname;    //公司名称
    private String  companypic;     //公司logo
    private String  companypicname; //logo名称
    private String  address;        //公司地址
    private String  companytel;     //公司电话
    private String  companyprofile; //公司简介
    private String  companytype;    //公司类型（0互联网  1企业应用）
    private String  industry;       //公司涉足行业(0政府/金融 1媒体/酒店  2生物技术/化工    3交通/建筑/工程   4IT/科技/公共事业 5其它)

    private String  partnertype;    //合作伙伴类型 (0硬件厂商   1集成厂商    2设备厂商 3软件合作厂商 4基础软件厂商 5应用软件厂商)
    private String  partnerproduct; //合作伙伴产品名称
    private String  partnerversion; //合作伙伴产品版本
    private String  intention;      //合作伙伴意向    (审核通过是否展示公司信息	    0 展示   1 不展示（-默认不显示-))
    private Date    applicationtime;//合作伙伴申请时间  (当前时间)

    private String  contactsname;   //联系人姓名
    private String  contactstel;    //联系人电话
    private String  contactsemail;  //联系人email

    private String  auditor;        //审核人   (系统使用者)
    private Date    auditortime;    //审核时间  (当前时间)
    private int     auditoresult;   //审核结果  (成功 不成功 默认未审核状态)

    private String  testnumber;     //测试编号
    private String  testversion;    //测试版本（Redoop CRH版本）
    private String  testtime;       //测试时间
    private String  testcontent;    //测试内容
    private String  testresult;     //测试结果

    private String authentication;  //认证信息(0:认证 1:未认证)

    private String outline;         //概要（和简报更新概要同步）

    @Override
    public String toString() {
        return "Partner{" +
                "id='" + id + '\'' +
                ", companyname='" + companyname + '\'' +
                ", companypic='" + companypic + '\'' +
                ", companypicname='" + companypicname + '\'' +
                ", address='" + address + '\'' +
                ", companytel='" + companytel + '\'' +
                ", companyprofile='" + companyprofile + '\'' +
                ", companytype='" + companytype + '\'' +
                ", industry='" + industry + '\'' +
                ", partnertype='" + partnertype + '\'' +
                ", partnerproduct='" + partnerproduct + '\'' +
                ", partnerversion='" + partnerversion + '\'' +
                ", intention='" + intention + '\'' +
                ", applicationtime=" + applicationtime +
                ", contactsname='" + contactsname + '\'' +
                ", contactstel='" + contactstel + '\'' +
                ", contactsemail='" + contactsemail + '\'' +
                ", auditor='" + auditor + '\'' +
                ", auditortime=" + auditortime +
                ", auditoresult=" + auditoresult +
                ", testnumber='" + testnumber + '\'' +
                ", testversion='" + testversion + '\'' +
                ", testtime='" + testtime + '\'' +
                ", testcontent='" + testcontent + '\'' +
                ", testresult='" + testresult + '\'' +
                ", authentication='" + authentication + '\'' +
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

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanypic() {
        return companypic;
    }

    public void setCompanypic(String companypic) {
        this.companypic = companypic;
    }

    public String getCompanypicname() {
        return companypicname;
    }

    public void setCompanypicname(String companypicname) {
        this.companypicname = companypicname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanytel() {
        return companytel;
    }

    public void setCompanytel(String companytel) {
        this.companytel = companytel;
    }

    public String getCompanyprofile() {
        return companyprofile;
    }

    public void setCompanyprofile(String companyprofile) {
        this.companyprofile = companyprofile;
    }

    public String getCompanytype() {
        return companytype;
    }

    public void setCompanytype(String companytype) {
        this.companytype = companytype;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPartnertype() {
        return partnertype;
    }

    public void setPartnertype(String partnertype) {
        this.partnertype = partnertype;
    }

    public String getPartnerproduct() {
        return partnerproduct;
    }

    public void setPartnerproduct(String partnerproduct) {
        this.partnerproduct = partnerproduct;
    }

    public String getPartnerversion() {
        return partnerversion;
    }

    public void setPartnerversion(String partnerversion) {
        this.partnerversion = partnerversion;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public Date getApplicationtime() {
        return applicationtime;
    }

    public void setApplicationtime(Date applicationtime) {
        this.applicationtime = applicationtime;
    }

    public String getContactsname() {
        return contactsname;
    }

    public void setContactsname(String contactsname) {
        this.contactsname = contactsname;
    }

    public String getContactstel() {
        return contactstel;
    }

    public void setContactstel(String contactstel) {
        this.contactstel = contactstel;
    }

    public String getContactsemail() {
        return contactsemail;
    }

    public void setContactsemail(String contactsemail) {
        this.contactsemail = contactsemail;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Date getAuditortime() {
        return auditortime;
    }

    public void setAuditortime(Date auditortime) {
        this.auditortime = auditortime;
    }

    public int getAuditoresult() {
        return auditoresult;
    }

    public void setAuditoresult(int auditoresult) {
        this.auditoresult = auditoresult;
    }

    public String getTestnumber() {
        return testnumber;
    }

    public void setTestnumber(String testnumber) {
        this.testnumber = testnumber;
    }

    public String getTestversion() {
        return testversion;
    }

    public void setTestversion(String testversion) {
        this.testversion = testversion;
    }

    public String getTesttime() {
        return testtime;
    }

    public void setTesttime(String testtime) {
        this.testtime = testtime;
    }

    public String getTestcontent() {
        return testcontent;
    }

    public void setTestcontent(String testcontent) {
        this.testcontent = testcontent;
    }

    public String getTestresult() {
        return testresult;
    }

    public void setTestresult(String testresult) {
        this.testresult = testresult;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

}
