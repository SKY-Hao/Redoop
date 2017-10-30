package com.redoop.modules.admin.product.service;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.product.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */
public interface ProductService {

    /**
     * 产品资料下载列表
     * @return
     */
    Page<Product> findAll(Integer page);


    /**
     * 按产品类型查询
     * @param producttype
     * @return
     */
    Page<Product> select(Integer page, String producttype);


    /**
     * 按ID查询
     * @param id
     * @return
     */
    public Product findById(String id);


    /**
     * 产品资料下载添加(修改)
     * @param product
     * @throws SystemException
     */
    public void save(Product product) throws SystemException;


    /**
     * 产品资料前台展示
     * @param producttype
     * @param page
     * @return
     */
    public Page<Product> byProducttype(String producttype,Integer page);


    /**
     * 产品资料下载删除
     * @param id
     * @throws SystemException
     */
    public void delete(String id) throws SystemException;

    /**
     * 产品资料下载次数
     * @param id
     * @return
     * @throws SystemException
     */
    public int addProductCount(String id) throws SystemException;

    /**
     * 取消发布
     * @param id
     */
    void updateProtype(String id)throws SystemException;
}
