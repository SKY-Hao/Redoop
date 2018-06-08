package com.redoop.modules.admin.tea.service;

import com.redoop.modules.admin.tea.entity.Tea;
import com.redoop.modules.admin.tea.repostory.TeaRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */
@Service
public class TeaServiceImpl implements  TeaServce{


    @Autowired
    TeaRepostory teaRepostory;

    @Override
    public List<Tea> list() {
        return teaRepostory.selectAll();
    }


    @Override
    public Tea findById(String id) {

        return  teaRepostory.selectId(id);
        //return teaRepostory.findOne(id);
    }
}
