package com.exampl.communt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublishController {

    @GetMapping(value = "/publish")
    public String publish(){
        return"publish";
    }

}
