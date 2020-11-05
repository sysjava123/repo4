package com.deyuan.service;

import com.deyuan.pojo.Permission;
import com.deyuan.pojo.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    List<Permission> findByOtherPermission(String id);

    void addPermissionToRole(String roleId, String[] permissionIds);

}
