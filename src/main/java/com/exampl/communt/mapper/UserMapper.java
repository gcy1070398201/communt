package com.exampl.communt.mapper;

import com.exampl.communt.mode.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void inserUser(User user);

    User findUserToken(String token);
}
