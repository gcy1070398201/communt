package com.exampl.communt.controller;

import com.exampl.communt.mode.PublishMode;
import com.exampl.communt.mode.User;
import com.exampl.communt.service.PublishService;
import com.exampl.communt.service.UserService;
import org.attoparser.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 提问页面Controller
 */
@Controller
public class PublishController {


    @Autowired
    PublishService publishService;
    @Autowired
    UserService userService;

    @GetMapping(value = "/publish")
    public String publish(@RequestParam(value = "id",defaultValue = "0") Integer id,
                          Model model){
        PublishMode publishMode=new PublishMode();
        if (id!=0){
            publishMode=publishService.createOrUpdate(id,publishMode);
        }
        model.addAttribute("publishMode",publishMode);
        return"publish";
    }

    /**
     * 提交问题
     * @param title
     * @param describe
     * @param label
     * @return
     */
    @PostMapping(value ="/publish")
    public String publish(@RequestParam String title,
                          @RequestParam String describe,
                          @RequestParam String label,
                          HttpServletRequest request,
                          Model model){
        if (StringUtils.isEmpty(title)){
            model.addAttribute("error","title 不能为空");
            return "/publish";
        }
        if (StringUtils.isEmpty(describe)){
            model.addAttribute("error","内容 不能为空");
            return "/publish";
        }
        if (StringUtils.isEmpty(label)){
            model.addAttribute("error","标签 不能为空");
            return "/publish";
        }
        User user= (User) request.getSession().getAttribute("user");
        if (user==null){
            return "redirect:index";
        }
        PublishMode publishMode=new PublishMode();
        publishMode.setTitle(title);
        publishMode.setDescribeText(describe);
        publishMode.setLabel(label);
        publishMode.setGmtCreate(System.currentTimeMillis());
        publishMode.setGmtModified(publishMode.getGmtCreate());
        publishMode.setCreatId(String.valueOf(user.getId()));

        publishService.insert(publishMode);

        return "redirect:index";
    }

}
