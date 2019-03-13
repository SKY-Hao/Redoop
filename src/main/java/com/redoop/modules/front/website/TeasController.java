package com.redoop.modules.front.website;

import com.redoop.modules.admin.tea.entity.Tea;
import com.redoop.modules.admin.tea.service.TeaServce;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */
@Controller
@RequestMapping(value = "/xingliannong")
public class TeasController {


    @Autowired
    private TeaServce teaServce;
    /**
     * 茶叶
     * @return
     */
    @RequestMapping(value = "/teaIndex")
    @ResponseBody
    public List<Tea> index() {
        List<Tea> list =  teaServce.list();
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject findById(@PathVariable String id, Model model, HttpServletRequest request) throws Exception {

        // 读取保存区块链id的文件ids.txt，得到一个ArraryList
        // File file = new File("/home/wordpress/redoop/xingliannong/dataId/ids1.txt");
        File file = new File("ids11.txt");
        // 读取保存区块链id的文件ids.txt，得到一个ArraryList
        //File file = new File("ids1.txt");
        String fileName = file.getAbsolutePath();
        ArrayList ids = readFileByLines(fileName);
        //for(int i=0;i<ids.size();i++) {
        //    System.out.println(ids.get(i));
        //}

        // http://api.xingliannong.com/api/v1/transactions?asset_id=64c6f2c1a68fb8810d5598ae67eb1345fadd226f6ccc1fb17cf98bf032413e7d

        String bcurl = "http://archive.redoop.com:9984/api/v1/transactions?asset_id=" + ids.get(Integer.parseInt(id)-1);
        String json = loadJSON(bcurl);

        // 字符串转json
        JSONObject jsonObj = JSONObject.fromObject(json);
        String asset = jsonObj.getString("asset");
        JSONObject jsonObj2 = JSONObject.fromObject(asset);
        String data = jsonObj2.getString("data");
        JSONObject jsonObj3 = JSONObject.fromObject(data);
        jsonObj3.put("id", ids.get(Integer.parseInt(id)-1));
        jsonObj2.put("tea", jsonObj3);
        jsonObj2.remove("data");
        return jsonObj2;

    }



    public static ArrayList readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        ArrayList ids = new ArrayList();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 将读取的每一行处理后得到的有效内容作为数组元素加入到数组ids中
                ids.add(tempString.split("\\s")[2]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return ids;
    }

    public static String loadJSON(String bcurl) {
        StringBuilder json = new StringBuilder();
        try {
            URL url = new URL(bcurl);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream(),"utf-8"));//防止乱码
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            // 去除第一个 [  和最后一个 ]
            json.delete(0,1);
            json.deleteCharAt(json.length()-1);

            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

        return json.toString();
    }
}