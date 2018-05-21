package com.redoop.modules.admin.license.service;

import com.redoop.common.exception.ValidateException;
import com.redoop.modules.admin.license.entity.License;
import com.redoop.modules.admin.license.utils.Message;

import java.util.List;

/**
 * 说明：license授权管理Service层接口
 * 包名：cn.itweet.tea.admin.license
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
public interface LicenseService {

    /**
     * 用户申请注册许可
     * @param license
     * @param filePath
     * @return
     */
    Message register(License license, String filePath);

    /**
     * license授权列表
     * @return
     */
    List<License> list();

    /**
     * license授权按公司查询
     * @param companyName
     * @return
     */
    List<License> getByCompany(String companyName);

    /**
     * license授权删除
     * @param id
     */
    void delete(Integer id);

    /**
     * license授权ID查询
     * @param id
     * @return
     */
    License getById(Integer id);

    /**
     * license授权修改
     * @param license
     * @throws ValidateException
     */
    void edit(License license) throws ValidateException;

    /**
     * 授权
     * @param license
     * @throws ValidateException
     */
    void authorize(License license) throws ValidateException;

}
