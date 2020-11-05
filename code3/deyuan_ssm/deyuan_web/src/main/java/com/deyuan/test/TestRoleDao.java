package com.deyuan.test;


import com.deyuan.dao.IRoleDao;
import com.deyuan.dao.IUserDao;
import com.deyuan.pojo.Role;
import com.deyuan.pojo.UserInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestRoleDao {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*IRoleDao roleDao = context.getBean(IRoleDao.class);
        List<Role> list = roleDao.findAll();
        for (Role role : list) {
            System.out.println(role.getRoleName());
        }*/
        IUserDao bean = context.getBean(IUserDao.class);
        UserInfo userInfo = bean.findById("1");
        System.out.println(userInfo.getUsername());
        List<Role> roles = userInfo.getRoles();
        for (Role role : roles) {
            System.out.println(role.getRoleName());
        }
    }
}
