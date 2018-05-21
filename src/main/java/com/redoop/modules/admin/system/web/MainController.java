package com.redoop.modules.admin.system.web;

import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.service.MessService;
import com.redoop.modules.admin.messbriefing.entity.Briefing;
import com.redoop.modules.admin.messbriefing.service.MessbriefingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * 说明： 系统后台框架Controller
 * 包名：cn.itweet.tea.admin.system
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/13.
 */
@Controller
public class MainController {
    @Autowired
    private MessbriefingService messbriefingService;
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
    public String front(Map<String, Object> model,Model m) {

        //官网首页显示最近两条信息
        List<Briefing> briefingList= messbriefingService.twoList();
        m.addAttribute("briefingList",briefingList);

        return "front/website/index";
    }

}
