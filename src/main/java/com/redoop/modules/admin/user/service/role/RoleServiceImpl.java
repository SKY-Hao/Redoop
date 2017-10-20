package com.redoop.modules.admin.user.service.role;

import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.CommonUtils;
import com.redoop.modules.admin.user.entity.SysPermissionRole;
import com.redoop.modules.admin.user.entity.SysRole;
import com.redoop.modules.admin.user.repository.PermissionRoleRepository;
import com.redoop.modules.admin.user.repository.RoleRepository;
import com.redoop.modules.admin.user.repository.RoleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by whoami on 26/03/2017.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRoleRepository permissionRoleRepository;

    @Autowired
    private RoleUserRepository roleUserRepository;

    @Override
    public List<Integer> getRoleIdsByUid(Integer uid) {
        return roleUserRepository.getRoleIdsByUid(uid);
    }

    @Override
    public List<SysRole> list() {
        return roleRepository.findAll();
    }

    @Override
    public void update(SysRole role) throws SystemException {
        if (role.getName() == null || "" == role.getName())
            throw new SystemException("更新失败，要更新的角色名称不能为空！");

        SysRole sysRole = roleRepository.findOne(role.getId());
        if (!sysRole.getName().equals(role.getName()) && role.getId() != null)
            roleRepository.save(role);
    }

    @Override
    public SysRole add(SysRole role) throws SystemException {
        SysRole sysRole = roleRepository.findByRoleName(role.getName());

        if (sysRole.getName() != null)
            throw new SystemException("添加失败，角色名称已经存在，不能重复添加！");

        if (role.getName() == null || "" == role.getName())
            throw new SystemException("添加失败，角色名称不能为空！");

        return roleRepository.save(role);
    }

    @Override
    public void deleteById(Integer id) throws SystemException {
        SysRole sysRole = roleRepository.findOne(id);

        if (roleUserRepository.getRoleUserIdsyRoleId(id).size() > 0) {
            roleUserRepository.deleteByRoleId(id);
        }

        if (permissionRoleRepository.getPermissionRoleIdsByRoleId(id).size() > 0) {
            permissionRoleRepository.deleteByRoleId(id);
        }

        if (sysRole != null) {
            roleRepository.delete(id);
        } else {
            throw new SystemException("要删除的用户不存在！");
        }
    }

    @Override
    public SysRole findById(Integer id) {
        return roleRepository.findOne(id);
    }

    @Override
    public SysRole findByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }

    @Override
    public void setAuthorization(Integer rid, List<Integer> perissionIds) {
        List<Integer> dbPerissionIds = permissionRoleRepository.getPermissionRoleIdsByRoleId(rid);
        List<Integer> delElems = CommonUtils.getDeleteElements(perissionIds,dbPerissionIds);
        List<Integer> aggElems = CommonUtils.getAggrandizeElements(perissionIds,dbPerissionIds);

        if (delElems != null) {
            System.out.println("delElems: "+delElems.toString());
            for (Integer perid : delElems) {
                permissionRoleRepository.deleteByRoleIdAndPermissionId(rid,perid);
            }
        }

        if (aggElems != null) {
            System.out.println("aggElems: "+aggElems);
            for (Integer perissionId : aggElems) {
                SysPermissionRole sysPermissionRole = new SysPermissionRole();
                sysPermissionRole.setRoleId(rid);
                sysPermissionRole.setPermissionId(perissionId);
                permissionRoleRepository.save(sysPermissionRole);
            }
        }
    }
}
