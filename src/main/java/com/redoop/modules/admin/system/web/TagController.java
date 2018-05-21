package com.redoop.modules.admin.system.web;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.system.entity.Tag;
import com.redoop.modules.admin.system.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 说明：系统标签管理Controller层
 * 包名：cn.itweet.tea.admin.system.tag.web
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/15.
 */
@Controller
@RequestMapping(value = "/admin/system/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 系统标签列表
     *
     * @param mode
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model mode) {
        List<Tag> list = tagService.list();
        mode.addAttribute("list", list);
        return "admin/system/tag_list";
    }

    /**
     * Form 查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/form/{id}",method = RequestMethod.GET)
    public String form(@PathVariable String id,Model model){
        if(id != null){
            Tag form = tagService.findById(id);
            model.addAttribute("form",form);
        }

        return "admin/system/tag_form";
    }

    /**
     * 标签-保存
     * @param tag
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Tag tag,Model model){

        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            tag.setCreateBy(user.getUsername());
            tagService.save(tag);

            List<Tag> list = tagService.findByType(tag.getType());
            model.addAttribute("list",list);
            model.addAttribute("message", "<script>toastr.success(\"标签添加成功\")</script>");
            return "admin/system/tag_list";
        } catch (SystemException e) {
            model.addAttribute("message", e.getMessage());
            model.addAttribute("form",tag);
        }

        return "admin/system/tag_form";
    }

    /**
     * 系统标签按ID删除
     *
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            tagService.delete(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"系统标签删除成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/system/tag/list";
    }


    /**
     * 系统标签添加页面
     *
     * @return
     */
    @RequestMapping(value = "/addKey/{type}", method = RequestMethod.GET)
    public String addKey(Model mode, @PathVariable String type) {
        Tag tag = new Tag();
        tag.setType(type);
        mode.addAttribute("form", tag);
        return "admin/system/tag_form";
    }

}
