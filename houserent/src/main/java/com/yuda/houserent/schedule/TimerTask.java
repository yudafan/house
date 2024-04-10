package com.yuda.houserent.schedule;

import com.yuda.houserent.entity.House;
import com.yuda.houserent.entity.Order;
import com.yuda.houserent.enums.HouseStatusEnum;
import com.yuda.houserent.enums.OrderStatusEnum;
import com.yuda.houserent.service.HouseService;
import com.yuda.houserent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimerTask {
    @Autowired
    private OrderService orderService;
    @Autowired
    private HouseService houseService;
    //每分钟执行一次
    @Scheduled(cron = "0 */1 * * * ?")
    public void endOrderTimer(){
        List<Order> list=orderService.findOverDueOrderList();
        if (list==null || list.size()==0){
            return;
        }
        for (Order order:list){
            //更新订单为已到期
            order.setStatus(OrderStatusEnum.FINISH.getValue());
            orderService.update(order);
            //更新房子状态为未出组
            House house=houseService.get(order.getHouseId());
            if (house!=null){
                house.setStatus(HouseStatusEnum.NOT_RENT.getValue());
                houseService.update(house);
            }
        }

    }
}
