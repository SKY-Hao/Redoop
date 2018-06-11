package com.redoop.common.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by Administrator on 2018/6/8.
 */
public class FilesUtil {



    public  String getFile(File file) {
        List<String> list = new ArrayList<>();
        String s = null;
        //ids信息中要有数据
        File f1 = new File("E:/ids.txt");
        File f2 = new File("E:/test.txt");

        try {
            // 读取“ids.txt”文件
            FileReader fileReader = new FileReader(f1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((s = bufferedReader.readLine()) != null) {
                list.add(s);
            }

            // 打印list中读到的数据
            System.out.println(list);

            // 写入“test.txt”文件
            FileWriter fileWriter = new FileWriter(f2);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                System.out.println("==============->>>>>>>>>>>>>>>>");
                System.out.println(list.get(i));

                // 截取前5个字符
                bufferedWriter.write(list.get(i),10,65);
                bufferedWriter.newLine();
            }

            // 关闭流
            bufferedReader.close();
            fileReader.close();
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

   /*private List<String> list = new ArrayList<String>();
    private String temp;

    public static void main(String[] args) {
        FilesUtil fileTest = new FilesUtil();
        fileTest.readFile("E:/ids.txt");
        fileTest.printFile("E:/test.txt");
        System.out.println(fileTest.list);
    }

    public void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(new File(fileName));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((temp = bufferedReader.readLine()) != null) {
                list.add(temp);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printFile(String fileName) {

        try {
            FileWriter fileWriter = new FileWriter(new File(fileName));
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                bufWriter.write(list.get(i), 11, 64);//读取前5个字符
                bufWriter.newLine();

            }
            bufWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


}
