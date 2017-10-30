package com.redoop.modules.admin.product.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.repository.MessRepository;
import com.redoop.modules.admin.product.entity.Product;
import com.redoop.modules.admin.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 产品资料service
 */

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private MessRepository messRepository;
    private Sort sort = new Sort(Sort.Direction.DESC,"producttime");
    /**
     * 产品资料下载列表
     * @return
     */;
    public Page<Product> findAll(Integer page) {
        return productRepository.findAll(BasePageBuilder.create(page,configProperties.getPageSize(),sort));
    }


    /**
     * 按ID查询
     * @param id
     * @return
     */
    @Override
    public Product findById(String id) {
        return productRepository.findOne(id);
    }

    /**
     * 产品资料下载添加(修改)
     * @param product
     * @throws SystemException
     */
    @Override
    public void save(Product product) throws SystemException {
        if (product.getProducttype() == null || "".equals(product.getProducttype())) {
            throw new SystemException("<script>toastr.error(\"文档类型不能为空\")</script>");
        }
        if (product.getProducturl() == null || "".equals(product.getProducturl())) {
            throw new SystemException("<script>toastr.error(\"文档下载地址不能为空\")</script>");
        }

        if(product.getId() != null){
            Product data_c = productRepository.findOne(product.getId());//id
            product.setProductauthor(data_c.getProductauthor());//添加作者
            product.setProtype(data_c.getProtype());//发布状态

        }else{
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            product.setProductauthor(user.getUsername());
            product.setProtype("1");//发布状态
        }

        productRepository.save(product);
        //保存到简报
        Mess mess = new Mess();
        mess.setAuthortime(new Date());
        mess.setTablename(Product.class.getSimpleName());
        mess.setTableid(product.getId());
        mess.setAuthor(product.getProductauthor());
        mess.setTitle(product.getProductname());
        mess.setOutline(product.getOutline());
        messRepository.save(mess);

    }


    /**
     * 删除信息
     * @param id
     * @throws SystemException
     */
    @Override
    public void delete(String id) throws SystemException {

        productRepository.delete(id);
    }

    /**
     * 后台产品文档查询
     * @param page
     * @param producttype
     * @return
     */
    public Page<Product> select(Integer page, String producttype) {
        return productRepository.findByProducttypeLike(producttype,BasePageBuilder.create(page,configProperties.getPageSize()));
    }

    /**
     * 前台展示
     * @param producttype
     * @param page
     * @return
     */
    public Page<Product> byProducttype(String producttype, Integer page) {
        return productRepository.byProducttype(producttype,BasePageBuilder.create(page,configProperties.getPageSize(),sort));
    }

    /**
     * 产品资料修改下载次数
     * @param id
     * @return
     * @throws SystemException
     */
    @Override
    public int addProductCount(String id) throws SystemException {
        return productRepository.addProductCount(id);
    }

    /**
     * 取消发布
     * @param id
     * @throws SystemException
     */
    @Override
    public void updateProtype(String id) throws SystemException {
        productRepository.updateProtype(id);
    }
}
