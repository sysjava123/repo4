package com.deyuan.contorller;

import com.deyuan.pojo.Permission;
import com.deyuan.pojo.Role;
import com.deyuan.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleConterller {
    @Autowired
    private IRoleService roleService;

    //权限角色操作
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionIds) {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";

    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleId", id);
        List<Permission> list = roleService.findByOtherPermission(id);
        mv.addObject("permissionList", list);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/findAll")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> list = roleService.findAll();
        mv.addObject("roleList", list);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }
}
