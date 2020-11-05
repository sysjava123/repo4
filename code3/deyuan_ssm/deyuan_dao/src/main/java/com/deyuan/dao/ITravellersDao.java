package com.deyuan.dao;

import com.deyuan.pojo.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITravellersDao {
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{id})")
    List<Traveller> findById(String id);
}
