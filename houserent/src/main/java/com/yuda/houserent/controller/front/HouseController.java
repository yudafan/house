package com.yuda.houserent.controller.front;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuda.houserent.BaseController.BaseController;
import com.yuda.houserent.entity.House;
import com.yuda.houserent.entity.Order;
import com.yuda.houserent.entity.User;
import com.yuda.houserent.enums.HouseRentTypeEnum;
import com.yuda.houserent.service.HouseService;
import com.yuda.houserent.service.OrderService;
import com.yuda.houserent.service.UserService;
import com.yuda.houserent.util.PageUtil;
import com.yuda.houserent.vo.HouseSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
前台房子信息控制器
 */
@Controller("frontHouseController")
public class HouseController extends BaseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    /*
    房子详情
     */
    @RequestMapping("/house/detail/{id}")
    public String houseDetail(@PathVariable("id")Long id, Model model){
        //根据id查询房子
        House house=houseService.get(id);
        if (house==null){
            return renderNotFound();
        }
        //处理轮播图URL
        List<String> slideList=JSON.parseArray(house.getSlideUrl(),String.class);
        house.setSlideImgList(slideList);
        //如果是合租，查询合租房子
        List<House> shareHouseList=houseService.findByUserIdAndCetificateNoAndRentType(house.getUserId(),house.getCetificateNo(), HouseRentTypeEnum.SHARE.getValue());
        //从订单里查找到租户id，把租户放到每个房子里
        if (shareHouseList!=null&&shareHouseList.size()>0){
            for (House houseTemp : shareHouseList){
                Order currentOrder=orderService.getCurrentEffectiveOrder(houseTemp.getId());
                if (currentOrder!=null){
                    User customerUser=userService.get(currentOrder.getCustomerUserId());
                    currentOrder.setCustomerUser(customerUser);
                    houseTemp.setCurrentOrder(currentOrder);
                }
            }
        }
        house.setShareHouseList(shareHouseList);
        model.addAttribute("house",house);

        return "front/house-detail";
    }


    /*
    房子地图页面
     */
    @RequestMapping("/house/map")
    public  String map(@RequestParam("id")Long id,Model model){
        //根据id查询房子
        House house=houseService.get(id);
        if (house==null){
            return renderNotFound();
        }
        String longitudeLatitude=house.getLongitudeLatitude();
        String[] arr=longitudeLatitude.split(",");
        model.addAttribute("longitude",arr[0]);
        model.addAttribute("latitude",arr[1]);
        model.addAttribute("address",house.getAddress());
        return "front/house-map";
    }
    /**
     * 房子列表
     */
    @RequestMapping("/house")
    public String houseList(HouseSearchVO houseSearchVO,Model model){
        Page page= PageUtil.initMapPage(houseSearchVO.getPage(),houseSearchVO.getSize());
        Page<House> housePage=houseService.getHousePage(houseSearchVO,page);
        model.addAttribute("pageInfo",housePage);
        model.addAttribute("houseSearchVO",houseSearchVO);
        model.addAttribute("pagePrefix",houseSearchVO.getPagePrefix());
        return "front/house-list";
    }

}
