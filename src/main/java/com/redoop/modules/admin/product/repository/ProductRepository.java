package com.redoop.modules.admin.product.repository;

import com.redoop.modules.admin.product.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/10.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {


    /**
     * 产品文档查询
     * @param producttype
     * @param pageable
     * @return
     */

    @Query(value = "FROM Product a where a.producttype like CONCAT('%',:producttype,'%')")
    Page<Product> findByProducttypeLike(@Param("producttype")String producttype, Pageable pageable);

    /**
     * 前台展示
     * @param producttype
     * @param pageable
     * @return
     */
    @Query(value = "FROM Product  a WHERE  a.producttype = :producttype and a.protype = 0")
    Page<Product> byProducttype(@Param("producttype") String producttype,Pageable pageable);

    /**
     * 修改下载次数
     * @param id
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE Product SET productcount = productcount+1  WHERE id = :id")
    public int addProductCount(@Param("id") String id);

}
