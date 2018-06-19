package com.redoop.modules.admin.mess.web;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.service.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;


/**
 * 说明：简报信息controller
 * 包名：cn.itweet.tea.admin.mess
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间： 2017年10月23日
 */
@Controller
@RequestMapping(value = "/admin/mess")
public class MessController {

    @Autowired
    private MessService messService;
    /**
     * 分页-全部-查询
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model){
        Page<Mess> pageList = messService.findAll(page);

        //List<Mess> pageList= messService.list();
        model.addAttribute("pageList",pageList);

        //model.addAttribute("url","/admin/mess/findAll?");
        return "admin/mess/list";
    }

    /**
     * 去添加或者修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String form(@PathVariable String id, Model model) {
        if(id != null){
            Mess Mess = messService.findById(id);
            model.addAttribute("form", Mess);
        }
        return "admin/mess/form";
    }

    /**
     * 简报保存
     * @param mode
     * @param mess
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model mode, Mess mess, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            messService.save(mess);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"简报保存成功\")</script>");
            return "redirect:/admin/mess/findAll";
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", mess);
            return "admin/mess/form";
        }
    }

    /**
     * 简报删除
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable String id,RedirectAttributes redirectAttributes) throws SystemException {
        //Mess Mess = messService.findById(id);
        messService.delete(id);
        redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"简报删除成功\")</script>");
        return "redirect:/admin/mess/findAll";
    }



    /**
     * 时间查询
     * @param starttime
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String select(@RequestParam String starttime, @RequestParam String endtime,
                         @RequestParam(value = "page", defaultValue = "0") Integer page, Model model) throws ParseException {

        Page<Mess> pageList = messService.selectByTime(starttime , endtime,page);

        model.addAttribute("pageList",pageList);
        model.addAttribute("url","/admin/mess/select?starttime=" + starttime + endtime + "&");

        model.addAttribute("starttime",starttime);
        model.addAttribute("endtime",endtime);
        return "admin/mess/list";
    }

    /**
     *  简报7天表
     * @param model
     * @return
     */
    @RequestMapping(value = "/briefing",method = RequestMethod.GET)
    public String briefing(Model model){
        List<Mess> list= messService.list();
        model.addAttribute("list",list);
        return "admin/mess/weekList";
    }





}
