package com.redoop.modules.admin.download.service;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.system.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 说明：RdoopCRH||AI service
 * 包名：cn.itweet.modules.admin.download.service
 * 项目名：License-Admin
 * 创建人：黄天浩
 * 创建时间：2017年10月25日10:28:37
 */
public interface DownloadService {

    /**
     * CRH&AI下载列表
     * @return
     */
    Page<Download> findAll(Integer page);


    /**
     * 按产品类型查询
     * @param producttype
     * @return
     */
    Page<Download> select(Integer page, String producttype);


    /**
     * 按ID查询
     * @param id
     * @return
     */
    public Download findById(String id);


    /**
     * CRH&AI下载添加(修改)
     * @param download
     * @throws SystemException
     */
    public void save(Download download, MultipartFile[] attachs, String logoPath) throws Exception;


    /**
     * CRH&AI下载删除
     * @param id
     * @throws SystemException
     */
    public void delete(String id) throws SystemException;


    /**
     * CRH前台显示列表
     * @return
     */
     List<Download> listByDocumenttype(String platformtype);//5.0版本



    /**
     * 前端下载次数增加
     * @param id
     * @return
     * @throws SystemException
     */
    public int addDocumenCount(String id) throws SystemException;



    /**
     * AI前台列表
     * @param producttype
     * @return
     */
    List<Download> byAIDocumenttype(String producttype);



    /**
     * 2017年9月25日15:09:15
     * @param type
     * @return
     */
    List<Tag> listBytype(String type);


    /**
     * 发布
     * @param download
     * @throws SystemException
     */
    void save(Download download)throws Exception;

    /**
     * 取消发布
     * @param id
     * @throws SystemException
     */
    void updateDocumenttype(String id) throws SystemException;

    /**
     * 获取点击次数
     * @param id
     * @return
     */
    String findByCout(String id);
}
