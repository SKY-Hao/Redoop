package com.redoop.modules.admin.partner.service;

import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.partner.entity.Partner;
import com.redoop.common.exception.SystemException;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * 说明：合作伙伴service接口
 * 包名：cn.itweet.modules.admin.partner.service
 * 项目名：License-Admin
 * 创建人：黄天浩
 * 创建时间：2017年9月7日17:04:25
 */

public interface PartnerService {

    /**
     * 后台合作伙伴列表
     * @return
     */
    Page<Partner> findAll(Integer page);

   /**
    * 前台展示列表
    * @return
    */
   public Page<Partner> listByIntention(Integer page);

    /**
     * 按公司名称模糊查询
     * @param companyname
     * @return
     */
     Page<Partner> select(Integer page,String companyname);


    /**
     * 按ID查询
     * @param id
     * @return
     */
    public Partner findById(String id);

    /**
     * 根据公司名称进行查询公司信息
     * @param companyname
     * @return
     */
    public Partner findByComName(String companyname);


    /**
     * 合作伙伴后台请添加
     * @param partner
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    public void save(Partner partner, MultipartFile attach, String logoPath) throws SystemException;


    /**
     * 合作伙伴前台申请添加
     * @param partner
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    public void applySave(Partner partner, MultipartFile attach, String logoPath) throws SystemException;

    /**
     * 删除信息
     * @param id
     * @throws SystemException
     */
    public void delete(String id) throws SystemException;

    /**
     * 认证（未认证）认证通过是0    未认证是1
     * @param id
     * @throws SystemException
     */
    public void authenticationWRZ(String id) throws SystemException;


    /**
     * 认证（已认证）认证通过是0    未认证是1
     * @param id
     * @throws SystemException
     */
    public void authenticationYRZ(String id) throws SystemException;

    /**
     * 前台多选搜索(checkbox)
     * @param partnertype
     * @return
     */
    /*public List<Partner> findByPartnertype(String partnertype) throws Exception;*/

    Page<Partner> findByPartnertype(Integer page, String partnertype)throws Exception;


    /**
     * 发布
     * @param partner
     * @throws Exception
     */
    void save(Partner partner, Mess mess) throws Exception;

    /**
     * 取消发布
     * @param id
     */
    void updateIntention(String id)throws SystemException;
}

