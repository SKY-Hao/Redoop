package com.redoop.modules.admin.license.entity;

import javax.persistence.*;

/**
 * 说明：
 * 项目名：License-Admin
 * 包名：cn.itweet.modules.admin.license.entity
 * 创建人：SunDaFei
 * 创建时间：2017/6/22.
 */

@Entity
@Table(name = "service")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;


}
