package com.redoop.modules.admin.solution.service;


import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.news.entity.New;
import com.redoop.modules.admin.solution.entity.Solution;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 说明：方案及案例Service接口
 * 包名：cn.itweet.modules.admin.Solution
 * 项目名：itweet-boot
 * 创建人：黄天浩
 * 创建时间：2017年10月16日16:20:42
 */
public interface SolutionService {

    /**
     * 后台列表
     * @param page
     * @return
     */
    Page<Solution> findAll(Integer page);

    /**
     * 根据ID是否为空,去添加|修改页面
     * @param id
     * @return
     */
    Solution findById(String id);

    /**
     * 保存|修改
     * @param solution
     * @param attach
     * @param logoPath
     * @throws SystemException
     */
    void save(Solution solution, MultipartFile attach, String logoPath) throws SystemException;

    /**
     * 修改官网是否展示
     * @param solution
     */
    void save(Solution solution)throws SystemException;

    /**
     * 根据Name进行查询(0:行业版本 1:产品方案)
     * @param page
     * @param name
     * @return
     */
    Page<Solution> select(Integer page, String name);

    /**
     * 根据ID删除信息
     * @param id
     * @throws SystemException
     */
    void delete(String id) throws SystemException;

    //官网根据方案|案例名称显示
    List<Solution> listByName();
    List<Solution> listByName2();



}
