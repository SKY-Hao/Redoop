package com.redoop.modules.admin.tea.repostory;

import com.redoop.modules.admin.tea.entity.Tea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/5/18.
 */
@Repository
public interface TeaRepostory extends JpaRepository<Tea,String> {

    @Query(value = "select  * from tea where id= :id",nativeQuery = true)
    Tea selectId(@Param("id") String id);
}
