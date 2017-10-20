package com.redoop.modules.admin.user.service.permission;

import com.redoop.modules.admin.user.entity.SysPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by whoami on 30/03/2017.
 */
public interface PermissionService {

    /**
     * 获取所有的权限列表信息，带分页
     * @param pageable
     * @return
     */
    Page<SysPermission> getPermissionEntry(Pageable pageable);

    /**
     * 刷新权限控制信息
     * @return  返回0表示成功，返回1表示失败
     */
    Integer refreshPermission();

    /**
     * 通过父ID获取下面的子权限列表
     * @param parentId
     * @return
     */
    List<SysPermission> getPermissionChildNodeByParentId(Integer parentId);

    /**
     * 更新权限信息
     * @param sysPermission
     */
    void update(SysPermission sysPermission);

    /**
     * 删除资源信息通过资源信息ID
     * @param parmissionId
     */
    void deleteById(Integer parmissionId);
}
