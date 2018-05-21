package com.redoop.modules.admin.news.web;


import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.service.MessService;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.news.service.NewService;
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

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * 说明：新闻Controller层
 * 包名：cn.itweet.tea.admin.news
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/2.
 */
@Controller
@RequestMapping(value = "/admin/new")
public class NewController {

    @Autowired
    private NewService newService;
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
        Page<News> pageList = newService.findAll(page);
        model.addAttribute("pageList",pageList);

        model.addAttribute("url","/admin/new/findAll?");
        return "admin/new/list";
    }

    /**
     * 新闻表单
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String form(@PathVariable String id, Model model) {
        if(id != null){
            News news = newService.findById(id);
            model.addAttribute("form", news);
        }
        return "admin/new/form";
    }

    /**
     * 新闻保存（有图片附件）
     * @param mode
     * @param news
     * @param request
     * @param redirectAttributes
     * @param attach
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model mode, News news, HttpServletRequest request,
                       RedirectAttributes redirectAttributes,
                       @RequestParam(value = "logo", required = false) MultipartFile attach) {
        try {
            request.setCharacterEncoding( "utf-8" );
            String logoPath = request.getSession().getServletContext().getRealPath("/");
            newService.save(news,attach,logoPath);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"新闻保存成功\")</script>");
            return "redirect:/admin/new/findAll";
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", news);
            return "admin/new/form";
        }
    }

    /**
     * 新闻删除
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable String id,RedirectAttributes redirectAttributes,HttpServletRequest request) {
        String logoPath = request.getSession().getServletContext().getRealPath("/");
        News news = newService.findById(id);
        newService.delete(id);
        DeleteUtils.deletePic(logoPath + news.getPicpath());
        redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"新闻删除成功\")</script>");
        return "redirect:/admin/new/findAll";
    }

    /**
     * 新闻发布
     * @return
     */
    @RequestMapping(value = "/release/{id}",method = RequestMethod.GET)
    public String release(@PathVariable String id,RedirectAttributes redirectAttributes,
                          Mess mess,HttpServletRequest request) {

        //获取域名
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();

        News news = newService.findById(id);
        news.setState(1);
        try {
            mess.setTableid(news.getId());
            mess.setJumpurl(tempContextUrl+"front/onenew/"+mess.getTableid());
            newService.save(news,mess,tempContextUrl);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"新闻发布成功\")</script>");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/new/findAll";
    }

    /**
     * 取消新闻发布
     * @return
     */
    @RequestMapping(value = "/cancelRelease/{id}",method = RequestMethod.GET)
    public String cancelRelease(@PathVariable String id,RedirectAttributes redirectAttributes) {
        //News news = newService.findById(id);
        //news.setState(0);
        try {
            newService.updateState(id);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"新闻取消发布成功\")</script>");
        } catch (SystemException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/new/findAll";
    }

    /**
     * 新闻查询
     * @param model
     * @return
     */
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String select(@RequestParam String title,@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {

        Page<News> pageList = newService.selectByTitle(page,"%" + title + "%");
        model.addAttribute("pageList",pageList);
        model.addAttribute("url","/admin/new/select?title=" + title + "&");
        model.addAttribute("title",title);
        return "admin/new/list";
    }



}


