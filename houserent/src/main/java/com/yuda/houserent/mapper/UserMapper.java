package com.yuda.houserent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuda.houserent.entity.User;
import org.apache.ibatis.annotations.Mapper;
/*
用户数据访问层
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
