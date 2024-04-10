package com.yuda.houserent.controller.front;

import com.yuda.houserent.BaseController.BaseController;
import com.yuda.houserent.constant.Constant;
import com.yuda.houserent.enums.HouseRentTypeEnum;
import com.yuda.houserent.service.HouseService;
import com.yuda.houserent.service.OrderService;
import com.yuda.houserent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
前端首页控制器
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private UserService userService;
    /*
    前端首页
     */
    @RequestMapping("/")
    public String index(Model model){
        //最新整租
        model.addAttribute("rencentWholeHouseList",houseService.findTopList(HouseRentTypeEnum.WHOLE.getValue(), Constant.INDEX_HOUSE_NUM));
        //最新合租
        model.addAttribute("rencentShareHouseList",houseService.findTopList(HouseRentTypeEnum.SHARE.getValue(), Constant.INDEX_HOUSE_NUM));
        return "front/index";
    }
}
