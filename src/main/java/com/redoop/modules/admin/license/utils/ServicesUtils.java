package com.redoop.modules.admin.license.utils;

/**
 * 说明： 服务组件工具类
 * 项目名：License-Admin
 * 包名：cn.itweet.modules.admin.license.utils
 * 创建人：SunDaFei
 * 创建时间：2017/6/22.
 */
public class ServicesUtils {

    /**
     * 获取默认授权组件
     * @return
     */
    public static String getInitService(){
        return "HDFS,YARN,HIVE,HBASE,SPARK";
    }
}
