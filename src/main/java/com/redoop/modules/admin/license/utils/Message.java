package com.redoop.modules.admin.license.utils;

/**
 * 说明： 消息工具类
 * 项目名：License-Admin
 * 包名：cn.itweet.tea.admin.license.utils
 * 创建人：SunDaFei
 * 创建时间：2017/6/23.
 */
public class Message {

    private String msg;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Message() {
    }

    public Message(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
