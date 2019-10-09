package com.pay.service.impl;

import com.pay.dao.TestDao;
import com.pay.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * create by wenjie.mao
 * Date: 2019/10/8
 */
@Service
public class TestService extends BaseService {

    @Autowired
    private TestDao dao;

    @Override
    public void setMap() {
        this.baseMapper = dao;
    }

}
