package com.exampl.communt.controller;

import com.exampl.communt.dto.ProfileQuestionsDto;
import com.exampl.communt.dto.PubLishListDto;
import com.exampl.communt.mode.User;
import com.exampl.communt.service.PublishService;
import com.exampl.communt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    UserService userService;

    @Autowired
    PublishService publishService;

    @GetMapping(value = "/profile/{action}")
    public String profile(@PathVariable(value = "action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(value = "page",defaultValue = "1") Integer page,
                          @RequestParam(value = "size",defaultValue = "2") Integer size){

        if (action.equals("questions")){
            model.addAttribute("actionCode","1");
            model.addAttribute("actionName","我的问题");
            model.addAttribute("actions","questions");
        }else if (action.equals("replies")){
            model.addAttribute("actionCode","2");
            model.addAttribute("actionName","我的回复");
            model.addAttribute("actions","replies");
        }


        ProfileQuestionsDto profileQuestionsDto=publishService.selectUserQuestion(page,size);
        model.addAttribute("profileQuestionsDto",profileQuestionsDto);


        return "profile";
    }
}
