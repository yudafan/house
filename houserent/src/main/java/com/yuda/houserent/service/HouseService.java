package com.yuda.houserent.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuda.houserent.BaseController.BaseService;
import com.yuda.houserent.entity.House;
import com.yuda.houserent.vo.HouseSearchVO;

import java.util.List;

/*
房子服务接口
 */
public interface HouseService extends BaseService<House,Long> {
    //根据用户id和房产编号查询合租房子
    List<House> findByUserIdAndCetificateNoAndRentType(Long userId,String cetificateNo,String rentType);
    /*
    根据出租类型获取最新的n条房子信息

     */
    public List<House> findTopList(String rentType, Integer limit);
    //获得房子分页数据
    Page<House> getHousePage(HouseSearchVO houseSearchVO,Page<House> page);

}
