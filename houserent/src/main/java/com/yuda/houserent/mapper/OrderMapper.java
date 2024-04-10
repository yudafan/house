package com.yuda.houserent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuda.houserent.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    //查询到期订单
    @Select("select *from t_order where status=0 and end_date<now()")
    List<Order> findOverDueOrderList();
}
