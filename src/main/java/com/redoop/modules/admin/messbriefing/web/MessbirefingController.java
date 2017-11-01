package com.redoop.modules.admin.messbriefing.web;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.service.MessService;
import com.redoop.modules.admin.messbriefing.entity.Briefing;
import com.redoop.modules.admin.messbriefing.service.MessbriefingService;
import com.redoop.modules.admin.news.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.text.ParseException;
import java.util.List;

/**
 * 说明：最终简报信息controller
 * 包名：cn.itweet.modules.admin.mess
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间： 2017年10月23日
 */
@Controller
@RequestMapping(value = "/admin/messBriefing")
public class MessbirefingController {

    @Autowired
    private MessbriefingService messbriefingService;

    @Autowired
    private MessService messService;


    /**
     * 生成最终简报保存
     * @param mode
     * @param briefing
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/lastAdd", method = RequestMethod.POST)
    public String lastAdd(String[] ids, Model mode,
                          Briefing briefing,Mess mess, HttpServletRequest request,
                          RedirectAttributes redirectAttributes) {
        try {

            messbriefingService.lastAdd(briefing,ids);
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"最终简报保存成功\")</script>");
            return "redirect:/admin/mess/briefing";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "<script>toastr.success(\"请选择至少一项生成\")</script>");
            return "redirect:/admin/mess/briefing";
        }
    }


    /**
     * 最终简报表（前端用）
     * @param model
     * @return
     */
    @RequestMapping(value = "/last",method = RequestMethod.GET)
    public String last(Model model){
        List<Briefing> list= messbriefingService.briefingList();
        model.addAttribute("list",list);
        return "admin/mess/lastList";
    }





}
