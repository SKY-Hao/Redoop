package com.redoop.common.utils;

import com.redoop.modules.admin.news.entity.PicUploadResult;
import com.sun.corba.se.spi.activation.Server;
import org.apache.catalina.connector.Request;
import org.apache.tomcat.jni.FileInfo;

import java.io.File;

/**
 * 说明： 删除图片工具类
 * 创建人：Itdeer
 * 创建时间：2017-08-31 上午11:05.
 */
public class DeleteUtils {

    public static void deletePic(String path){
        System.out.println("删除的文件为：" + path);
        File file = new File(path);

        if(file.exists()){
            file.delete();
        }
    }

}

