package com.redoop.modules.admin.solution.web;


import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.service.MessService;
import com.redoop.modules.admin.solution.entity.Solution;
import com.redoop.modules.admin.solution.service.SolutionService;
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
import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * 说明：方案及案例Controller层
 * 包名：cn.itweet.modules.admin.solution
 * 项目名：itweet-boot
 * 创建人:黄天浩
 * 创建时间：2017年10月16日16:20:47
 */
@Controller
@RequestMapping(value = "/admin/solution")
public class SolutionController {

    @Autowired
    private SolutionService solutionService;

    @Autowired
    private MessService messService;

    /**
     * 方案及案例列表
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        Page<Solution> pageList = solutionService.findAll(page);

        model.addAttribute("pageList", pageList);
        model.addAttribute("url","/admin/solution/findAll?");
        return "admin/solution/list";
    }

    /**
     * 去方案及案例添加||修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String form(@PathVariable String id, Model model) {
        if(id != null){
            Solution solution = solutionService.findById(id);

            model.addAttribute("form", solution);
        }
        return "admin/solution/form";
    }

    /**
     * 添加|修改save
     * @param mode
     * @param solution
     * @param request
     * @param redirectAttributes
     * @param attach
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(Model mode, Solution solution, HttpServletRequest request,
                       RedirectAttributes redirectAttributes,
                       @RequestParam(value = "logo", required = false) MultipartFile attach) {
        try {
            request.setCharacterEncoding( "utf-8" );
            String logoPath = request.getSession().getServletContext().getRealPath("/");

            solutionService.save(solution,attach,logoPath);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"方案及案例信息保存成功\")</script>");
            return "redirect:/admin/solution/findAll";
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", solution);
            return "admin/solution/form";
        }
    }

    /**
     * 按方案和案例查询
     * @param name
     * @param page
     * @param mode
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(@RequestParam String name,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,Model mode) {

        Page<Solution> pageList = solutionService.select(page,"%" + name + "%");
        mode.addAttribute("pageList",pageList);
        mode.addAttribute("url","/admin/solution/select?name=" + name + "&");
        mode.addAttribute("name",name);

        return "admin/solution/list";
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
            Solution solution = solutionService.findById(id);
            solutionService.delete(id);
            DeleteUtils.deletePic(logoPath + solution.getSolutionpic());
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"信息删除成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/solution/findAll";
    }

    /**
     * 发布 (0:展示 1:不展示)
     * @param id
     * @param mode
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/affirm/{id}", method = RequestMethod.GET)
    public String affirm(@PathVariable String id, Model mode,
                         RedirectAttributes redirectAttributes, Mess mess,
                         HttpServletRequest request) {

        //获取域名
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();


        Solution solution = solutionService.findById(id);
        solution.setState(0);
        try {
            mess.setTableid(solution.getId());
            mess.setJumpurl(tempContextUrl+"front/solutiondetail/"+mess.getTableid());

            solutionService.save(solution,mess);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"发布成功\")</script>");
            System.out.println("jumpUrl====="+mess.getJumpurl());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/solution/findAll";
    }

    /**
     * 取消发布
     * @param id
     * @param mode
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/abolish/{id}", method = RequestMethod.GET)
    public String abolish(@PathVariable String id, Model mode, RedirectAttributes redirectAttributes) {

        try {
            solutionService.updateState(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"已取消发布\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/solution/findAll";
    }



}


