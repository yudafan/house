package com.yuda.houserent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuda.houserent.entity.Feedback;
import com.yuda.houserent.mapper.FeedbackMapper;
import com.yuda.houserent.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Override
    public BaseMapper<Feedback> getRepository() {
        return feedbackMapper;
    }

    @Override
    public QueryWrapper<Feedback> getQueryWrapper(Feedback feedback) {
        QueryWrapper<Feedback> queryWrapper=new QueryWrapper<>();
        if (feedback!=null&&feedback.getUserId()!=null){
            queryWrapper.eq("user_id",feedback.getUserId());
        }
        return queryWrapper;
    }

    @Override
    public QueryWrapper<Feedback> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }



}
