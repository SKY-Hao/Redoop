package com.redoop.modules.admin.component.web;

import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.modules.admin.component.entity.Component;
import com.redoop.modules.admin.component.service.ComponentService;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.partner.entity.Partner;
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
import java.util.List;

/**
 * 说明：服务Web层
 * 包名：cn.itweet.tea.admin.component.web
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/13.
 */
@Controller
@RequestMapping(value = "/admin/component")
public class ComponentController {

    @Autowired
    private ComponentService componentService;


    /**
     * 服务软件信息列表
     * @param mode
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,Model mode) {

        Page<Component> pageList = componentService.findAll(page);
        mode.addAttribute("pageList", pageList);
        mode.addAttribute("url","/admin/component/findAll?");


        return "admin/component/list";
    }

    /**
     * 服务软件信息添加页面
     *
     * @return
     */
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String form(@PathVariable String id, Model model) {
        if(id != null){
            Component component = componentService.findById(id);
            model.addAttribute("form", component);
        }
        return "admin/component/form";
    }

    /**
     * 服务软件信息添加
     * @param mode
     * @param component
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(Model mode, Component component, HttpServletRequest request,
                      RedirectAttributes redirectAttributes,
                      @RequestParam(value = "logo", required = false) MultipartFile attach) {
        try {
            request.setCharacterEncoding( "utf-8" );
            String logoPath = request.getSession().getServletContext().getRealPath("/");

            componentService.save(component,attach,logoPath);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"服务软件信息保存成功\")</script>");
            return "redirect:/admin/component/findAll";
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", component);
            return "admin/component/form";
        }
    }

    /**
     * 服务软件信息按ID删除
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id,HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            String logoPath = request.getSession().getServletContext().getRealPath("/");
            Component component = componentService.findById(id);
            componentService.delete(id);
            DeleteUtils.deletePic(logoPath + component.getPicurl());
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"服务软件信息删除成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/component/findAll";
    }

    /**
     * 按照名称模糊查询
     * @param name
     * @param mode
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(@RequestParam String name,@RequestParam(value = "page", defaultValue = "0") Integer page, Model mode) {

        Page<Component> pageList = componentService.selectByName(page,"%" + name + "%");
        mode.addAttribute("pageList", pageList);
        mode.addAttribute("url","/admin/component/select?name=" + name + "&");
        mode.addAttribute("name",name);
        return "admin/component/list";
    }

    /**
     * 发布
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/release/{id}",method = RequestMethod.GET)
    public String release(@PathVariable String id, RedirectAttributes redirectAttributes,
                          Mess mess, HttpServletRequest request) {

        //获取域名
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();

        Component component = componentService.findById(id);
        component.setShowstate(1);
        try {
            mess.setTableid(component.getId());
            mess.setJumpurl(tempContextUrl+"/front/appstore");
            componentService.save(component,mess);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"发布成功\")</script>");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/component/findAll";
    }
    /**
     * 取消发布
     * @return
     */
    @RequestMapping(value = "/cancelRelease/{id}",method = RequestMethod.GET)
    public String cancelRelease(@PathVariable String id,RedirectAttributes redirectAttributes) {
        try {
            componentService.updatedescription(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"取消发布成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/component/findAll";
    }




}
