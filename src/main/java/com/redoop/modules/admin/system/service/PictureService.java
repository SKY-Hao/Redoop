package com.redoop.modules.admin.system.service;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.system.entity.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 说明：系统图片Service层接口
 * 包名：cn.itweet.tea.admin.system.picture.service
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/16.
 */
public interface PictureService {

    /**
     * 系统图片列表
     *
     * @return
     */
    List<Picture> list();


    /**
     * 保存图片
     * @param picture
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    void save(Picture picture, MultipartFile attach, String logoPath) throws SystemException;


    /**
     * 系统图片按ID删除
     *
     * @param id
     * @throws SystemException
     */
    void delete(String id) throws SystemException;


    /**
     * 系统图片按ID查询
     *
     * @param id
     * @return
     */
    Picture findById(String id);

    /**
     * 查询图片类型
     * @return
     */
    List<String> findType();


    /**
     * 保存普通属性
     * @param picture
     */
    void save(Picture picture);

}
