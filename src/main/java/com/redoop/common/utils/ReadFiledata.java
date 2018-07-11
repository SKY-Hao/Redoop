package com.redoop.common.utils;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;

import javax.sound.midi.Soundbank;
import java.io.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.beust.jcommander.internal.Lists.newArrayList;

/**
 * Created by Administrator on 2018/6/8.
 */
public class ReadFiledata  {


    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = null;

            //使用readLine方法，一次读一行
            while(( str = br.readLine())!=null){
                result.append(System.lineSeparator()+str);

            }
            br.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void main(String[] args){
        //我的txt文本存放目录，根据自己的路径修改即可
       /* File  file = new File ("E:/ids1.txt");
        System.out.println(txt2String(file));*/

       /* String s = null;
        String id = null;
        FileReader fileReader=null;
        List<String> list = new ArrayList<>();
        File f2 = new File("E:/test.txt");

        try {
            // 读取“ids1.txt”文件
            fileReader = new FileReader(f2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((s = bufferedReader.readLine()) != null) {
                list.add(s);
            }
            System.out.println("<><><><><<<<<<<<<<bufferedWriter<<<<<<<<<<<<<<<<<<<<<"+list);



            // 关闭流
            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        String str = null;
        FileReader fileReader=null;
        String apiurl = null;
        List<String> list = new ArrayList<>();
        File f2 = new File("E:/test.txt");

        try {
            // 读取“ids1.txt”文件
            fileReader = new FileReader(f2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null) {
                list.add(str);
            }

            String s = "3";
            for (int i=0;i<list.size();i++){
                System.out.println("listtttttttttttttttttttttttt====="+list);
                apiurl = "http://api.xingliannong.com/api/v1/transactions?asset_id=" + list.get(Integer.parseInt(s) - 1);
                break;
            }

            //System.out.println("<><><><><<<<<<<<<<bufferedWriter<<<<<<<<<<<<<<<<<<<<<"+list.get(Integer.parseInt(s))+" "+list.get(1));

            /*String apiurl = "http://api.xingliannong.com/api/v1/transactions?asset_id="+list.get(Integer.parseInt(s)-1);*/
            //System.out.println("<><><><><<<<<<<<<<bufferedWriter<<<<<<<<<<<<<<<<<<<<<"+list.get(Integer.parseInt(s))+" "+list.get(1));
            System.out.println(apiurl);
            // 关闭流
            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }






}
