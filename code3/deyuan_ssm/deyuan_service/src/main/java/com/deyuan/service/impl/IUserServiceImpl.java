package com.deyuan.service.impl;

import com.deyuan.dao.IUserDao;
import com.deyuan.pojo.Orders;
import com.deyuan.pojo.Role;
import com.deyuan.pojo.UserInfo;
import com.deyuan.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findUserByPwd(name);
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getGrantedAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getGrantedAuthority(List<Role> roleList) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roleList) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));

        }
        return list;
    }

    @Override
    public List<UserInfo> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(String id) {
        return userDao.findOtherRoles(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] roles) {
        for (String roleId : roles) {
            userDao.addRoleToUser(userId, roleId);
        }
    }
}
