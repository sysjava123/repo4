package com.deyuan.dao;

import com.deyuan.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("productDao")
public interface IProductDao {
    //查询单挑
    @Select("select * from product where id=#{id}")
    Product findById(String id);

    //查询全部
    @Select("select * from product")
    List<Product> findAll() ;

    //添加单挑
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}