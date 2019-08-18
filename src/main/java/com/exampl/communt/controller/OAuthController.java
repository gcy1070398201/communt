package com.exampl.communt.controller;

import com.exampl.communt.dto.GitHubOauthDto;
import com.exampl.communt.dto.GitHubUserDto;
import com.exampl.communt.mode.User;
import com.exampl.communt.provide.GitHubProvide;
import com.exampl.communt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class OAuthController {
    @Autowired
    GitHubProvide gitHubProvide;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    UserService userService;

    @GetMapping("/callback")
    public String oauth(@RequestParam("code") String code,
                        @RequestParam("state") String state,
                        HttpServletResponse response){

        GitHubOauthDto gitHubOauthDto=new GitHubOauthDto();
        gitHubOauthDto.setCode(code);
        gitHubOauthDto.setState(state);
        gitHubOauthDto.setRedirect_uri(redirectUri);
        gitHubOauthDto.setClient_id(clientId);
        gitHubOauthDto.setClient_secret(clientSecret);
        String token=gitHubProvide.getGitHubToken(gitHubOauthDto);
        GitHubUserDto gitHubUser=gitHubProvide.getGitHubUser(token);
        if (gitHubUser!=null){
            //登录成功
            userService.insertIntoUser(gitHubUser,response);

            return "redirect:index";
        }else{
            //登录失败
            return "redirect:index";
        }

    }
}
