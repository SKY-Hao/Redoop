package com.redoop.modules.admin.download.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.BasePageBuilder;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.common.utils.HtmlUtil;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.download.repository.DownloadRepository;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.repository.MessRepository;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.solution.entity.Solution;
import com.redoop.modules.admin.system.entity.Tag;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 说明：RdoopCRH||AI GroupServiceImpl
 * 包名：cn.itweet.modules.admin.download.service
 * 项目名：License-Admin
 * 创建人：黄天浩
 * 创建时间：2017年10月25日10:28:37
 */
@Service
public class DownloadServiceImpl implements DownloadService{

    @Autowired
    DownloadRepository downloadRepository;
    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private MessRepository messRepository;

    private Sort sort = new Sort(Sort.Direction.DESC,"producttime");
    /**
     * CRH&AI下载列表
     * @return
     */
    public Page<Download> findAll(Integer page) {
        return downloadRepository.findAll(BasePageBuilder.create(page,configProperties.getPageSize(),sort));
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
    public void save(Download download, MultipartFile[] attachs, String logoPath) throws Exception {
        if (download.getProducttype() == null || "".equals(download.getProducttype())) {
            throw new SystemException("<script>toastr.error(\"产品类型不能为空\")</script>");
        }
        if (download.getPlatformtype() == null || "".equals(download.getPlatformtype())) {
            throw new SystemException("<script>toastr.error(\"平台类型不能为空\")</script>");
        }
        if (download.getProducttime() == null || "".equals(download.getProducttime())) {
            throw new SystemException("<script>toastr.error(\"产品发布时间不能为空\")</script>");
        }
        if (download.getDocumentname() == null || "".equals(download.getDocumentname())) {
            throw new SystemException("<script>toastr.error(\"文档名称不能为空\")</script>");
        }
        /*if (download.getDocumenturl() == null || "".equals(download.getDocumenturl())) {
            throw new SystemException("<script>toastr.error(\"文档(下载)地址不能为空\")</script>");
        }*/

            if(download.getId() != null){
                Download date_download = downloadRepository.findOne(download.getId());
                download.setDocumentauthor(date_download.getDocumentauthor());
                download.setDocumenttype("1");
                download.setSystempic(date_download.getSystempic());//系统图片
                download.setSystempicname(date_download.getSystempicname());
                download.setChippic(date_download.getChippic());    //芯片图片
                download.setChippicname(date_download.getChippicname());

                if(attachs.length >0 && !attachs[0].getOriginalFilename().equals("")){
                    try {
                        download = uploadPic(download,attachs,logoPath);
                        DeleteUtils.deletePic(logoPath + date_download.getSystempic());
                        DeleteUtils.deletePic(logoPath + date_download.getChippic());
                    } catch (Exception e) {
                        throw new SystemException("<script>toastr.error(\"图片Logo上传失败,请重新上传系统和芯片图片\")</script>");
                    }
                }else{
                    download.setSystempic(download.getSystempic());
                    download.setChippic(download.getChippic());
                }
        }else{

            if(attachs.length<=1){

                throw new SystemException("<script>toastr.error(\"图片Logo上传失败,请重新上传系统和芯片图片\")</script>");

            }else{
                try {
                    download = uploadPic(download,attachs,logoPath);
                } catch (Exception e) {
                    throw new SystemException("<script>toastr.error(\"图片Logo不能为空,请重新上传系统和芯片图片\")</script>");
                }
            }
            User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            download.setDocumentauthor(user.getUsername());
            download.setDocumenttype("1");
        }
        downloadRepository.save(download);
    }
    /**
     * 图片上传
     * @param download
     * @param attachs
     * @param logoPath
     * @return
     * @throws IOException
     */
    private Download uploadPic(Download download, MultipartFile[] attachs,String logoPath) throws IOException {
        logoPath = logoPath + configProperties.getUploadSuffix();

        File filePath=new File(logoPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        for (int i=0;i<attachs.length;i++){
            String picNameOld = attachs[i].getOriginalFilename();
            String picType = picNameOld.substring(picNameOld.lastIndexOf("."),picNameOld.length());
            String picNameNew = Uuid.getUuid() + picType;
            //最终文件名
            File realFile=new File(logoPath + File.separator + picNameNew);
            FileUtils.copyInputStreamToFile(attachs[i].getInputStream(), realFile);
            if (i==0){
                download.setSystempic(configProperties.getUploadSuffix() + picNameNew);
            }else {
                download.setChippic(configProperties.getUploadSuffix() + picNameNew);
            }
        }
        return download;
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
    public List<Download> listByDocumenttype(String platformtype) {

        List<Download> downloadList =    downloadRepository.listByDocumenttype(platformtype);

        for(Download download: downloadList){
            String date = download.getProducttime().toString();
            String time=null;
            if(date.length() > 10){

                date = date.substring(0,10);
                time = date.substring(0,10);
            }
            download.setProducttime(time);
        }
        return downloadList;
    }


    /**
     * 前端下载次数增加
     * @param id
     * @return
     * @throws SystemException
     */
    @Override
    public int addDocumenCount(String id) throws SystemException {
        return downloadRepository.addDocumenCount(id);
    }


    @Override
    public List<Tag> listBytype(String type) {
        return downloadRepository.listBytype(type);
    }




    /**
     * 发布
     * @param download
     * @throws Exception
     */
    @Override
    public void save(Download download,Mess mess) throws Exception {

        download=saveMess(download,mess);
        downloadRepository.save(download);
    }


    /**
     * 保存到简报表
     * @param download
     * @param mess
     * @return
     * @throws Exception
     */
    private Download saveMess(Download download, Mess mess) throws Exception {

        mess.setAuthortime(new Date());
        mess.setTablename(Download.class.getSimpleName());
        mess.setTableid(download.getId());
        mess.setAuthor(download.getDocumentauthor());
        mess.setTitle("Redoop CRH"+"  "+download.getDocumentname()+"  "+download.getSysversion());
        mess.setOutline(download.getOutline());

        messRepository.save(mess);
        return download;
    }


    /**
     * 取消发布
     * @param id
     * @throws SystemException
     */
    @Override
    public void updateDocumenttype(String id) throws SystemException {
        downloadRepository.updateDocumenttype(id);
    }

    /**
     * 获取点击次数
     * @param id
     * @return
     */
    @Override
    public String findByCout(String id) {
        return downloadRepository.findBycount(id);
    }


    /*@Override
    public List<Group> findMarkDownId(String id) {
        return downloadRepository.findMarkDownId(id);
    }*/

    @Override
    public Download findMarkDownId(String id) {
        return downloadRepository.findOne(id);
    }
}
