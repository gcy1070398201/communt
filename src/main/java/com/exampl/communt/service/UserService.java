package com.exampl.communt.service;

import com.exampl.communt.dto.GitHubUserDto;
import com.exampl.communt.mapper.UserMapper;
import com.exampl.communt.mode.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    /**
     * 插入数据
     * @param gitHubUser
     */
    public void insertIntoUser(GitHubUserDto gitHubUser, HttpServletResponse response){

        User user=new User();
        user.setAccountId(gitHubUser.getId());
        user.setName(gitHubUser.getName());
        user.setToken(UUID.randomUUID().toString());
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        mapper.insertUser(user);
        //添加到Cookie
        response.addCookie(new Cookie("token",user.getToken()));
    }

    /**
     * 根据token 查找用户存在不存在
     * @param token
     * @return
     */
    public User findUserToken(String token){
        return mapper.findUserToken(token);
    }

}
