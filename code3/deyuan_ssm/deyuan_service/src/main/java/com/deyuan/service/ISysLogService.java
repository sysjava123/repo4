package com.deyuan.service;

import com.deyuan.pojo.SysLog;

import java.util.List;

public interface ISysLogService {
    void save(SysLog sysLog);

    List<SysLog> findAll(Integer page,Integer size) throws Exception;
}
