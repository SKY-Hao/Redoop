package com.redoop.modules.admin.partner.repository;

import com.redoop.modules.admin.partner.entity.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

/**
 * 说明：合作伙伴数据仓库
 * 包名：cn.itweet.modules.admin.component.PartnerRepository
 * 项目名：License-Admin
 * 创建人：黄天浩
 * 创建时间：2017年9月7日17:06:55
 */
@Repository
public interface PartnerRepository  extends JpaRepository<Partner,String>{

    /**
     * 前台列表显示
     * @return
     */
    @Query(value = "From Partner a WHERE a.intention = 0 order by a.auditortime DESC")
     Page<Partner> listByIntention(Pageable pageable);

    /**
     * 按照名称模糊查询
     * @param companyname
     * @return
     */
    //@Query(value = "select * from partner c  where c.companyname like CONCAT('%',:companyname,'%')",nativeQuery = true)
    Page<Partner> findByCompanynameLike(String companyname, Pageable pageable);

    /**
     * 根据公司名称进行查询公司信息
     * @param companyname
     * @return
     */
    @Query(value = "select * from partner c  where c.companyname like CONCAT('%',:companyname,'%')",nativeQuery = true)
    Partner findByComName(String companyname);


    /**
     * 认证（未认证）认证通过是0    未认证是1
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE Partner SET authentication = 0 ,testresult =0 WHERE id = :id")
    public void authenticationWRZ(@Param("id") String id);


    /**
     * 认证（未认证）认证通过是0    未认证是1
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE Partner SET authentication = 1 ,testresult =1 WHERE id = :id")
    public void authenticationYRZ(@Param("id") String id);

    /**
     * 搜索厂商
     * 前台多选搜索(checkbox)
     * @param partnertype
     * @return
     */

    /*@Query(value = " FROM Partner WHERE partnertype = :partnertype and intention = 0")*/
    /*List<Partner> findByPartnertype(@Param("partnertype")String partnertype);*/

    @Query(value = " FROM Partner a WHERE a.partnertype in( :partnertype) and a.intention = 0")
    Page<Partner> findByPartnertype(@Param("partnertype")List<String> partnertype, Pageable pageable);


}
