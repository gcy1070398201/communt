package com.exampl.communt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PublishController {

    @GetMapping(value = "/publish")
    public String publish(){
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
                          @RequestParam String label){

        return "";
    }

}
