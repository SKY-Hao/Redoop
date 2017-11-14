package com.redoop.modules.admin.ceshi.service;

import com.redoop.modules.admin.ceshi.entity.Dept;
import com.redoop.modules.admin.ceshi.entity.Emp;

import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */
public interface EmpService {


    List<Emp> list();


    List<Dept> deptList();

    Emp findById(String id);
}
