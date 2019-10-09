package com.pay.controller;

import com.pay.dao.PayDao;
import com.pay.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by wenjie.mao
 * Date: 2019/9/19
 */
@RestController
@RequestMapping("/")
public class ApiController {

    @Autowired
    private PayDao payDao;

    @RequestMapping("/")
    public List<Entity> test(){
        return payDao.list();
    }


    @RequestMapping("start")
    public void s(@RequestBody Map map){
        System.out.println(map);
    }


    @RequestMapping("check")
    public Map c(@RequestBody Map map){
        System.out.println(map);
        Map rtn = new HashMap();
        rtn.put("status","3");
        return rtn;
    }


}
