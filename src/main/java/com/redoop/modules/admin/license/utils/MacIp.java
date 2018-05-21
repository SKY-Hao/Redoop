package com.redoop.modules.admin.license.utils;

/**
 * 说明：Mac和IP地址
 * 项目名：License-Admin
 * 包名：cn.itweet.tea.admin.license.entity
 * 创建人：SunDaFei
 * 创建时间：2017/6/22.
 */
public class MacIp {

    private String mac;
    private String ip;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "MacIp{" +
                "mac='" + mac + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
