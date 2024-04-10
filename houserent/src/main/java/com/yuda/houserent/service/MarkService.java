package com.yuda.houserent.service;

import com.yuda.houserent.BaseController.BaseService;
import com.yuda.houserent.entity.Mark;

import java.util.List;

public interface MarkService extends BaseService<Mark,Long> {
    //根据用户id和房子id查询该用户是否已经收藏过该房子
    List<Mark> findByUserIdAndHouseId(Long userId,Long houseId);
}
