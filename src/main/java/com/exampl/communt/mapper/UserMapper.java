package com.exampl.communt.mapper;

import com.exampl.communt.mode.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserMapper {

    void insertUser(User user);

    User findUserToken(String token);
}
