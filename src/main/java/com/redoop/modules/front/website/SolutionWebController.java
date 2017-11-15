package com.redoop.modules.front.website;

import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.news.service.NewService;
import com.redoop.modules.admin.solution.entity.Solution;
import com.redoop.modules.admin.solution.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 官网Controller
 */
@Controller
@RequestMapping(value = "/front")
public class SolutionWebController {
    @Autowired
    private SolutionService solutionService;

    private void setStyle(Model model,String state){

        model.addAttribute("solution","");  //行业版本 案例

        model.addAttribute(state,"on");
    }


    /**
     * 方案和案例首页
     * @param model
     * @return
     */
    @GetMapping(value = "/solution")
    public String casePolice(Model model) {
        List<Solution> solutionList=solutionService.listByName();
        model.addAttribute("solutionList",solutionList);

        List<Solution> solutionList2=solutionService.listByName2();
        model.addAttribute("solutionList2",solutionList2);
        setStyle(model,"solution");
        return "front/website/solution";
    }

    /**
     * 方案|案例详情页
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/solutiondetail/{id}",method = RequestMethod.GET)
    public String onesolution(@PathVariable String id,Model model) {
        Solution solutiondetail = solutionService.findById(id);
        model.addAttribute("solutiondetail",solutiondetail);
        setStyle(model,"solution");
        return "front/website/solutiondetail";
    }

}