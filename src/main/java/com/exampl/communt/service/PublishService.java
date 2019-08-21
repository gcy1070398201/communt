package com.exampl.communt.service;

import com.exampl.communt.dto.GitHubUserDto;
import com.exampl.communt.dto.PubLishListDto;
import com.exampl.communt.dto.PublishDto;
import com.exampl.communt.mapper.PublishMapper;
import com.exampl.communt.mapper.UserMapper;
import com.exampl.communt.mode.PublishMode;
import com.exampl.communt.mode.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PublishService {

    @Autowired
    PublishMapper publishMapper;

    @Autowired
    UserService userService;

    /**
     * 插入信息
     *
     * @return
     */
    public void insert(PublishMode publishMode) {
        publishMapper.insert(publishMode);
    }

    /**
     * 获取信息
     *
     * @param page
     * @param size
     * @return
     */
    public PubLishListDto select(Integer page, Integer size) {
        Integer currentPage = 0;
        Integer totalPage=0;
        PubLishListDto pubLishListDto = new PubLishListDto();
        Integer totalCount = publishMapper.selectCount();
        //计算总页数
        if (totalCount % size==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }
        if (page<=0){
            page=1;
        }else if (page>totalPage){
            page=totalPage;
        }

        currentPage = (page-1) * size;

        pubLishListDto.setPageInfo(totalPage, page, size);

        List<PublishDto> publishDtos = new ArrayList<>();
        List<PublishMode> publishModes = publishMapper.select(currentPage, size);

        if (publishModes != null && publishModes.size() > 0) {
            for (PublishMode publishMode : publishModes) {
                PublishDto publishDto = new PublishDto();
                BeanUtils.copyProperties(publishMode, publishDto);
                User user = userService.findUserId(publishDto.getCreatId());
                publishDto.setUser(user);
                publishDtos.add(publishDto);
            }
        }
        pubLishListDto.setPublishDtos(publishDtos);


        return pubLishListDto;

    }
}
