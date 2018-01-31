package com.redoop.modules.front.website;

import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.IpUtilS;
import com.redoop.modules.admin.customer.entity.Customer;
import com.redoop.modules.admin.customer.service.CustomerService;
import com.redoop.modules.admin.download.service.DownloadService;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.news.service.NewService;
import com.redoop.modules.admin.product.entity.Product;
import com.redoop.modules.admin.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 产品资料
 * 2018年1月31日10:31:02
 */
@Controller
@RequestMapping(value = "/front")
public class DownloadWebController {

    @Autowired
    private DownloadService downloadService;
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;
    private void setStyle(Model model,String state){

        model.addAttribute("productinformation","");  //产品资料

        model.addAttribute(state,"on");
    }

    /**
     * 产品资料
     * @param model
     * @return
     */
    @GetMapping(value = "/productinformation")
    public String download(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model,
                           @RequestParam(value ="producttype",defaultValue = "1") String producttype) {
        Page<Product> pageList= productService.byProducttype(producttype,page);
        model.addAttribute("pageList", pageList);

        model.addAttribute("producttype",producttype);
        model.addAttribute("url","/front/download?producttype=" + producttype + "&");

        setStyle(model,"productinformation");
        return "front/website/productinformation";
    }

    /**
     * 产品资料下载次数
     * @return
     * @throws SystemException
     */
    @ResponseBody
    @RequestMapping(value = "/productinformation/addProductCount/{id}", method = RequestMethod.POST)
    public int addProductCount(@PathVariable(value = "id") String id,Customer customer,HttpServletRequest request) throws SystemException {
        //0:没有获取到用户IP,让用户填写信息,并获取IP   1:获取到IP,数据库并有这个IP     2.下载失败


        int s= customerService.findByIP(customer,request);

        System.out.println("s==========="+s);

        if (s == 0){     // 0:没有获取到用户IP,让用户填写信息,并获取IP
            return 0;
        }else
        if(s==1){       //1:获取到IP,数据库并有这个IP
            productService.addProductCount(id);

            return 1;
        }
        return 2;
    }

    /**
     * 保存客户信息
     * @param customer
     * @param mode
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/productinformation/saveCustomer", method = RequestMethod.POST)
    public Boolean saveUser(Customer customer, Model mode, HttpServletRequest request){
      if(customer!=null){
          customerService.saveCustomer(customer,request) ;
      }
      return true;
    }




}