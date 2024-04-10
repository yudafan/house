package com.yuda.houserent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuda.houserent.entity.News;
import com.yuda.houserent.mapper.NewsMapper;
import com.yuda.houserent.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public BaseMapper<News> getRepository() {
        return newsMapper;
    }

    @Override
    public QueryWrapper<News> getQueryWrapper(News news) {
        QueryWrapper<News> queryWrapper=new QueryWrapper<>();
        return queryWrapper;
    }

    @Override
    public QueryWrapper<News> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }
}
