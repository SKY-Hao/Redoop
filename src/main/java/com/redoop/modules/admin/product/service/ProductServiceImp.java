package com.redoop.modules.admin.product.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.common.utils.IpUtil;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 产品资料service
 */

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private MessRepository messRepository;
    private Sort sort = new Sort(Sort.Direction.DESC, "producttime");
    /**
     * 产品资料下载列表
     * @return
     */
    ;

    public Page<Product> findAll(Integer page) {
        return productRepository.findAll(BasePageBuilder.create(page, configProperties.getPageSize(), sort));
    }


    /**
     * 按ID查询
     *
     * @param id
     * @return
     */
    @Override
    public Product findById(String id) {
        return productRepository.findOne(id);
    }

    /**
     * 产品资料下载添加(修改)
     *
     * @param product
     * @throws SystemException
     */
    @Override
    public void save(Product product, Mess mess) throws Exception {
        if (product.getProducttype() == null || "".equals(product.getProducttype())) {
            throw new SystemException("<script>toastr.error(\"文档类型不能为空\")</script>");
        }
        if (product.getProducturl() == null || "".equals(product.getProducturl())) {
            throw new SystemException("<script>toastr.error(\"文档下载地址不能为空\")</script>");
        }

        if (product.getId() != null) {
            Product data_c = productRepository.findOne(product.getId());//id
            product.setProductauthor(data_c.getProductauthor());//添加作者
            product.setProtype("1");//发布状态0:发布 1:不发布

        } else {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            product.setProductauthor(user.getUsername());
            product.setProtype("1");//发布状态0:发布 1:不发布
        }

        productRepository.save(product);

    }

    /**
     * 发布
     *
     * @param product
     * @param mess
     * @throws Exception
     */
    @Override
    public void saveFB(Product product, Mess mess) throws Exception {
        //调用保存到简报方法
        product = saveMess(product, mess);
        productRepository.save(product);
    }

    /**
     * 保存到简报表
     *
     * @param product
     * @param mess
     * @return
     * @throws Exception
     */
    private Product saveMess(Product product, Mess mess) throws Exception {

        mess.setAuthortime(new Date());
        mess.setTablename(Product.class.getSimpleName());
        mess.setTableid(product.getId());
        mess.setAuthor(product.getProductauthor());
        mess.setTitle(product.getProductname());
        mess.setOutline(product.getOutline());
        messRepository.save(mess);
        return product;
    }


    /**
     * 删除信息
     *
     * @param id
     * @throws SystemException
     */
    @Override
    public void delete(String id) throws SystemException {

        productRepository.delete(id);
    }

    /**
     * 后台产品文档查询
     *
     * @param page
     * @param producttype
     * @return
     */
    public Page<Product> select(Integer page, String producttype) {
        return productRepository.findByProducttypeLike(producttype, BasePageBuilder.create(page, configProperties.getPageSize()));
    }

    /**
     * 前台展示
     *
     * @param producttype
     * @param page
     * @return
     */
    public Page<Product> byProducttype(String producttype, Integer page) {

        Page<Product> productList = productRepository.byProducttype(producttype, BasePageBuilder.create(page, configProperties.getPageSize(), sort));

        for (Product product : productList) {
            String date = product.getProducttime().toString();

            String time = null;
            if (date.length() > 10) {

                date = date.substring(0, 10);
                time = date.substring(0, 10);
            }
            product.setProducttime(time);
        }

        return productList;
    }

    /**
     * 产品资料修改下载次数
     *
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
     *
     * @param id
     * @throws SystemException
     */
    @Override
    public void updateProtype(String id) throws SystemException {
        productRepository.updateProtype(id);
    }

    /**
     * 获取下载次数
     *
     * @param id
     * @return
     */
    /**
     * 获取下载次数
     *
     * @param id
     * @return
     */
    @Override
    public String byCount(String id) {
        return productRepository.byCount(id);
    }
}
