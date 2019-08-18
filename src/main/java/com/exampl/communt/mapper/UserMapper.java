package com.exampl.communt.mapper;

import com.exampl.communt.mode.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 插入数据
     * @return
     */
    void insertUser(User user);
    /**
     * 根据token获取信息
     * @return
     */
    User findUserToken(String token);
    /**
     * 根据id 获取信息
     * @return
     */
    User findUserId(String id);
}
