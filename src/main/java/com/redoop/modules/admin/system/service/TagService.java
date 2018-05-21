package com.redoop.modules.admin.system.service;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.system.entity.Tag;

import java.util.List;

/**
 * 说明：系统标签管理Service层接口
 * 包名：cn.itweet.tea.admin.system.tag.service
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/15.
 */
public interface TagService {


    /**
     * 系统标签保存
     * @param tag
     */
    void save(Tag tag) throws SystemException;

    /**
     * 系统标签列表
     *
     * @return
     */
    List<Tag> list();

    /**
     * 系统标签按ID删除
     *
     * @param id
     * @throws SystemException
     */
    void delete(String id) throws SystemException;

    /**
     * 系统标签按ID查询
     *
     * @param id
     * @return
     */
    Tag findById(String id);

    /**
     * 按类型查询
     * @param type
     * @return
     */
    List<Tag> findByType(String type);

    /**
     * 查询所有类型
     * @return
     */
    List<String> types();

}
