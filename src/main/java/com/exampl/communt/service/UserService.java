package com.exampl.communt.service;

import com.exampl.communt.dto.GitHubUserDto;
import com.exampl.communt.mapper.UserMapper;
import com.exampl.communt.mode.User;
import com.exampl.communt.mode.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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
        UserExample userExample=new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(gitHubUser.getId());
        List<User> list=mapper.selectByExample(userExample);
        if (list.size()==0){
            return;
        }
        User dbuser = list.get(0);
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
            mapper.insert(user);
        }else{
            //更新用户信息
            User updateUser=new User();
            updateUser.setToken(token);
            updateUser.setBio(gitHubUser.getBio());
            updateUser.setName(gitHubUser.getName());
            updateUser.setGmtModified(System.currentTimeMillis());

            UserExample userUpdate=new UserExample();
            userUpdate.createCriteria().andIdEqualTo(dbuser.getId());

            mapper.updateByExampleSelective(updateUser,userUpdate);
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
        UserExample userExample=new UserExample();
        userExample.createCriteria().andTokenEqualTo(token);
        List<User> list= mapper.selectByExample(userExample);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据id 获取用户信息
     * @param id
     * @return
     */
    public User findUserId(String id){
        UserExample userExample=new UserExample();
        userExample.createCriteria()
                .andIdEqualTo(Integer.valueOf(id));
        List<User> list=mapper.selectByExample(userExample);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }

}
