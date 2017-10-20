package com.redoop.common.utils;

import java.util.UUID;

/**
 * 说明：生成UUID
 * 包名：cn.itweet.common.utils
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/14.
 */
public class Uuid {

    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
