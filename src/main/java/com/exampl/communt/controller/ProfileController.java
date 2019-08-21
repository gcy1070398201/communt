package com.exampl.communt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    @GetMapping(value = "/profile/{action}")
    public String profile(@PathVariable(value = "action") String action,
                          Model model){

        if (action.equals("questions")){
            model.addAttribute("actionCode","1");
            model.addAttribute("actionName","我的问题");
        }else if (action.equals("replies")){
            model.addAttribute("actionCode","2");
            model.addAttribute("actionName","我的回复");
        }

        return "profile";
    }
}
