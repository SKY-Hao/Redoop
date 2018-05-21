package com.redoop.modules.admin.license.utils;

import java.util.UUID;

/**
 * 说明：生成UUID工具类
 * 项目名：License-Admin
 * 包名：cn.itweet.tea.admin.license.utils
 * 创建人：SunDaFei
 * 创建时间：2017/6/22.
 */
public class UuidUtils {

    /**
     * 获取UUID值
     * @return
     */
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
