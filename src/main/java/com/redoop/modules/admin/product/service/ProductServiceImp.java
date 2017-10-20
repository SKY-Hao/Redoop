package com.redoop.modules.admin.product.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.modules.admin.product.entity.Product;
import com.redoop.modules.admin.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ConfigProperties configProperties;
    /**
     * 产品资料下载列表
     * @return
     */
    public Page<Product> findAll(Integer page) {
        return productRepository.findAll(BasePageBuilder.create(page,configProperties.getPageSize()));
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
       /* if (product.getProducttime() == null || "".equals(product.getProducttime())) {
            throw new SystemException("<script>toastr.error(\"文档发布时间不能为空\")</script>");
        }*/

        if(product.getId() != null){
            Product data_c = productRepository.findOne(product.getId());//id
            product.setProductauthor(data_c.getProductauthor());//添加作者

        }else{
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            product.setProductauthor(user.getUsername());
        }

        productRepository.save(product);
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
        return productRepository.byProducttype(producttype,BasePageBuilder.create(page,configProperties.getPageSize()));
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


}
