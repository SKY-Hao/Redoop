package com.redoop.modules.admin.download.web;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.download.service.DownloadService;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.system.service.TagService;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：RdoopCRH||AI controller
 * 包名：cn.itweet.modules.admin.download.web
 * 项目名：License-Admin
 * 创建人：黄天浩
 * 创建时间：2017年10月25日10:28:37
 */
@Controller
@RequestMapping(value = "/admin/download")
public class DownloadController {

    @Autowired
    private DownloadService downloadService;

    @Autowired
    private TagService tagService;
    @Autowired
    private ConfigProperties configProperties;

    /**
     * CRH&AI下载列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        Page<Download> pageList  = downloadService.findAll(page);
        model.addAttribute("pageList", pageList);
        model.addAttribute("url","/admin/download/findAll?");

        return "admin/download/list";
    }


    /**
     * 按平台类型查询
     * @param producttype
     * @param mode
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(@RequestParam String producttype,@RequestParam(value = "page", defaultValue = "0") Integer page, Model mode) {
        Page<Download> pageList = downloadService.select(page,"%" + producttype + "%");
        mode.addAttribute("pageList", pageList);
        mode.addAttribute("url","admin/download/select?producttype=" + producttype + "&");
        mode.addAttribute("producttype",producttype);
        return "admin/download/list";
    }


    /**
     * 查看详细信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/detailed/{id}", method = RequestMethod.GET)
    public String detailed1(@PathVariable String id,Model model) {
        Download download = downloadService.findById(id);
        model.addAttribute("form", download);
        return "admin/download/detailed";
    }

    /**
     * CRH&AI下载添加(修改)页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String form(@PathVariable String id, Model model) {

        if(id != null){
            Download download = downloadService.findById(id);
            model.addAttribute("form", download);
           /* List<Tag> tagList= tagService.list();
            model.addAttribute("tagList",tagList);*/
        }
        return "admin/download/form";
    }

    /**
     *CRH&AI下载添加(修改)
     * @param mode
     * @param download
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(Model mode, Download download,RedirectAttributes redirectAttributes,HttpServletRequest request,
                        @RequestParam(value = "logo", required = false) MultipartFile[] attachs) {
        try {
            if (download.getId()!=null){
                String i=downloadService.findByCout(download.getId());//获取下载次数不做修改
                download.setDocudowncount(Integer.parseInt(i));
            }
            request.setCharacterEncoding( "utf-8" );
            String logoPath = request.getSession().getServletContext().getRealPath("/");

            downloadService.save(download,attachs,logoPath);

            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"CRH&AI下载信息保存成功\")</script>");
            return "redirect:/admin/download/findAll";
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", download);
            return "admin/download/form";
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
            Download download = downloadService.findById(id);
            downloadService.delete(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"CRH&AI下载信息删除成功\")</script>");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/download/findAll";
    }

    /**
     * 发布
     * @return
     */
    @RequestMapping(value = "/release/{id}",method = RequestMethod.GET)
    public String release(@PathVariable String id, RedirectAttributes redirectAttributes,
                          Mess mess,HttpServletRequest request) {
        //获取域名
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();

        Download download = downloadService.findById(id);
        download.setDocumenttype("0");
        try {
            mess.setTableid(download.getId());
            mess.setJumpurl(tempContextUrl+"front/redoopCRH");
            downloadService.save(download,mess);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"发布成功\")</script>");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/download/findAll";
    }

    /**
     * 取消发布
     * @return
     */
    @RequestMapping(value = "/cancelRelease/{id}",method = RequestMethod.GET)
    public String cancelRelease(@PathVariable String id,RedirectAttributes redirectAttributes) {
        try {
            downloadService.updateDocumenttype(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"取消发布成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/download/findAll";
    }




}
