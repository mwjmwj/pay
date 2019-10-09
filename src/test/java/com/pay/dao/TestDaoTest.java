package com.pay.dao;

import com.pay.PayApplicationTests;
import com.pay.service.impl.TestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by wenjie.mao
 * Date: 2019/10/8
 */
public class TestDaoTest extends PayApplicationTests {

    @Autowired
    private TestDao testDao;

    @Autowired
    private TestService TestService;

    @Test
    public void _1test(){
        TestService.selectById(1);
    }

}
