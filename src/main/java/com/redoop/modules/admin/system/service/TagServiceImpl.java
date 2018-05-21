package com.redoop.modules.admin.system.service;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.system.entity.Tag;
import com.redoop.modules.admin.system.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 说明：系统标签管理Service层接口实现
 * 包名：cn.itweet.tea.admin.system.tag.service
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/15.
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    /**
     * 按照类型查询
     * @param type
     * @return
     */
    @Override
    public List<Tag> findByType(String type) {
        return tagRepository.findByType(type);
    }

    /**
     * 查询所有类型
     * @return
     */
    @Override
    public List<String> types() {
        return tagRepository.types();
    }

    /**
     * 标签保存
     * @param tag
     * @throws SystemException
     */
    @Override
    public void save(Tag tag) throws SystemException {

        if (tag.getValue() == null || "".equals(tag.getValue())) {
            throw new SystemException("<script>toastr.error(\"键值不能为空\")</script>");
        }

        if (tag.getLabel() == null || "".equals(tag.getLabel())) {
            throw new SystemException("<script>toastr.error(\"标签不能为空\")</script>");
        }

        if (tag.getType() == null || "".equals(tag.getType())) {
            throw new SystemException("<script>toastr.error(\"类型不能为空\")</script>");
        }
        tag.setCreateDate(new Date());

        tagRepository.save(tag);

    }

    /**
     * 系统标签列表
     *
     * @return
     */
    public List<Tag> list() {
        return (List<Tag>) tagRepository.findAll();
    }

    /**
     * 系统标签按ID删除
     *
     * @param id
     * @throws SystemException
     */
    public void delete(String id) throws SystemException {
        try {
            tagRepository.delete(id);
        } catch (Exception e) {
            throw new SystemException("<script>toastr.error(\"系统标签删除失败\")</script>");
        }
    }

    /**
     * 系统标签按ID查询
     *
     * @param id
     * @return
     */
    public Tag findById(String id) {
        return tagRepository.findOne(id);
    }

}
