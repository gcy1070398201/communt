package com.exampl.communt.controller;

import com.exampl.communt.dto.GitHubOauthDto;
import com.exampl.communt.provide.GitHubProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OAuthController {
    @Autowired
    GitHubProvide gitHubProvide;

    @GetMapping("/callback")
    public String oauth(@RequestParam("code") String code,
                        @RequestParam("state") String state){
        GitHubOauthDto gitHubOauthDto=new GitHubOauthDto();
        gitHubOauthDto.setCode(code);
        gitHubOauthDto.setState(state);
        gitHubOauthDto.setClient_id("Iv1.9459f0cd18246862");
        gitHubOauthDto.setClient_secret("b838edfa211981984ed88ea7f7f0b103d31d52f6");
        String token=gitHubProvide.getGitHubToken(gitHubOauthDto);
        System.out.println(token);
//        gitHubProvide.getGitHubUser(token);
       return "";
    }
}
