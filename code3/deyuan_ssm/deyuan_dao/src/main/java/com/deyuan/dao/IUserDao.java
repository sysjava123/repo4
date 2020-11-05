package com.deyuan.dao;

import com.deyuan.pojo.Orders;
import com.deyuan.pojo.Role;
import com.deyuan.pojo.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    @Select("select * from users where username=#{name}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.deyuan.dao.IRoleDao.findUserByRole")),

    })
    UserInfo findUserByPwd(String name);

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(id,username,password,email,phoneNum,status)values(role_s.nextval,#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.deyuan.dao.IRoleDao.findUserByRole"))
    })
    UserInfo findById(String id) throws Exception;

    //查询这个用户中没有的其他角色
    @Select("select * from role where id not in (select roleId from users_role where userId =#{id})")
    List<Role> findOtherRoles(String id);


    @Insert("insert into users_role (userId,roleId)values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
