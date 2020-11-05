package com.deyuan.contorller;


import com.deyuan.pojo.Orders;
import com.deyuan.pojo.Product;
import com.deyuan.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductConterller {
    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "4")Integer size){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> list = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        modelAndView.addObject("productList",pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
    @RequestMapping("/save")
    @PreAuthorize("authentication.principal.username=='cctv'")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }
}
