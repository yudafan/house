package com.yuda.houserent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuda.houserent.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback> {
    int updateById(Feedback record);
}
