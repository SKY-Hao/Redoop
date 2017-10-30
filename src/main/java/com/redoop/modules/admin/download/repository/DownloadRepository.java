package com.redoop.modules.admin.download.repository;

import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.partner.entity.Partner;
import com.redoop.modules.admin.system.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */
@Repository
public interface DownloadRepository extends JpaRepository<Download,String> {


    /**
     * 按产品类型查询
     * @param producttype
     * @return
     */
    @Query(value = "FROM Download a where a.producttype like CONCAT('%',:producttype,'%')")
    Page<Download> findByProducttypeLike(@Param("producttype")String producttype, Pageable pageable);

    /**
     * 前台CRH列表显示
     * @return
     */

    @Query(value = "FROM Download WHERE  platformtype = :platformtype and documenttype = 0 and producttype = 0  ORDER BY producttime DESC")
    List<Download> listByDocumenttype(@Param("platformtype") String platformtype);


    /**
     * 前台AI列表显示
     * @return
     */
    @Query(value = "FROM Download WHERE  platformtype = :platformtype and documenttype = 0 and producttype = 1  ORDER BY producttime DESC")
    List<Download> byAIDocumenttype(@Param("platformtype") String platformtype);


    /**
     * 修改下载次数
     * @param id
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "update download set docudowncount = docudowncount+1  WHERE id = :id",nativeQuery = true)
    public int addDocumenCount(@Param("id") String id);


    @Query(value = "select type  from sys_tag group by type ",nativeQuery = true)
    public List<Tag> listBytype(@Param("type") String type);

    /**
     * 取消发布
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update Download  set documenttype = 1 where  id = :id")
    void updateDocumenttype(@Param("id") String id);

    /**
     * 获取点击次数
     * @param id
     * @return
     */
    @Query(value = "select docudowncount  from download where  id = :id",nativeQuery = true)
    String findBycount(@Param("id")String id);
}
