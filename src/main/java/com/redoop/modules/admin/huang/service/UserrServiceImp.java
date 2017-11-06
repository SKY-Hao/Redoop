package com.redoop.modules.admin.huang.service;

import com.redoop.common.config.ConfigProperties;
import com.redoop.modules.admin.huang.entity.Dept;
import com.redoop.modules.admin.huang.entity.Userr;
import com.redoop.modules.admin.huang.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
@Service
public class UserrServiceImp implements UserrService {

    @Autowired
    private UserrRepository userrRepository;


    @Autowired
    private ConfigProperties configProperties;

    @Override
    public List<Userr> list() {
        return userrRepository.list();
    }

    @Override
    public Userr findById(String id) {
        return userrRepository.findOne(id);
    }

    @Override
    public List<Dept> deptList() {
        return userrRepository.deptList();
    }
}
