package com.exampl.communt.controller;

import com.exampl.communt.dto.GitHubOauthDto;
import com.exampl.communt.dto.GitHubUserDto;
import com.exampl.communt.provide.GitHubProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("/callback")
    public String oauth(@RequestParam("code") String code,
                        @RequestParam("state") String state,
                        HttpServletRequest request){

        GitHubOauthDto gitHubOauthDto=new GitHubOauthDto();
        gitHubOauthDto.setCode(code);
        gitHubOauthDto.setState(state);
        gitHubOauthDto.setRedirect_uri(redirectUri);
        gitHubOauthDto.setClient_id(clientId);
        gitHubOauthDto.setClient_secret(clientSecret);
        String token=gitHubProvide.getGitHubToken(gitHubOauthDto);
        System.out.println(token);
        GitHubUserDto user=gitHubProvide.getGitHubUser(token);
        System.out.println(user);
        if (user!=null){
            //登录成功
            request.getSession().setAttribute("user",user);

            return "redirect:index";
        }else{
            //登录失败
            return "redirect:index";
        }

    }
}
