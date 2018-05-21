package com.redoop.modules.front.website;

import com.redoop.modules.admin.tea.entity.Tea;
import com.redoop.modules.admin.tea.service.TeaServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
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
    @RequestMapping("/teaIndex")
    @ResponseBody
    public List<Tea> index() {


        List<Tea> list =  teaServce.list();

        System.out.println(list);

        return list;
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String findById(@PathVariable String id, Model model) throws Exception {

        //String city = "安顺";
        String apiUrl = String.format("https://api.seniverse.com/v3/weather/daily.json?key=b4nrjv2g8jngkoc8&location=anshun&language=zh-Hans&unit=c&start=0&days=5");
        System.out.println("apiUrl======="+apiUrl);
        //开始请求
        URL url= new URL(apiUrl);
        URLConnection open = url.openConnection();
        InputStream input = open.getInputStream();
        ///这里转换为String，
        String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");

        Tea tea = teaServce.findById(id);

        tea.setWeather(result);
        System.out.println("result==="+result);
        model.addAttribute("tea",tea);
        System.out.println("tea======"+tea);

        return String.valueOf(model);

    }
}
