package com.exampl.communt.controller;

import com.exampl.communt.dto.PublishDto;
import com.exampl.communt.exception.AcmeException;
import com.exampl.communt.exception.AcmeExceptionCode;
import com.exampl.communt.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    @Autowired
    PublishService publishService;

    @GetMapping(value = "/question/{id}")
    public String question(@PathVariable("id") long id,
                           Model model){

        PublishDto publishDto=publishService.selectByIdInfo(id);
        //累加评论
        publishService.incView(id);
        model.addAttribute("publishDto",publishDto);
        return "question";
    }

}
