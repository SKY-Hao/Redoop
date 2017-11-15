package com.redoop.modules.admin.ceshi.service;

import com.redoop.modules.admin.ceshi.entity.Dept;
import com.redoop.modules.admin.ceshi.entity.Emp;
import com.redoop.modules.admin.ceshi.repository.DeptRepository;
import com.redoop.modules.admin.ceshi.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */
@Service
public class DeptServiceImpl implements  DeptService{

    @Autowired
    private DeptRepository deptRepository;


    @Override
    public List<Dept> list() {
        return deptRepository.findAll();
    }
}
