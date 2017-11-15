package com.redoop.modules.admin.ceshi.repository;

import com.redoop.modules.admin.ceshi.entity.Dept;
import com.redoop.modules.admin.ceshi.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */
@Repository
public interface DeptRepository extends JpaRepository<Dept, String> {


}
