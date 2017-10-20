package com.redoop.modules.admin.system.web;

import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.modules.admin.system.entity.Picture;
import com.redoop.modules.admin.system.entity.Tag;
import com.redoop.modules.admin.system.service.PictureService;
import com.redoop.modules.admin.system.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 说明：系统图片Controller层
 * 包名：cn.itweet.modules.admin.system.picture.web
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/16.
 */
@Controller
@RequestMapping(value = "/admin/system/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;
    @Autowired
    private TagService tagService;

    /**
     * 系统图片列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Picture> list = pictureService.list();
        model.addAttribute("list", list);

        List<String> types = pictureService.findType();
        model.addAttribute("types",types);

        return "admin/system/picture_list";
    }

    /**
     * 系统图片编辑页面
     *
     * @return
     */
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String form(@PathVariable String id, Model model) {
        if(id != null){
            Picture picture = pictureService.findById(id);
            model.addAttribute("form", picture);
        }

        List<Tag> tags = tagService.findByType("component_type");
        model.addAttribute("tags",tags);

        return "admin/system/picture_form";
    }

    /**
     * 图片保存
     * @param mode
     * @param picture
     * @param request
     * @param redirectAttributes
     * @param attach
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model mode, Picture picture, HttpServletRequest request,
                       RedirectAttributes redirectAttributes,
                       @RequestParam(value = "logo", required = false) MultipartFile attach) {

        try {
            request.setCharacterEncoding( "utf-8" );
            String logoPath = request.getSession().getServletContext().getRealPath("/");

            pictureService.save(picture,attach,logoPath);

            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"图片保存成功\")</script>");
            return "redirect:/admin/system/picture/list";
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", picture);
            return "admin/system/picture/form";
        }
    }

    /**
     * 系统图片按ID删除
     *
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(HttpServletRequest request,@PathVariable String id, RedirectAttributes redirectAttributes) {

        try {
            String logoPath = request.getSession().getServletContext().getRealPath("/");
            Picture picture = pictureService.findById(id);
            pictureService.delete(id);
            DeleteUtils.deletePic(logoPath + picture.getUrl());
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"图片文件删除成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/admin/system/picture/list";
    }

    /**
     * 移动分组
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/move", method = RequestMethod.POST)
    public String move(RedirectAttributes redirectAttributes,@RequestParam("id") String id,@RequestParam("type") String type) {
        Picture picture = pictureService.findById(id);
        picture.setType(type);

        pictureService.save(picture);
        redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"图片移动分组成功\")</script>");
        return "redirect:/admin/system/picture/list";
    }

}
