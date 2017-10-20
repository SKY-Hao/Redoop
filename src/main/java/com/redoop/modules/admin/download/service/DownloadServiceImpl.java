package com.redoop.modules.admin.download.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.download.repository.DownloadRepository;
import com.redoop.modules.admin.system.entity.Tag;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */
@Service
public class DownloadServiceImpl implements DownloadService{

    @Autowired
    DownloadRepository downloadRepository;
    @Autowired
    private ConfigProperties configProperties;
    /**
     * CRH&AI下载列表
     * @return
     */
    public Page<Download> findAll(Integer page) {
        return downloadRepository.findAll(BasePageBuilder.create(page,configProperties.getPageSize()));
    }


    /**
     * 按ID查询
     * @param id
     * @return
     */
    @Override
    public Download findById(String id) {
        return downloadRepository.findOne(id);
    }

    /**
     * CRH&AI下载添加(修改)
     * @param download
     * @throws SystemException
     */
   @Override
    public void save(Download download) throws SystemException {
        if (download.getProducttype() == null || "".equals(download.getProducttype())) {
            throw new SystemException("<script>toastr.error(\"产品类型不能为空\")</script>");
        }
        if (download.getPlatformtype() == null || "".equals(download.getPlatformtype())) {
            throw new SystemException("<script>toastr.error(\"平台类型不能为空\")</script>");
        }
        if (download.getProducttime() == null || "".equals(download.getProducttime())) {
            throw new SystemException("<script>toastr.error(\"产品发布时间不能为空\")</script>");
        }
        if (download.getProductversion() == null || "".equals(download.getProductversion())) {
            throw new SystemException("<script>toastr.error(\"产品版本不能为空\")</script>");
        }
        if (download.getDocumentname() == null || "".equals(download.getDocumentname())) {
            throw new SystemException("<script>toastr.error(\"文档名称不能为空\")</script>");
        }
        if (download.getDocumenturl() == null || "".equals(download.getDocumenturl())) {
            throw new SystemException("<script>toastr.error(\"文档(下载)地址不能为空\")</script>");
        }

        if(download.getId() != null){
            Download data_c = downloadRepository.findOne(download.getId());//id
            download.setDocumentauthor(data_c.getDocumentauthor());//添加作者

        }else{
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            download.setDocumentauthor(user.getUsername());
        }

        downloadRepository.save(download);
    }




    /**
     * 删除信息
     * @param id
     * @throws SystemException
     */
    @Override
    public void delete(String id) throws SystemException {

        downloadRepository.delete(id);
    }
    /**
     * 按产品类型查询
     * @param producttype
     * @return
     */
    public Page<Download> select(Integer page, String producttype) {
        return downloadRepository.findByProducttypeLike(producttype,BasePageBuilder.create(page,configProperties.getPageSize()));
    }

    /**
     * 前台展示CRH列表
     * @param platformtype
     * @return
     */
    //CRH5.0版本
    public List<Download> listByDocumenttype(String platformtype) {
        return downloadRepository.listByDocumenttype(platformtype);
    }
    //CRH4.9版本
    @Override
    public List<Download> listByProductversion2(String platformtype) {
        return downloadRepository.listByProductversion2(platformtype);
    }
   /* @Override分页
    public Page<Download> listByDocumenttype(String platformtype, Integer page) {
        return downloadRepository.listByDocumenttype(platformtype,BasePageBuilder.create(page,configProperties.getPageSize()));
    }*/


    /**
     * 修改下载次数
     * @param id
     * @return
     * @throws SystemException
     */
    @Override
    public int addDocumenCount(String id) throws SystemException {
        return downloadRepository.addDocumenCount(id);
    }

    /**
     * 前台AI列表
     * @param platformtype
     * @return
     */

    public List<Download> byAIDocumenttype(String platformtype) {
        return downloadRepository.byAIDocumenttype(platformtype);
    }

   /* @Override
    public Page<Download> byAIDocumenttype(String platformtype, Integer page) {
        return downloadRepository.byAIDocumenttype(platformtype,BasePageBuilder.create(page,configProperties.getPageSize()));
    }*/


    @Override
    public List<Tag> listBytype(String type) {
        return downloadRepository.listBytype(type);
    }
}
