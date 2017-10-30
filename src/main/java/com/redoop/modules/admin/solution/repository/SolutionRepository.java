package com.redoop.modules.admin.solution.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.solution.entity.Solution;
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
 * 说明：
 * 包名：cn.itweet.modules.admin.solution.repository
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间：2017年10月16日16:20:50
 */
@Repository
@Transactional
public interface SolutionRepository extends JpaRepository<Solution,String> {

    /**
     * 后台模糊查询
     * @param name
     * @param pageable
     * @return
     */
    Page<Solution> findByNameLike(String name, Pageable pageable);

    @Query(value = "FROM Solution WHERE name = 0 and state = 0 ORDER BY authortime DESC")
    List<Solution> listByName();
    @Query(value = "FROM Solution WHERE name = 1 and state = 0 ORDER BY authortime DESC")
    List<Solution> listByName2();

    /**
     * 取消发布
     * @param id
    */
     @Modifying
     @Transactional
     @Query(value = "update Solution set state=1 where  id=:id")
    void updateState(@Param("id") String id);
}
