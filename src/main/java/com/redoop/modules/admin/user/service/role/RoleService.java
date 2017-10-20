package com.redoop.modules.admin.user.service.role;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.user.entity.SysRole;

import java.util.List;

/**
 * Created by whoami on 26/03/2017.
 */
public interface RoleService {

    List<Integer> getRoleIdsByUid(Integer uid);

    List<SysRole> list();

    void update(SysRole role) throws SystemException;

    SysRole add (SysRole role) throws SystemException;;

    void deleteById(Integer id) throws SystemException;

    SysRole findById(Integer id);

    SysRole findByRoleName(String name);

    void setAuthorization(Integer rid,List<Integer> perissionIds);
}
