package com.exampl.communt.service;

import com.exampl.communt.dto.ProfileQuestionsDto;
import com.exampl.communt.dto.PubLishListDto;
import com.exampl.communt.dto.PublishDto;
import com.exampl.communt.mapper.PublishModeMapper;
import com.exampl.communt.mode.PublishMode;
import com.exampl.communt.mode.PublishModeExample;
import com.exampl.communt.mode.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublishService {

    @Autowired
    PublishModeMapper publishMapper;

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
        if (page<=0)page=1;
        Integer currentPage = 0;
        Integer totalPage=0;
        PubLishListDto pubLishListDto = new PubLishListDto();
        Integer totalCount = (int)publishMapper.countByExample(new PublishModeExample());
        //计算总页数
        if (totalCount % size==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }

        currentPage = (page-1) * size;

        if (page<=0){
            page=1;
        }else if (page>totalPage){
            page=totalPage;
        }



        pubLishListDto.setPageInfo(totalPage, page, size);

        List<PublishDto> publishDtos = new ArrayList<>();

        List<PublishMode> publishModes = publishMapper.selectByExampleWithRowbounds(
                new PublishModeExample(), new RowBounds(currentPage,size));

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

    public ProfileQuestionsDto selectUserQuestion(Integer page, Integer size) {
        Integer currentPage = 0;
        Integer totalPage=0;
        ProfileQuestionsDto profileQuestionsDto = new ProfileQuestionsDto();
        Integer totalCount = (int)publishMapper.countByExample(new PublishModeExample());
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

        profileQuestionsDto.setPageInfo(totalPage, page, size);
        List<PublishDto> publishDtos = new ArrayList<>();
        List<PublishMode> publishModes = publishMapper.selectByExampleWithRowbounds(
                new PublishModeExample(), new RowBounds(currentPage,size));

        if (publishModes != null && publishModes.size() > 0) {
            for (PublishMode publishMode : publishModes) {
                PublishDto publishDto = new PublishDto();
                BeanUtils.copyProperties(publishMode, publishDto);
                User user = userService.findUserId(publishDto.getCreatId());
                publishDto.setUser(user);
                publishDtos.add(publishDto);
            }
        }
        profileQuestionsDto.setPublishDtos(publishDtos);
        return profileQuestionsDto;
    }

    public PublishDto selectByIdInfo(Integer id) {

        PublishModeExample publishModeExample=new PublishModeExample();
        publishModeExample.createCriteria().andIdEqualTo(id);
        List<PublishMode> list=publishMapper.selectByExample(publishModeExample);
        if (list.size()==0){
            return null;
        }
        PublishMode publishMode=list.get(0);
        PublishDto publishDto = new PublishDto();
        BeanUtils.copyProperties(publishMode, publishDto);
        User user = userService.findUserId(publishDto.getCreatId());
        publishDto.setUser(user);
        return publishDto;
    }

    public PublishMode createOrUpdate(Integer id,PublishMode publishMode) {
        if (id!=0){
            //更新信息
            PublishModeExample publishModeExample=new PublishModeExample();
            publishModeExample.createCriteria().andIdEqualTo(id);
            List<PublishMode> list=publishMapper.selectByExample(publishModeExample);
            if (list.size()==0){
                return null;
            }
            PublishMode publishMode1=list.get(0);
            if (publishMode1!=null){
                BeanUtils.copyProperties(publishMode1, publishMode);
            }
        }
        return publishMode;

    }
}
