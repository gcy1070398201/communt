package com.exampl.communt.controller;

import com.exampl.communt.exception.AcmeExceptionCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 定义错误Controller
 */
@Controller("/error")
public class AcmeErrorController implements ErrorController {

    @Override
    public String getErrorPath() {

        return "error";
    }
    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletRequest request, Model model) {
        HttpStatus status = getStatus(request);
        if (status.is4xxClientError()){
            model.addAttribute("messgae",AcmeExceptionCode.ACME_EXCEPTION_CODE.getMessage());
        }
        if (status.is5xxServerError()){
            model.addAttribute("message", AcmeExceptionCode.SYSTEM_ERROR_CODE.getMessage());
        }
        return new ModelAndView("error");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
