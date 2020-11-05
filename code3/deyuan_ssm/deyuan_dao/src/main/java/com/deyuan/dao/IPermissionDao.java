package com.deyuan.dao;

import com.deyuan.pojo.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission>findById(String roleId);
    //查询
    @Select("select * from permission ")
    List<Permission> findAll();

    @Insert("insert into permission(id,permissionName,url)values(role_s.nextval,#{permissionName},#{url})")
    void save(Permission permission);
}
