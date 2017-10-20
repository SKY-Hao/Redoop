package com.redoop.modules.admin.partner.web;

import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.partner.entity.Partner;
import com.redoop.modules.admin.partner.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：合作伙伴Web层
 * 包名：cn.itweet.modules.admin.partner.web
 * 项目名：License-Admin
 * 创建人：黄天浩
 * 创建时间：2017年9月7日17:04:25
 */
@Controller
@RequestMapping(value = "/admin/partner")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    /**
     * 合作伙伴列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        Page<Partner> pageList = partnerService.findAll(page);
        model.addAttribute("pageList", pageList);
        model.addAttribute("url","/admin/partner/findAll?");
        return "admin/partner/list";
    }


    /**
     * 按公司名称查询
     * @param companyname
     * @param mode
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(@RequestParam String companyname,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,Model mode) {

        Page<Partner> pageList = partnerService.select(page,"%" + companyname + "%");
        mode.addAttribute("pageList",pageList);
        mode.addAttribute("url","/admin/partner/select?companyname=" + companyname + "&");
        mode.addAttribute("companyname",companyname);

        return "admin/partner/list";
    }
    /**
     * 合作伙伴详情
     * @param mode
     * @return
     */
    @RequestMapping(value = "/detailed", method = RequestMethod.GET)
    public String detailed(Model mode) {
       /* List<Partner> list = partnerService.list();
        mode.addAttribute("list", list);*/
        return "admin/partner/detailed";
    }

    @RequestMapping(value = "/detailed/{id}", method = RequestMethod.GET)
    public String detailed1(@PathVariable String id,Model model) {
        Partner partner = partnerService.findById(id);
        model.addAttribute("form", partner);
        return "admin/partner/detailed";
    }

    /**
     * 合作伙伴添加页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String form(@PathVariable String id, Model model) {
        if(id != null){
            Partner partner = partnerService.findById(id);
            model.addAttribute("form", partner);
        }
        return "admin/partner/form";
    }

    /**
     * 根据公司名称 进行查询公司信息
     * @param companyname
     * @param model
     * @return
     */
    @RequestMapping(value = "/findByComName/{companyname}", method = RequestMethod.GET)
    public String findByComName(@PathVariable String companyname,Model model){
        Partner partner = partnerService.findByComName(companyname);
            model.addAttribute("partner", partner);
        return "admin/partner/list";
    }


    /**
     * 合作伙伴信息添加（修改）
     * @param mode
     * @param partner
     * @param request
     * @param redirectAttributes
     * @param attach
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(Model mode, Partner partner, HttpServletRequest request,
                       RedirectAttributes redirectAttributes,
                       @RequestParam(value = "logo", required = false) MultipartFile attach) {
        try {
            request.setCharacterEncoding( "utf-8" );
            String logoPath = request.getSession().getServletContext().getRealPath("/");

            partnerService.save(partner,attach,logoPath);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"合作伙伴信息保存成功\")</script>");
            return "redirect:/admin/partner/findAll";
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", partner);
            return "admin/partner/form";
        }
    }

    /**
     * 删除信息
     * @param id
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id,HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            String logoPath = request.getSession().getServletContext().getRealPath("/");
            Partner partner = partnerService.findById(id);
            partnerService.delete(id);
            DeleteUtils.deletePic(logoPath + partner.getCompanypic());
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"合作伙伴信息删除成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/partner/findAll";
    }

    /**
     * 认证（未认证）认证通过是0    未认证是1
     * @param id
     * @param mode
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/authenticationWRZ/{id}", method = RequestMethod.GET)
    public String auditoresultWSH(@PathVariable String id, Model mode, RedirectAttributes redirectAttributes) {
        try {
            partnerService.authenticationWRZ(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"用户认证通过\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/partner/findAll";
    }

    /**
     *认证（未认证）认证通过是0    未认证是1
     * @param id
     * @param mode
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/authenticationYRZ/{id}", method = RequestMethod.GET)
    public String auditoresultYSH(@PathVariable String id, Model mode, RedirectAttributes redirectAttributes) {
        try {
            partnerService.authenticationYRZ(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"取消本公司认证\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/partner/findAll";
    }


}
