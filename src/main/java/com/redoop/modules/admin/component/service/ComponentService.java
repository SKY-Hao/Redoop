package com.redoop.modules.admin.component.service;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.component.entity.Component;
import com.redoop.modules.admin.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 说明：服务Service接口
 * 包名：cn.itweet.modules.admin.component.service
 * 项目名：License-Admin
 * 创建人：SunDaFei
 * 创建时间：2017/7/13.
 */
public interface ComponentService {

    /**
     * 查询服务软件名称列表
     * @return
     */
    public List<String> findComponentNameList();

    /**
     * 服务组件信息列表
     * @return
     */
     Page<Component> findAll(Integer page);

    /**
     * 服务组件信息添加
     * @param component
     * @throws SystemException
     */
    public void save(Component component,MultipartFile attach,String logoPath) throws SystemException;

    /**
     * 服务组件信息按照类型查询（前端显示）列表
     * @return
     */
     Page<Component> listByType(String type,Integer page);

    /**
     * 服务组件信息按ID查询
     * @param id
     * @return
     */
    public Component findById(String id);

    /**
     * 服务组件信息按ID删除
     * @param id
     * @throws SystemException
     */
    public void delete(String id) throws SystemException;

    /**
     * 按名称模糊查询
     * @param name
     * @return
     */
     Page<Component> selectByName(Integer page,String name);


}
