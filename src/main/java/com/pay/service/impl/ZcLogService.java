package com.pay.service.impl;

import com.pay.dao.ZcLogMapper;
import com.pay.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by wenjie.mao
 * Date: 2019/10/9
 */
@Service
public class ZcLogService extends BaseService {

    @Autowired
    private ZcLogMapper zcLogMapper;

    @Override
    public void setMap() {
        this.baseMapper = zcLogMapper;
    }
}
