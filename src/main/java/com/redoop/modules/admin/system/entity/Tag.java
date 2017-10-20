package com.redoop.modules.admin.system.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 说明：标签实体类
 * 包名：cn.itweet.modules.admin.system.tag.entity
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/15.
 */
@Entity
@Table(name = "sys_tag")
public class Tag {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String value;	                        // 键值
    private String label;	                        // 标签
    private String type;	                        // 类型
    private String description;                     // 描述

    private Date createDate;                        //创建时间
    private String createBy;                        //创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}
