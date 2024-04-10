package com.yuda.houserent.interceptor;

import com.yuda.houserent.constant.Constant;
import com.yuda.houserent.entity.User;
import com.yuda.houserent.enums.UserRoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user= (User) request.getSession().getAttribute(Constant.SESSION_USER_KEY);
        //如果用户未登录，拦截
        if (user==null){
            response.sendRedirect("/");
            return false;
        }
        //如果用户不是管理员，拦截
        if (!UserRoleEnum.ADMIN.getValue().equalsIgnoreCase(user.getRole())){
            return false;
        }
        return true;
    }
}
