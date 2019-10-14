package com.exampl.communt.controller;

import com.exampl.communt.dto.CommentDto;
import com.exampl.communt.exception.AcmeException;
import com.exampl.communt.exception.AcmeExceptionCode;
import com.exampl.communt.mode.BaseMode;
import com.exampl.communt.mode.User;
import com.exampl.communt.service.CommentService;
import com.exampl.communt.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;



    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDto commentDto, HttpServletRequest httpServletRequest){
        User user= (User) httpServletRequest.getSession().getAttribute("user");
//        if (user==null){
//            return ResultUtil.errorOf(AcmeExceptionCode.USER_LOGIN_ERROR_CODE);
//        }
        commentService.insert(commentDto);

        return ResultUtil.okOf();
    }
}
