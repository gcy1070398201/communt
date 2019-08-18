package com.exampl.communt.mapper;

import com.exampl.communt.mode.PublishMode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
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
