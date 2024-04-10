package com.yuda.houserent.service;

import com.yuda.houserent.BaseController.BaseService;
import com.yuda.houserent.entity.Order;

import java.util.List;

public interface OrderService extends BaseService<Order,Long> {
    //查询当前有效订单
    public Order getCurrentEffectiveOrder(Long houseId);
    //查询到期订单
    List<Order> findOverDueOrderList();
}
