package com.redoop.modules.admin.ceshi.service;

import com.redoop.modules.admin.ceshi.entity.Dept;
import com.redoop.modules.admin.ceshi.entity.Emp;
import com.redoop.modules.admin.ceshi.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */
@Service
public class EmpServiceImpl  implements  EmpService{

    @Autowired
    private EmpRepository empRepository;


    @Override
    public List<Emp> list() {
        return empRepository.list();
    }

    @Override
    public Emp findById(String id) {
        return empRepository.findOne(id);
    }

    @Override
    public List<Dept> deptList() {
        return empRepository.deptList();
    }
}
