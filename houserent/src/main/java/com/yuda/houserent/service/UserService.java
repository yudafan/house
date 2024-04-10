package com.yuda.houserent.service;

import com.yuda.houserent.BaseController.BaseService;
import com.yuda.houserent.entity.User;

public interface UserService extends BaseService<User,Long> {
    //根据用户名查询用户
    public User findByUserName(String userName);

}
