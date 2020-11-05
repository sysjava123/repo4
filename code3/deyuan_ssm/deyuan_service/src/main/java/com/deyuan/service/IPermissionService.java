package com.deyuan.service;

import com.deyuan.pojo.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll()throws Exception;

    void save(Permission permission);
}
