package com.pay.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * create by wenjie.mao
 * Date: 2019/10/8
 */
public abstract class BaseService{
    
    public BaseMapper baseMapper;

    @PostConstruct
    public abstract void setMap();
    
    
    public int insert(Object entity) {
        return baseMapper.insert(entity);
    }

    
    public int deleteById(Serializable id) {
        return baseMapper.deleteById(id);
    }

    
    public int delete(Wrapper wrapper) {
        return baseMapper.delete(wrapper);
    }

    
    public int updateById(Object entity) {
        return baseMapper.updateById(entity);
    }

    
    public int update(Object entity, Wrapper updateWrapper) {
        return baseMapper.update(entity,updateWrapper);
    }

    
    public Object selectById(Serializable id) {
        return baseMapper.selectById(id);
    }

    
    public Object selectOne(Wrapper queryWrapper) {
        return baseMapper.selectOne(queryWrapper);
    }

    
    public Integer selectCount(Wrapper queryWrapper) {
        return baseMapper.selectCount(queryWrapper);
    }

    
    public List selectList(Wrapper queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }

    
    public List<Map<String, Object>> selectMaps(Wrapper queryWrapper) {
        return baseMapper.selectMaps(queryWrapper);
    }

    
    public List<Object> selectObjs(Wrapper queryWrapper) {
        return baseMapper.selectObjs(queryWrapper);
    }

    
    public IPage selectPage(IPage page, Wrapper queryWrapper) {
        return baseMapper.selectPage(page, queryWrapper);
    }

    
    public IPage<Map<String, Object>> selectMapsPage(IPage page, Wrapper queryWrapper) {
        return baseMapper.selectMapsPage(page, queryWrapper);
    }

    
    public List selectByMap(Map columnMap) {
        return baseMapper.selectByMap(columnMap);
    }

    
    public List selectBatchIds(Collection idList) {
        return baseMapper.selectBatchIds(idList);
    }

    
    public int deleteBatchIds(Collection idList) {
        return baseMapper.deleteBatchIds(idList);
    }

    
    public int deleteByMap(Map columnMap) {
        return baseMapper.deleteByMap(columnMap);
    }
}
