package com.deyuan.service;

import com.deyuan.pojo.Orders;
import com.deyuan.pojo.Role;
import com.deyuan.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(int page,int size) throws Exception;

    void save(UserInfo userInfo)throws Exception;

    UserInfo findById(String id)throws Exception;

    List<Role> findOtherRoles(String id);

    void addRoleToUser(String userId, String[] roles);
}
