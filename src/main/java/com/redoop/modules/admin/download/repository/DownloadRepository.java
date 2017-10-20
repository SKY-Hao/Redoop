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
    //前端CRH5.0版本
    @Query(value = "FROM Download WHERE  platformtype = :platformtype and documenttype = 0 and producttype = 0 and productversion = 0 ORDER BY producttime DESC")
    List<Download> listByDocumenttype(@Param("platformtype") String platformtype);
    //前端CRH4.9版本
    @Query(value = "FROM Download WHERE  platformtype = :platformtype and documenttype = 0 and producttype = 0 and productversion = 1 ORDER BY producttime DESC")
    public List<Download> listByProductversion2(@Param("platformtype") String platformtype);

   /* @Query(value = "FROM Download a WHERE  a.platformtype = :platformtype and a.documenttype = 0 and (a.productversion = 1 or a.productversion =0 )and a.producttype = 0")
    Page<Download> listByDocumenttype(@Param("platformtype") String platformtype,Pageable pageable);
   */

    /**
     * 前台AI列表显示
     * @return
     */

    @Query(value = "FROM Download WHERE  platformtype = :platformtype and documenttype = 0 and producttype = 1  ORDER BY producttime DESC")
    public List<Download> byAIDocumenttype(@Param("platformtype") String platformtype);

    /*@Query(value = "FROM Download  a WHERE  a.platformtype = :platformtype and a.documenttype = 0 and (a.productversion = 0 or a.productversion = 1) and a.producttype = 1 ")
    Page<Download> byAIDocumenttype(@Param("platformtype") String platformtype,Pageable pageable);
*/

    /**
     * 修改下载次数
     * @param id
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE Download SET docudowncount = docudowncount+1  WHERE id = :id")
    public int addDocumenCount(@Param("id") String id);


    @Query(value = "select type  from sys_tag group by type ",nativeQuery = true)
    public List<Tag> listBytype(@Param("type") String type);



}
