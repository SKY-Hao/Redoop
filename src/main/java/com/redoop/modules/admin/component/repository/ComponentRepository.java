package com.redoop.modules.admin.component.repository;

import com.redoop.modules.admin.component.entity.Component;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 说明：服务数据仓库
 * 包名：cn.itweet.modules.admin.component.repository
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/13.
 */
@Repository
public interface ComponentRepository extends JpaRepository<Component, String> {

    /**
     * 服务组件信息按照类型查询（前端显示）列表
     * @param type
     * @return
     */
    @Query(value = "FROM Component a WHERE a.type = :type AND a.showstate = 1")
    public Page<Component> listByType(@Param("type") String type,Pageable pageable);

    /**
     * 按照名称模糊查询
     * @param name
     * @return
     */

    @Query(value = "FROM Component a WHERE a.name like CONCAT('%',:name,'%') AND a.showstate = 1")
    //@Query(value = "select * from component c  where c.showstate=1 and c.name like CONCAT('%',:name,'%')",nativeQuery = true)
    Page<Component> findByNameLike(@Param("name") String name,Pageable pageable);

    /**
     * 查询组件名称列表
     * @return
     */
    @Query(value = "SELECT DISTINCT name FROM component WHERE type='0'",nativeQuery = true)
    List<String> findComponentNameList();

    /**
     * 取消发布
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update Component set showstate = 0 where  id = :id")
    void updatedescription(@Param("id") String id);
}
