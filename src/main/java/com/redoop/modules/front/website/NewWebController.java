package com.redoop.modules.front.website;

import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.component.entity.Component;
import com.redoop.modules.admin.component.service.ComponentService;
import com.redoop.modules.admin.customer.entity.Customer;
import com.redoop.modules.admin.customer.service.CustomerService;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.download.service.DownloadService;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.messbriefing.entity.Briefing;
import com.redoop.modules.admin.messbriefing.service.MessbriefingService;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.news.service.NewService;
import com.redoop.modules.admin.partner.entity.Partner;
import com.redoop.modules.admin.partner.service.PartnerService;
import com.redoop.modules.admin.product.entity.Product;
import com.redoop.modules.admin.product.service.ProductService;
import com.redoop.modules.admin.solution.entity.Solution;
import com.redoop.modules.admin.solution.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 官网Controller
 */
@Controller
@RequestMapping(value = "/front")
public class NewWebController {
    @Autowired
    private NewService newService;


    private void setStyle(Model model,String state){

        model.addAttribute("news","");      //新闻

        model.addAttribute(state,"on");
    }


    /**
     * 官网新闻首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/news",method = RequestMethod.GET)
    public String news(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {

        Page<News> pageList = newService.listByState(page);

        model.addAttribute("pageList",pageList);
        model.addAttribute("url","front/news?");

        setStyle(model,"news");
        return "front/website/news";
    }

    /**
     * 新闻详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/onenew/{id}",method = RequestMethod.GET)
    public String onenew(@PathVariable String id,Model model) {
        News onenew = newService.findById(id);
        model.addAttribute("onenew",onenew);
        setStyle(model,"news");
        return "front/website/onenew";
    }


}