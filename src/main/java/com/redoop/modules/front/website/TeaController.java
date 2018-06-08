package com.redoop.modules.front.website;

import ch.qos.logback.core.net.SyslogOutputStream;
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
import javax.sound.midi.Soundbank;
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

        /*//事实天气获取
       //String city = "安顺";
        String apiUrl = String.format("https://api.seniverse.com/v3/weather/daily.json?key=b4nrjv2g8jngkoc8&location=anshun&language=zh-Hans&unit=c&start=0&days=5");
        //System.out.println("apiUrl======="+apiUrl);
        //开始请求
        URL url= new URL(apiUrl);
        URLConnection open = url.openConnection();
        InputStream input = open.getInputStream();
        ///这里转换为String，
        String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");
*/


        //域名
        StringBuffer stringBuffer = request.getRequestURL();
        String tempContextUrl = stringBuffer.delete(stringBuffer.length() - request.getRequestURI().length(), stringBuffer.length()).append("/").toString();


        Tea tea = teaServce.findById(id);
        //tea.setWeather(result);//事实天气
        //System.out.println("result==="+result);

        //解析时间
        String date = tea.getDate().toString();
        String time=null;
        if(date.length() > 10){

            date = date.substring(0,10);
            time = date.substring(0,10);
        }
        tea.setDate(time);


    /*    String image =tempContextUrl + tea.getImg();
        tea.setImg(image);


        //晚上天气图片
        String imgnightone = tempContextUrl + tea.getImgnightone();
        String imgnighttwo = tempContextUrl + tea.getImgnighttwo();
        String imgnightthen = tempContextUrl + tea.getImgnightthen();
        String imgnightfour = tempContextUrl + tea.getImgnightfour();
        String imgnightfive = tempContextUrl + tea.getImgnightfive();
        tea.setImgnightone(imgnightone);
        tea.setImgnighttwo(imgnighttwo);
        tea.setImgnightthen(imgnightthen);
        tea.setImgnightfour(imgnightfour);
        tea.setImgnightfive(imgnightfive);

        //早上图片
        String imgone = tempContextUrl + tea.getImgone();
        String imgtwo = tempContextUrl + tea.getImgtwo();
        String imgthen = tempContextUrl + tea.getImgthen();
        String imgfour = tempContextUrl + tea.getImgfour();
        String imgfive = tempContextUrl + tea.getImgfive();
        tea.setImgone(imgone);
        tea.setImgtwo(imgtwo);
        tea.setImgthen(imgthen);
        tea.setImgfour(imgfour);
        tea.setImgfive(imgfive);


        //图片路径
        String thenbest = tempContextUrl + tea.getThenbest();
        tea.setThenbest(thenbest);*/


        // 读文件  ids.txt
        // 将文件内容保存为一个dict


        // 根据tea.getId()查询 dict，得到对应的 区块链id
        // 使用区块链api和区块链id查询区块链数据
        // 区块链api: http://api.xingliannong.com/api/v1/transactions?asset_id={id}

        String  ontThrees="59";
        String  ontFours="55";
        String  ontSixs="52";
        String  ontFives="51";
        String  ontSix="50";
        String  ontFive="49";
        String  ontTwos="48";
        String  ontFour="47";
        String oneId= "45";
        String oneIds= "44";
        String  ontThree="43";
        String  ontTwo="42";

        if(tea.getId().equals(oneId)){
            tea.setId("40285c815fa35a0b015fa37132fd0001");
        }else
        if(tea.getId().equals(ontTwo)){
            tea.setId("40288142632a6a6d01632a8c34810000");
        }else
        if(tea.getId().equals(ontThree)){
            tea.setId("297ef02f615477c00161547c9bb30004");
        }else
        if(tea.getId().equals(ontFour)){
            tea.setId("40285c815f5bb8c0015f5bbe3d6d0002");
        }else
        if(tea.getId().equals(ontFive)){
            tea.setId("40285c815f37c662015f384172110008");
        }else
        if(tea.getId().equals(ontSix)){
            tea.setId("40285c815f57c38e015f57c4c8a10000");
        } else
        if(tea.getId().equals(oneIds)){
            tea.setId("40285c815fa35a0b015fa37132fd0f01");
        }else
        if(tea.getId().equals(ontTwos)){
            tea.setId("40288142632a6a6d01632a8c34810g00");
        }else
        if(tea.getId().equals(ontThrees)){
            tea.setId("297ef02f615477c00161547c9bb30hg4");
        }else
        if(tea.getId().equals(ontFours)){
            tea.setId("40285c815f5bb8c0015f5bbe3d6d0r02");
        }else
        if(tea.getId().equals(ontFives)){
            tea.setId("40285c815f37c662015f384172110w08");
        }else
        if(tea.getId().equals(ontSixs)){
            tea.setId("40285c815f57c38e015f57c4c8aer000");
        }

        model.addAttribute("tea",tea);
        System.out.println("tea======"+tea);

        JSONObject js = JSONObject.fromObject(model);


        return js;

    }
}
