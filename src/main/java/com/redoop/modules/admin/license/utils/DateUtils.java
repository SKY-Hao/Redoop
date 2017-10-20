package com.redoop.modules.admin.license.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 说明： 时间工具类
 * 项目名：License-Admin
 * 包名：cn.itweet.modules.admin.license.utils
 * 创建人：SunDaFei
 * 创建时间：2017/6/22.
 */
public class DateUtils {

    /**
     * 根据有效期时长算出到期时间
     * @param days
     * @return
     */
    public static String vaildDate(int days) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
