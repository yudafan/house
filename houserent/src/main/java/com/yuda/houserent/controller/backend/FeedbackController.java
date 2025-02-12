package com.yuda.houserent.controller.backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuda.houserent.BaseController.BaseController;
import com.yuda.houserent.dto.JsonResult;
import com.yuda.houserent.entity.Feedback;
import com.yuda.houserent.mapper.FeedbackMapper;
import com.yuda.houserent.service.FeedbackService;
import com.yuda.houserent.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * 后台反馈管理控制器
 */
@Controller("backFeedbackController")
public class FeedbackController extends BaseController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private FeedbackMapper feedbackMapper;
    //进入反馈管理页面
    @RequestMapping("/admin/feedback")
    public String feedback(@RequestParam(value = "page",defaultValue = "1")Long pageNumber, @RequestParam(value = "size",defaultValue = "6")Long pageSize, Model model){
        Page page= PageUtil.initMapPage(pageNumber,pageSize);
        Feedback condition=new Feedback();
        //如果不是管理员，只能查询直接的反馈
        if (!loginUserIsAdmin()){
            condition.setUserId(getLoginUserId());
        }
        Page<Feedback> feedbackPage=feedbackService.findAll(page,condition);
        model.addAttribute("pageInfo",feedbackPage);
        model.addAttribute("pagePrefix","/feedback?");
        model.addAttribute("tab","feedback-list");
        model.addAttribute("isAdmin",loginUserIsAdmin());
        return "admin/feedback-list";
    }
    /**
     * 回复反馈
     */
    @RequestMapping(value = "/admin/feedback/reply/submit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult replySubmit(Feedback feedback){
            feedbackService.update(feedback);
        return JsonResult.success("保存成功");
    }

    /*
删除反馈
*/
    @RequestMapping("/admin/feedback/delete")
    @ResponseBody
    public JsonResult deleteFeedback(@RequestParam("id")Long id){
        try{
            Feedback feedback=feedbackService.get(id);
            if (feedback==null) {
                return JsonResult.error("反馈不存在");
            }
            if (!loginUserIsAdmin()&&!Objects.equals(feedback.getUserId(),getLoginUser())){
                return JsonResult.error("没有权限删除，这不是你的反馈");
            }
            feedbackService.delete(id);
        }catch (Exception e){
            return JsonResult.error("删除反馈失败");
        }
        return JsonResult.success("删除反馈成功");
    }
}
