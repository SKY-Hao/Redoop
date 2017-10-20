package com.redoop.modules.admin.download.service;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.system.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
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
    //public void save(Download download) throws SystemException;

    public void save(Download download) throws Exception;
   // public void save1(Download download, MultipartFile attach2, String logoPath) throws Exception;


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
    List<Download> listByProductversion2(String platformtype);//4.9版本
    //public Page<Download> listByDocumenttype(String platformtype,Integer page);


    /**
     * 修改下载次数
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

    //public Page<Download> byAIDocumenttype(String platformtype,Integer page);


    /**
     * 2017年9月25日15:09:15
     * @param type
     * @return
     */
    List<Tag> listBytype(String type);


}
