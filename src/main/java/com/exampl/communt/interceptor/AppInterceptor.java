package com.exampl.communt.interceptor;

import com.exampl.communt.mode.User;
import com.exampl.communt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 添加登录拦截器
 */
@Component
public class AppInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookies=request.getCookies();
        if (cookies!=null&&cookies.length!=0)
            for (int i=0;i<cookies.length;i++){
                if (cookies[i].getName().equals("token")){
                    User user=userService.findUserToken(cookies[i].getValue());
                    if (user!=null){
                        //写入Session中
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
