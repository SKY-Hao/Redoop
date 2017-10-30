package com.redoop.modules.admin.mess.service;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.mess.entity.Mess;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 说明：简报信息Service
 * 包名：cn.itweet.modules.admin.mess.service
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间： 2017年10月23日
 */
public interface MessService {
    Page<Mess> findAll(Integer page);

    Mess findById(String id);

    void save(Mess mess) throws SystemException;

    void delete(String id) throws SystemException;

    /**
     * 官网首页简报更新
     * @return
     */
    List<Mess> list();

    Page<Mess> selectByTime(String starttime, String endtime, Integer page) throws ParseException;




    // Page<Mess> selectByTime(Integer page, String authortime);
}
