package com.redoop.modules.admin.ceshi.service;

import com.redoop.RedoopApplication;
import com.redoop.modules.admin.ceshi.repository.DeptRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/11/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedoopApplication.class)
public class DeptServiceImplTest {

    @Autowired
    private DeptRepository deptRepository;


    @Test
    public void list() throws Exception {
        System.out.println(deptRepository.findAll());
    }

}