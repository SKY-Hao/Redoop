package com.redoop.modules.admin.product.web;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.partner.entity.Partner;
import com.redoop.modules.admin.product.entity.Product;
import com.redoop.modules.admin.product.service.ProductService;
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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：产品资料Web层
 * 包名：cn.itweet.tea.admin.product.web
 * 项目名：License-Admin
 * 创建人：黄天浩
 * 创建时间：2017年9月22日10:28:37
 */
@Controller
@RequestMapping(value = "/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private TagService tagService;

    /**
     * 产品资料列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        Page<Product> pageList  = productService.findAll(page);
        model.addAttribute("pageList", pageList);
        model.addAttribute("url","/admin/product/findAll?");

        return "admin/product/list";
    }


    /**
     * 按平台类型查询
     * @param producttype
     * @param mode
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(@RequestParam String producttype,@RequestParam(value = "page", defaultValue = "0") Integer page, Model mode) {
        Page<Product> pageList = productService.select(page,"%" + producttype + "%");
        mode.addAttribute("pageList", pageList);
        mode.addAttribute("url","admin/product/select?producttype=" + producttype + "&");
        mode.addAttribute("producttype",producttype);
        return "admin/product/list";
    }


    /**
     * 查看详细信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/detailed/{id}", method = RequestMethod.GET)
    public String detailed1(@PathVariable String id,Model model) {
        Product product = productService.findById(id);
        model.addAttribute("form", product);
        return "admin/product/detailed";
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
            Product product = productService.findById(id);
            model.addAttribute("form", product);
           /* List<Tag> tagList= tagService.list();
            model.addAttribute("tagList",tagList);*/
        }


        return "admin/product/form";
    }


    /**
     *产品资料添加(修改)
     * @param mode
     * @param product
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(Model mode, Product product,RedirectAttributes redirectAttributes,Mess mess) {
        try {
            if(product.getId()!=null){
                String productcount=productService.byCount(product.getId());
                product.setProductcount(Integer.parseInt(productcount));
            }

            productService.save(product,mess);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"产品资料信息保存成功\")</script>");
            return "redirect:/admin/product/findAll";
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", product);
            return "admin/product/form";
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
            Product product = productService.findById(id);
            productService.delete(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"CRH&AI下载信息删除成功\")</script>");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/product/findAll";
    }

    /**
     * 发布
     * @return
     */
    @RequestMapping(value = "/cancelRelease/{id}",method = RequestMethod.GET)
    public String cancelRelease(@PathVariable String id, RedirectAttributes redirectAttributes,
                                Mess mess, HttpServletRequest request) {
        //获取域名
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();

        Product product = productService.findById(id);
        product.setProtype("0");
        try {
            mess.setTableid(product.getId());
            mess.setJumpurl(product.getProducturl());
            productService.saveFB(product,mess);

            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"发布成功\")</script>");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/product/findAll";
    }

    /**
     * 取消发布
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/release/{id}",method = RequestMethod.GET)
    public String release(@PathVariable String id,RedirectAttributes redirectAttributes) {
       /* Product product = productService.findById(id);
        product.setProtype("1");*/
        try {
            productService.updateProtype(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"已取消发布\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/product/findAll";
    }







}
