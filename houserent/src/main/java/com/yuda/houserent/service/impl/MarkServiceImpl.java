package com.yuda.houserent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuda.houserent.entity.Mark;
import com.yuda.houserent.mapper.MarkMapper;
import com.yuda.houserent.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/*
收藏层service
 */
@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkMapper markMapper;
    @Override
    public BaseMapper<Mark> getRepository() {
        return markMapper;
    }

    @Override
    public QueryWrapper<Mark> getQueryWrapper(Mark mark) {
        QueryWrapper queryWrapper=new QueryWrapper();
        if (mark!=null){
            if (mark.getUserId()!=null){
                queryWrapper.eq("user_id",mark.getUserId());
            }
            if (mark.getHouseId()!=null){
                queryWrapper.eq("house_id",mark.getHouseId());
            }
        }
        return queryWrapper;
    }

    @Override
    public QueryWrapper<Mark> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }

    @Override
    public List<Mark> findByUserIdAndHouseId(Long userId, Long houseId) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("house_id",houseId);
        return markMapper.selectList(queryWrapper);
    }
}
