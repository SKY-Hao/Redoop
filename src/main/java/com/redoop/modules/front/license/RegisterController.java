package com.redoop.modules.front.license;

import com.redoop.modules.admin.license.entity.License;
import com.redoop.modules.admin.license.service.LicenseService;
import com.redoop.modules.admin.license.utils.Message;
import com.redoop.modules.admin.license.utils.UuidUtils;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;

/**
 * 说明：license注册Controller层
 * 包名：cn.itweet.tea.admin.license
 * 项目名：License-Admin
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
@Controller
@RequestMapping(value = "/front/license")
public class RegisterController {

    @Autowired
    private LicenseService ls;

    /**
     * 选择注册页面
     * @return
     */
    @RequestMapping(value="", method= RequestMethod.GET)
    public String register(){
        return "front/license/register";
    }

    /**
     * 申请试用版页面
     * @return
     */
    @RequestMapping(value="/trial", method= RequestMethod.GET)
    public String registerTrial(){
        return "front/license/trial";
    }

    /**
     * 申请正式版页面
     * @return
     */
    @RequestMapping(value="/formal", method= RequestMethod.GET)
    public String registerFormal(){
        return "front/license/formal";
    }

    /**
     * 申请注册
     * @return
     */
    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String register(License license, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = false) MultipartFile attach, Model model) throws Exception {
        request.setCharacterEncoding( "utf-8" );
        response.setHeader( "Content-Type" , "text/html" );
        String upFilePath = request.getSession().getServletContext().getRealPath("/upload/license/");

        File filePath = new File(upFilePath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }

        String registerFileName = "/" + UuidUtils.getUuid() + ".rif";
        System.out.println("文件："+registerFileName);

        File realFile=new File(upFilePath + registerFileName);
        FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

        if(license.getNode() < 3){
            license.setNode(3);
        }

        Message message = ls.register(license,upFilePath + registerFileName);

        if(message.getCode() != null){
            writeCode(response,message.getCode());
        }

        model.addAttribute("message",message.getMsg());

        if(license.getVersion() == 0){
            model.addAttribute("form",license);
            return "front/license/trial";
        }else{
            model.addAttribute("form",license);
            return "front/license/formal";
        }
    }


    private void writeCode(HttpServletResponse response,String code){
        Gson gson = new Gson();
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + "code.rif");
        try {
            PrintWriter pw = response.getWriter();
            pw.print(code.toString());
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
