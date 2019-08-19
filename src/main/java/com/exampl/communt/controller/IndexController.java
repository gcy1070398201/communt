package com.exampl.communt.controller;

import com.exampl.communt.dto.PublishDto;
import com.exampl.communt.mode.User;
import com.exampl.communt.service.PublishService;
import com.exampl.communt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    PublishService publishService;

    @GetMapping("/index")
    public String index(HttpServletRequest request,
                        Model model){
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

        List<PublishDto> publishDtoList=publishService.select();

        model.addAttribute("lists",publishDtoList);

        return "index";
    }
}
