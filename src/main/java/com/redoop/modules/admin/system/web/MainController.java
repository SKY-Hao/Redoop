package com.redoop.modules.admin.system.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

/**
 * 说明： 系统后台框架Controller
 * 包名：cn.itweet.modules.admin.system
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/13.
 */
@Controller
public class MainController {

    /**
     * 后台Main
     * @param model
     * @return
     */
    @GetMapping(value = "/admin")
    public String main(Map<String, Object> model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("----------->"+username+"<-----------");
        return "admin/system/main";
    }

    /**
     * 前台主页
     * @param model
     * @return
     */
    @GetMapping(value = "/")
    public String front(Map<String, Object> model) {
        return "front/website/index";
    }

}
