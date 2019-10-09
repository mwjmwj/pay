package com.pay.dao;

import com.pay.entity.Entity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * create by wenjie.mao
 * Date: 2019/9/19
 */
public interface PayDao {
    List<Entity> list();
}
