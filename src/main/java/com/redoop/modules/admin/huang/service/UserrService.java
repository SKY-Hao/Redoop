package com.redoop.modules.admin.huang.service;

import com.redoop.modules.admin.huang.entity.Dept;
import com.redoop.modules.admin.huang.entity.Userr;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
public interface UserrService {


    List<Userr> list();

    Userr findById(String id);

    List<Dept> deptList();
}
