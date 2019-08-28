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
    public void createOrUpdateUser(GitHubUserDto gitHubUser, HttpServletResponse response){

        User dbuser = mapper.findAccountId(gitHubUser.getId());
        String token=UUID.randomUUID().toString();
        if (dbuser==null){
            User user=new User();
            user.setAccountId(gitHubUser.getId());
            user.setName(gitHubUser.getName());
            user.setToken(token);
            user.setAvatarUrl(gitHubUser.getAvatar_url());
            user.setBio(gitHubUser.getBio());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            mapper.insertUser(user);
        }else{
            //更新用户信息
            dbuser.setToken(token);
            dbuser.setBio(gitHubUser.getBio());
            dbuser.setName(gitHubUser.getName());
            dbuser.setGmtModified(System.currentTimeMillis());
            mapper.createOrUpdate(dbuser);

        }
        //添加到Cookie
        response.addCookie(new Cookie("token",token));
    }

    /**
     * 根据token 查找用户存在不存在
     * @param token
     * @return
     */
    public User findUserToken(String token){
        return mapper.findUserToken(token);
    }

    /**
     * 根据id 获取用户信息
     * @param id
     * @return
     */
    public User findUserId(String id){

        return mapper.findUserId(id);
    }

}
