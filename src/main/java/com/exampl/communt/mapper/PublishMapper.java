package com.exampl.communt.mapper;

import com.exampl.communt.mode.PublishMode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param page 第几页
     * @param size 每页显示的几条数据
     */
    List<PublishMode> select(@Param(value = "page") Integer page,
                             @Param(value = "size") Integer size);

    Integer selectCount();

    PublishMode selectByIdInfo(@Param("id") Integer id);
}
