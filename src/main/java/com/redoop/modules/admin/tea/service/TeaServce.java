package com.redoop.modules.admin.tea.service;


import com.redoop.modules.admin.tea.entity.Tea;

import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */
public interface TeaServce {
    List<Tea> list();

    public Tea findById(String id);
}
