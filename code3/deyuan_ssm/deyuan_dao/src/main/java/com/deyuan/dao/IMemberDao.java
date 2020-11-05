package com.deyuan.dao;

import com.deyuan.pojo.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberDao {
    //查询单挑
    @Select("select * from member where id=#{id}")
    Member findById(String id)throws Exception;
}