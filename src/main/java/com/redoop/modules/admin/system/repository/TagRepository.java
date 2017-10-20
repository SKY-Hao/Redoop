package com.redoop.modules.admin.system.repository;

import com.redoop.modules.admin.system.entity.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 说明：系统标签数据仓库接口
 * 包名：cn.itweet.modules.admin.system.tag.repository
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/15.
 */
@Repository
public interface TagRepository extends CrudRepository<Tag, String> {

    List<Tag> findByType(String type);

    @Query(value = "SELECT DISTINCT type FROM sys_tag",nativeQuery = true)
    List<String> types();

}
