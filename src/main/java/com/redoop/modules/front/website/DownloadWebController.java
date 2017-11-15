package com.redoop.modules.front.website;

import com.redoop.common.exception.SystemException;
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

/**
 * 官网Controller
 */
@Controller
@RequestMapping(value = "/front")
public class DownloadWebController {

    @Autowired
    private DownloadService downloadService;
    @Autowired
    private ProductService productService;

    private void setStyle(Model model,String state){

        model.addAttribute("download","");  //产品资料

        model.addAttribute(state,"on");
    }

    /**
     * 产品资料
     * @param model
     * @return
     */
    @GetMapping(value = "/download")
    public String download(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model,
                           @RequestParam(value ="producttype",defaultValue = "0") String producttype) {
        Page<Product> pageList= productService.byProducttype(producttype,page);
        model.addAttribute("pageList", pageList);

        model.addAttribute("producttype",producttype);
        model.addAttribute("url","/front/download?producttype=" + producttype + "&");

        setStyle(model,"download");
        return "front/website/productinformation";
    }

    /**
     * 产品资料下载次数
     * @param id
     * @return
     * @throws SystemException
     */
    @ResponseBody
    @RequestMapping(value = "/download/addProductCount/{id}", method = RequestMethod.POST)
    public boolean addProductCount(@PathVariable(value = "id") String id) throws SystemException {
        int i=productService.addProductCount(id);
        if (i>0){
            return true;
        }
        return false;
    }



}