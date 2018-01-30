package com.redoop.modules.front.website;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.download.service.DownloadService;
import com.redoop.modules.admin.mess.entity.Mess;
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
public class CRHWebController {

    @Autowired
    private DownloadService downloadService;

    private void setStyle(Model model,String state){

        model.addAttribute("redoopCRH",""); //CRH
        model.addAttribute("redoopAD","");
        model.addAttribute(state,"on");
    }

    /**
     * 下载CRH
     * @param model
     * @return
     */
    @GetMapping(value = "/redoopCRH")
    public String redoopCRH(Model model,@RequestParam(value ="platformtype",defaultValue = "0") String platformtype,
                            Download download) throws Exception {

        List<Download> list = downloadService.listByDocumenttype(platformtype);

        model.addAttribute("list", list);

        model.addAttribute("platformtype",platformtype);

        setStyle(model,"redoopCRH");
        return "front/website/redoopCRH";
    }




    /**
     * CRH前端查看log
     * @return
     * @throws SystemException
     */
    @RequestMapping(value = "/byCRH/{id}", method = RequestMethod.GET)
    public String addDocumenCount(@PathVariable String id, Download markDown, Mess mess, Model model){

        markDown = downloadService.findMarkDownId(id);
        model.addAttribute("markDown",markDown);
        setStyle(model,"redoopCRH");

        return "front/website/crhMakeDown";
    }



    /**
     * 修改点击次数
     * @param id
     * @return
     * @throws SystemException
     */
    @ResponseBody
    @RequestMapping(value = "/redoopCRH/addDocumenCount/{id}", method = RequestMethod.POST)
    public boolean addDocumenCount(@PathVariable(value = "id") String id) throws SystemException {
        int i=downloadService.addDocumenCount(id);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }





}