package com.yuda.houserent.controller.backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuda.houserent.BaseController.BaseController;
import com.yuda.houserent.entity.Order;
import com.yuda.houserent.enums.OrderStatusEnum;
import com.yuda.houserent.service.HouseService;
import com.yuda.houserent.service.OrderService;
import com.yuda.houserent.service.UserService;
import com.yuda.houserent.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 我的家的控制器
 */
@Controller("backHomeController")
public class HomeController  extends BaseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @RequestMapping("/admin/home")
    public String home(@RequestParam(value = "page",defaultValue = "1")Long pageNumber, @RequestParam(value = "size",defaultValue = "6")Long pageSize, Model model){
        Page page= PageUtil.initMapPage(pageNumber,pageSize);
        Order condition=new Order();
        condition.setCustomerUserId(getLoginUserId());
        condition.setStatus(OrderStatusEnum.NORMAL.getValue());
        Page<Order> orderPage=orderService.findAll(page,condition);
        for (Order order:orderPage.getRecords()){
            //todo 这里地方性能优化
            order.setHouse(houseService.get(order.getHouseId()));   //todo 优化方案 id in（‘1’ ‘2’ ‘3’）
            order.setOwnerUser(userService.get(order.getOwnerUserId()));
        }
        model.addAttribute("pageInfo",orderPage);
        model.addAttribute("tab","home");
        model.addAttribute("pagePrefix","/admin/home?");

        return "admin/my-home";
        }
    }

