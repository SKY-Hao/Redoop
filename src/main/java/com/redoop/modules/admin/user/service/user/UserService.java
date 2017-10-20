package com.redoop.modules.admin.user.service.user;

import com.redoop.common.exception.SystemException;
import com.redoop.modules.admin.user.entity.SysUser;

import java.util.List;

/**
 * Created by whoami on 13/03/2017.
 */
public interface UserService {

    SysUser findById(Integer id);

    void update(SysUser user) throws SystemException;

    SysUser findByUsername(String username);

    SysUser findByEmail(String email);

    List<SysUser> list();

    void add(SysUser user,List<Integer> rIds) throws SystemException;

    void update(SysUser user,List<Integer> rIds) throws SystemException;

    void deleteById(Integer uid) throws SystemException;

    void deleteAll();
}
