package com.yuda.houserent.BaseController;

import com.yuda.houserent.constant.Constant;
import com.yuda.houserent.entity.User;
import com.yuda.houserent.enums.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/*
所有controller控制器的基类
 */
@Controller
public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    /*
    获得当前登录用户
     */
    public User getLoginUser(){
        User user= (User) request.getSession().getAttribute(Constant.SESSION_USER_KEY);
        return user;
    }
    /*
    获取当前用户id
     */
    public Long getLoginUserId(){
        User user=getLoginUser();
        if (user==null){
            return null;
        }
        return user.getId();
    }
    //当前用户时管理员
    public Boolean loginUserIsAdmin(){
        User user=getLoginUser();
        if (user==null){
            return false;
        }
        return UserRoleEnum.ADMIN.getValue().equalsIgnoreCase(user.getRole());
    }
    //当前用户时房东
    public Boolean loginUserIsCustomer(){
        User user=getLoginUser();
        if (user==null){
            return false;
        }
        return UserRoleEnum.CUSTOMER.getValue().equalsIgnoreCase(user.getRole());
    }
    //当前用户时管理员
    public Boolean loginUserIsOwner(){
        User user=getLoginUser();
        if (user==null){
            return false;
        }
        return UserRoleEnum.OWNER.getValue().equalsIgnoreCase(user.getRole());
    }
    /*
    渲染404页面
     */
    public String renderNotFound(){
        return "forward:/404";
    }
    /*
   渲染403页面
    */
    public String renderNotAllowAccess(){
        return "forward:/403";
    }
    /*
   渲染500页面
    */
    public String renderServerException(){
        return "forward:/500";
    }
    /*
   渲染error页面
    */
    public String renderError(){
        return "forward:/error";
    }
}
