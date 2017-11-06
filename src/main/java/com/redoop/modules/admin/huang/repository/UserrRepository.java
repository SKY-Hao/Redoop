package com.redoop.modules.admin.huang.repository;

import com.redoop.modules.admin.huang.entity.Dept;
import com.redoop.modules.admin.huang.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
@Repository
public interface UserrRepository extends JpaRepository<Userr,String> {

    @Modifying
    @Transactional
    @Query(value = "select  * from user a left  join dept b on a.dept_id =b.id ",nativeQuery = true)
    List<Userr> list();

    @Query(value = "select  * from dept ",nativeQuery = true)
    List<Dept> deptList();
}
