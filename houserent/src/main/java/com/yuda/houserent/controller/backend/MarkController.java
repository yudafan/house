package com.yuda.houserent.controller.backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuda.houserent.BaseController.BaseController;
import com.yuda.houserent.dto.JsonResult;
import com.yuda.houserent.entity.Mark;
import com.yuda.houserent.service.HouseService;
import com.yuda.houserent.service.MarkService;
import com.yuda.houserent.service.UserService;
import com.yuda.houserent.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller("backMarkController")
public class MarkController extends BaseController {
    @Autowired
    private MarkService markService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private UserService userService;
    /**
     * 我的收藏列表
     */
    @RequestMapping("/admin/mark")
    public String markList(@RequestParam(value = "page",defaultValue = "1")Long pageNumber, @RequestParam(value = "size",defaultValue = "6")Long pageSize, Model model) {
        Page page = PageUtil.initMapPage(pageNumber, pageSize);
        Mark condition = new Mark();
        condition.setUserId(getLoginUserId());
        Page<Mark> markPage=markService.findAll(page,condition);
        for (Mark mark:markPage.getRecords()){
            mark.setHouse(houseService.get(mark.getHouseId()));
        }
        model.addAttribute("pageInfo",markPage);
        model.addAttribute("tab","mark-list");
        model.addAttribute("pagePrefix","/admin/mark?");
        return "admin/mark-list";
    }
    /*
    取消收藏
     */
    @RequestMapping(value = "/admin/mark/cancel",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult cancelMark(@RequestParam("id")Long id){
        Mark mark=markService.get(id);
        if (mark==null||!Objects.equals(mark.getUserId(),getLoginUserId())){
            return JsonResult.error("取消收藏失败");
        }
        markService.delete(id);
        return JsonResult.success("取消收藏成功");
    }
}

