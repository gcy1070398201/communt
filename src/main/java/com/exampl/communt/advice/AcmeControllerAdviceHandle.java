package com.exampl.communt.advice;

import com.alibaba.fastjson.JSON;
import com.exampl.communt.exception.AcmeException;
import com.exampl.communt.exception.AcmeExceptionCode;
import com.exampl.communt.util.ResultUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class AcmeControllerAdviceHandle {


    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(Throwable e,
                                           Model model,
                                           HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse) {
        String contentType = httpServletRequest.getContentType();
        if (contentType.equals("text/plain")){
            if (e instanceof AcmeException){
                model.addAttribute("message",e.getMessage());
            }else{
                model.addAttribute("message",AcmeExceptionCode.SYSTEM_ERROR_CODE.getMessage());
            }
            return new ModelAndView("error");
        }else{
            ResultUtil resultUtil=null;
            if (e instanceof AcmeException){
                resultUtil= ResultUtil.errorOf((AcmeException) e);
            }else{
                resultUtil= ResultUtil.errorOf(AcmeExceptionCode.SYSTEM_ERROR_CODE);
            }
            try {
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setStatus(200);
                httpServletResponse.setCharacterEncoding("UTF-8");
                PrintWriter writer = httpServletResponse.getWriter();
                writer.write(JSON.toJSONString(resultUtil));
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }
}
