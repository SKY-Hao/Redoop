package com.redoop.modules.front.website;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.customer.entity.Customer;
import com.redoop.modules.admin.customer.service.CustomerService;
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

    @Autowired
    private CustomerService customerService;

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
    public int addDocumenCount(@PathVariable(value = "id") String id,Customer customer,HttpServletRequest request) throws SystemException {

        //0:没有获取到用户IP,让用户填写信息,并获取IP   1:获取到IP,数据库并有这个IP     2.下载失败


        int s= customerService.findByIP(customer,request);

        System.out.println("s==========="+s);

        if (s == 0){     // 0:没有获取到用户IP,让用户填写信息,并获取IP
            return 0;
        }else
        if(s==1){       //1:获取到IP,数据库并有这个IP
            downloadService.addDocumenCount(id);

            return 1;
        }
        return 2;


      /*  int i=downloadService.addDocumenCount(id);
        if (i>0){
            return true;
        }else {
            return false;
        }*/
    }


    /**
     * 保存客户信息
     * @param customer
     * @param mode
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/redoopCRH/saveCustomer", method = RequestMethod.POST)
    public Boolean saveUser(Customer customer, Model mode, HttpServletRequest request){
        if(customer!=null){
            customerService.saveCustomer(customer,request) ;
        }
        return true;
    }



}