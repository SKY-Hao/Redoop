package com.redoop.modules.admin.license.entity;

/**
 * 说明：注册码属性实体类
 * 项目名：License-Admin
 * 包名：cn.itweet.modules.admin.license.entity
 * 创建人：SunDaFei
 * 创建时间：2017/6/22.
 */
public class Code {

    private String company; 	        // 公司
    private String project; 	        // 项目
    private String email; 		    // 邮箱
    private String products; 	        // 产品
    private int node; 			    // 授权节点数
    private int version; 		        // 版本（正式、试用）

    private String macAddress; 	    // Mac地址
    private String ip; 			    // IP
    private int validPeriod; 	    // 有效期
    private int trials; 		        // 试用次数
    private String services;	        //授权组件服务
    private int allowPic;           //是否允许替换LOGO及背景图片

    public int getAllowPic() {
        return allowPic;
    }

    public void setAllowPic(int allowPic) {
        this.allowPic = allowPic;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(int validPeriod) {
        this.validPeriod = validPeriod;
    }

    public int getTrials() {
        return trials;
    }

    public void setTrials(int trials) {
        this.trials = trials;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }
}
