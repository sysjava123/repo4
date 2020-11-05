package com.deyuan.dao;

import com.deyuan.pojo.Permission;
import com.deyuan.pojo.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {
    //    用户详情
    @Select("select * from role where id in (select roleid from users_role where userid = #{userid})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.deyuan.dao.IPermissionDao.findById")),
    })
    List<Role> findUserByRole(String userid) throws Exception;

    //查询所有角色
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    //添加角色
    @Insert("insert into role (id,roleName,roleDesc)values(role_s.nextval,#{roleName},#{roleDesc})")
    void save(Role role);


    @Select("select * from permission where id not in (select permissionId from role_permission where roleId =#{id})")
    List<Permission> findByOtherPermission(String id);
    //insert into role_permission (permissionId,roleId)values('666','2')
    @Insert("insert into role_permission (PERMISSIONID,ROLEID)values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
