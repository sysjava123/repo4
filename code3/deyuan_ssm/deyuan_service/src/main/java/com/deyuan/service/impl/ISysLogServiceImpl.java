package com.deyuan.service.impl;

import com.deyuan.dao.ISysLogDao;
import com.deyuan.pojo.SysLog;
import com.deyuan.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ISysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao  sysLogDao;
    @Override
    public void save(SysLog sysLog)  {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return sysLogDao.findAll();
    }
}
