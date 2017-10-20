package com.redoop.modules.admin.license.utils;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 说明：
 * 项目名：License-Admin
 * 包名：cn.itweet.modules.admin.license.utils
 * 创建人：SunDaFei
 * 创建时间：2017/6/22.
 */
public class FileUtils {
    private static BufferedReader bufferedReader = null;

    /**
     * 判断文件是否存在
     * @param filePath
     */
    public static Boolean fileExits(String filePath){
        File file = new File(filePath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 读取文件
     * @param filePath
     * @return
     */
    public static String readFile(String filePath){
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 删除注册文件
     * @param filePath
     */
    public static void deleteFile(String filePath){
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

}
