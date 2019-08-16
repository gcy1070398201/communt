package com.exampl.communt.mapper;

import com.exampl.communt.mode.PublishMode;

import java.util.List;

public interface PublishMapper {

    /**
     * 插入信息
     * @return
     */
    void insert(PublishMode user);

    /**
     * 查询全部
     * @return
     */
    List<PublishMode> select();
}
