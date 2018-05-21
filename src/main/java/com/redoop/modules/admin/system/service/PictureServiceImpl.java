package com.redoop.modules.admin.system.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.DeleteUtils;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.component.entity.Component;
import com.redoop.modules.admin.system.entity.Picture;
import com.redoop.modules.admin.system.repository.PictureRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 * 说明：系统图片Service层接口实现类
 * 包名：cn.itweet.tea.admin.system.picture.service
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/16.
 */
@Service
public class PictureServiceImpl implements PictureService{

    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private ConfigProperties configProperties;

    /**
     * 系统图片列表
     *
     * @return
     */
    public List<Picture> list() {
        return (List<Picture>) pictureRepository.findAll();
    }

    /**
     * 保存普通属性
     * @param picture
     */
    public void save(Picture picture){
        pictureRepository.save(picture);
    }

    /**
     * 保存图片
     * @param picture
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    @Override
    public void save(Picture picture, MultipartFile attach, String logoPath) throws SystemException {
        System.out.println(picture);
        if (picture.getName() == null || "".equals(picture.getName())) {
            throw new SystemException("<script>toastr.error(\"图片名称不能为空\")</script>");
        }

        if (picture.getType() == null || "".equals(picture.getType())) {
            throw new SystemException("<script>toastr.error(\"图片类型不能为空\")</script>");
        }

        if(picture.getId() != null){
            Picture data_c = pictureRepository.findOne(picture.getId());
            picture.setCreateBy(data_c.getCreateBy());
            picture.setCreateDate(data_c.getCreateDate());

            if(attach.isEmpty()){
                picture.setUrl(data_c.getUrl());
            }else{
                try {
                    picture = uploadPic(picture,attach,logoPath);
                    DeleteUtils.deletePic(logoPath + data_c.getUrl());
                } catch (IOException e) {
                    throw new SystemException("<script>toastr.error(\"图片文件上传失败\")</script>");
                }
            }

        }else{
            if(attach.isEmpty()){
                throw new SystemException("<script>toastr.error(\"图片文件不能为空\")</script>");
            }else{
                try {
                    picture = uploadPic(picture,attach,logoPath);
                } catch (IOException e) {
                    throw new SystemException("<script>toastr.error(\"图片文件上传失败\")</script>");
                }
            }
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            picture.setCreateBy(user.getUsername());
            picture.setCreateDate(new Date());
        }

        pictureRepository.save(picture);

    }

    /**
     * 文件上传
     * @param picture
     * @param attach
     * @param logoPath
     * @return
     * @throws IOException
     */
    private Picture uploadPic(Picture picture, MultipartFile attach, String logoPath) throws IOException {
        logoPath = logoPath + configProperties.getUploadSuffix();
        File filePath=new File(logoPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }

        String picNameOld = attach.getOriginalFilename();
        String picType = picNameOld.substring(picNameOld.lastIndexOf("."),picNameOld.length());
        String picNameNew = Uuid.getUuid() + picType;

        //最终文件名
        File realFile=new File(logoPath + File.separator + picNameNew);
        FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

        picture.setUrl(configProperties.getUploadSuffix() + picNameNew);

        return picture;
    }

    /**
     * 系统图片按ID删除
     *
     * @param id
     * @throws SystemException
     */
    public void delete(String id) throws SystemException {
        try {
            pictureRepository.delete(id);
        } catch (Exception e) {
            throw new SystemException("<script>toastr.error(\"图片文件删除失败\")</script>");
        }
    }

    /**
     * 系统图片按ID查询
     *
     * @param id
     * @return
     */
    public Picture findById(String id) {
        return pictureRepository.findOne(id);
    }

    /**
     * 查询图片类型
     * @return
     */
    @Override
    public List<String> findType() {
        return pictureRepository.findType();
    }
}
