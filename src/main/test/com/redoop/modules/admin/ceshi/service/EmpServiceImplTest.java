package com.redoop.modules.admin.ceshi.service;

import com.redoop.RedoopApplication;
import com.redoop.modules.admin.ceshi.repository.EmpRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/11/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedoopApplication.class)
public class EmpServiceImplTest {

    @Autowired
    private EmpRepository empRepository;

    @Test
    public void deptList() throws Exception {

        System.out.println(empRepository.deptList());
    }

}