package com.redoop.modules.admin.license.web;

import com.google.gson.Gson;
import com.redoop.common.exception.ValidateException;
import com.redoop.modules.admin.component.service.ComponentService;
import com.redoop.modules.admin.license.entity.License;
import com.redoop.modules.admin.license.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * 说明：License Controller
 * 包名：cn.itweet.modules.admin.license
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
@Controller
@RequestMapping(value = "/admin/license")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @Autowired
    private ComponentService componentService;

    /**
     * license授权记录列表
     * @return
     */
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String list(HttpServletRequest request){
        List<License> list = licenseService.list();
        request.setAttribute("licenseNumber",list.size());
        request.setAttribute("list",list);
        return "admin/license/list";
    }

    /**
     * license授权记录删除
     * @param request
     * @return
     */
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id, HttpServletRequest request){
        licenseService.delete(id);
        return "redirect:/admin/license/list";
    }

    /**
     * license授权记录修改页面
     * @param request
     * @return
     */
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, HttpServletRequest request){
        License license = licenseService.getById(id);
        request.setAttribute("form", license);
        return "admin/license/edit";
    }

    /**
     * license授权记录修改
     * @param request
     * @return
     */
    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String edit(License license, HttpServletRequest request){
        try {
            licenseService.edit(license);
        } catch (ValidateException v) {
            request.setAttribute("errorMessage",v.getMessage());
            request.setAttribute("form", license);
            return "admin/license/edit";
        }
        return "redirect:/admin/license/list";
    }

    /**
     * license授权码导出
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/export/{id}", method = RequestMethod.GET)
    public void export(@PathVariable Integer id, HttpServletRequest request,HttpServletResponse response){
        License license = licenseService.getById(id);
        String fileName = license.getCompany().toString();

        try {
            response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(fileName, "UTF-8") + ".rif");
            response.setContentType("multipart/form-data");
            PrintWriter pw = response.getWriter();
            pw.print(license.getCode());
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * license授权记录按公司查询
     * @param request
     * @return
     */
    @RequestMapping(value="/select", method = RequestMethod.POST)
    public String select(HttpServletRequest request){
        String companyName = request.getParameter("companyName");
        System.out.println(companyName);
        List<License> list = licenseService.getByCompany(companyName);
        for(License license :list){
            System.out.println(license.toString());
        }
        request.setAttribute("licenseNumber",list.size());
        request.setAttribute("companyName",companyName);
        request.setAttribute("list",list);
        return "admin/license/list";
    }

    /**
     * license授权页面
     * @param model
     * @return
     */
    @RequestMapping(value="/authorizePage/{id}", method = RequestMethod.GET)
    public String authorizePage(@PathVariable Integer id,Model model){

        //把需要授权的记录查询出来
        License form = licenseService.getById(id);
        model.addAttribute("form",form);

        //把所有组件加载出来
        List<String> list = componentService.findComponentNameList();
        model.addAttribute("list",list);

        return "admin/license/authorize";
    }

    /**
     * license授权
     * @param model
     * @return
     */
    @RequestMapping(value="/authorize", method = RequestMethod.POST)
    public String authorize(License license,Model model){
        try {
            licenseService.authorize(license);
        } catch (ValidateException v) {
            model.addAttribute("errorMessage",v.getMessage());
            model.addAttribute("form", license);
            return "admin/license/authorize";
        }
        return "redirect:/admin/license/list";
    }

}
