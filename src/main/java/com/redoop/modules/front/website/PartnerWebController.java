package com.redoop.modules.front.website;

import com.redoop.modules.admin.partner.entity.Partner;
import com.redoop.modules.admin.partner.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 官网Controller
 */
@Controller
@RequestMapping(value = "/front")
public class PartnerWebController {

    @Autowired
    private PartnerService partnerService;

    private void setStyle(Model model,String state){

        model.addAttribute("partners","");  //合作伙伴

        model.addAttribute(state,"on");
    }

    /**
     * 合作伙伴
     * @param model
     * @return
     */
    @RequestMapping(value = "/partners",method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        Page<Partner> pageList= partnerService.listByIntention(page);
        model.addAttribute("pageList",pageList);

        model.addAttribute("url","front/partners?");
        setStyle(model,"partners");
        return "front/website/partners";
    }

    /**
     * 前台合作伙伴申请
     * @param mode
     * @param partner
     * @param request
     * @param attach
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/partners/addPartner", method = RequestMethod.POST)
    public boolean addPartner(Model mode, Partner partner, HttpServletRequest request, @RequestParam(value = "logo", required = false) MultipartFile attach) {
        try {
            request.setCharacterEncoding( "utf-8" );
            String logoPath = request.getSession().getServletContext().getRealPath("/");
            partnerService.applySave(partner,attach,logoPath);
            return true;
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", partner);
            return false;
        }
    }
    /**
     * 前台点击图片查询详细信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/partners/findByPicId", method= RequestMethod.GET)
    public Partner findByPicId(Model model, Partner partner,@RequestParam(value = "id") String id)throws Exception{

        partner =partnerService.findById(id);
        model.addAttribute("partner",partner.getAuthentication());
        return partner;
    }


    /**
     * 前台多选搜索(checkbox)
     * @param partnertype
     * @param model
     * @return
     */
    @RequestMapping(value = "/partners/findByPartnertype" ,method = RequestMethod.GET)
    public String select(@RequestParam(value = "partnertype",required = false,defaultValue = "") String partnertype,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,Model model)throws Exception {

        Page<Partner> pageList = partnerService.findByPartnertype(page, partnertype);

        String[] arrs = partnertype.split(",");
        List<String> partnertypeList = new ArrayList<>();
        for(int i = 0;i<arrs.length;i++){
            partnertypeList.add(arrs[i]);
        }
        model.addAttribute("pageList",pageList);
        model.addAttribute("url","front/partners/findByPartnertype?partnertype="+ partnertype + "&");
        model.addAttribute("partnertype",partnertype);
        model.addAttribute("partnertypeList",partnertypeList);

        return "front/website/partners";
    }




}