package com.yuda.houserent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuda.houserent.entity.User;
import com.yuda.houserent.mapper.UserMapper;
import com.yuda.houserent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //mapper对象
    @Override
    public BaseMapper<User> getRepository() {
        return userMapper;
    }

    @Override
    public QueryWrapper<User> getQueryWrapper(User user) {
        return null;
    }

    @Override
    public QueryWrapper<User> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        return userMapper.selectOne(queryWrapper);
    }
}
