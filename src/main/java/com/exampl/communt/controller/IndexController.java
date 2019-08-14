package com.exampl.communt.controller;

import com.exampl.communt.mapper.UserMapper;
import com.exampl.communt.mode.User;
import com.exampl.communt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String index(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
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
        return "index";
    }
}
