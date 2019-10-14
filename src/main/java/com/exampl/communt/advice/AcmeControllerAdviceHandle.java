package com.exampl.communt.advice;

import com.exampl.communt.exception.AcmeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AcmeControllerAdviceHandle {


    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(Throwable e,
                                           Model model,
                                           HttpServletRequest httpServletRequest) {

        if (e instanceof AcmeException){
            model.addAttribute("message",e.getMessage());
        }else{
            model.addAttribute("message",e);
        }
        return new ModelAndView("error");
    }
}
