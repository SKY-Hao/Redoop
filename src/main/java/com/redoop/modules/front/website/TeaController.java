package com.redoop.modules.front.website;

import com.redoop.modules.admin.tea.entity.Tea;
import com.redoop.modules.admin.tea.service.TeaServce;
import net.sf.json.JSONArray;
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
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */
@Controller
@RequestMapping(value = "/xingliannong")
public class TeaController {


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
    public String findById(@PathVariable String id, Model model, HttpServletRequest request) throws Exception {

        String str = null;
        String apiurl = null;
        FileReader fileReader = null;
        List<String> list = new ArrayList<>();
        //文件路径
       // File f2 = new File("/home/wordpress/redoop/xingliannong/dataId/test.txt");
        File f2 = new File("E:/test.txt");

        try {
            // 读取“ids.txt”文件
            fileReader = new FileReader(f2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null) {
                list.add(str);
            }
            String s = id;
            for (int i=0;i<list.size();i++){
                apiurl = "http://api.xingliannong.com/api/v1/transactions?asset_id=" + list.get(Integer.parseInt(s) - 1);
                break;
            }
            // 关闭流
            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        InputStream is = new URL(apiurl).openStream();
       // System.out.println("is>>>>>>>>>>>>>>>>>"+is);
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return jsonText;
        } finally {
            is.close();
        }
    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
       // System.out.println("sasasasa>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sb.toString());

        return sb.toString();
    }


}

