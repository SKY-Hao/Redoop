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
public class ProducWebController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SolutionService solutionService;

    private void setStyle(Model model,String state){
        model.addAttribute("product","");   //产品

        model.addAttribute(state,"on");
    }


    /**
     * 产品（临时）
     * @param model
     * @return
     */
    @GetMapping(value = "/products")
    public String product(Model model) {
        List<Solution> solutionList2=solutionService.listByName2();
        model.addAttribute("solutionList2",solutionList2);
        setStyle(model,"product");
        return "front/website/product";
    }





}