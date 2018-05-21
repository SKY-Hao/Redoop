package com.redoop.modules.admin.customer.entity;

import com.redoop.modules.admin.solution.entity.Solution;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 说明：客户信息实体类
 * 包名：cn.itweet.tea.admin.customer.entity
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/12.
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;               //ID

    private String username;        //用户名称
    private String phonenumber;     //电话号码
    private String companyname;     //公司名称
    private String email;            //邮箱
    private String password;        //登录密码
    private Date registerdate;        //创建时间
    private Date logindate;         //最后登录时间
    private int activatestate;        //激活状态
    private String code;            //激活码

    private String ip;              //IP

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", companyname='" + companyname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registerdate=" + registerdate +
                ", logindate=" + logindate +
                ", activatestate=" + activatestate +
                ", code='" + code + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public Date getLogindate() {
        return logindate;
    }

    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }

    public int getActivatestate() {
        return activatestate;
    }

    public void setActivatestate(int activatestate) {
        this.activatestate = activatestate;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
