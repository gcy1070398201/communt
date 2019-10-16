package com.exampl.communt.service;

import com.exampl.communt.dto.ProfileQuestionsDto;
import com.exampl.communt.dto.PubLishListDto;
import com.exampl.communt.dto.PublishDto;
import com.exampl.communt.exception.AcmeException;
import com.exampl.communt.exception.AcmeExceptionCode;
import com.exampl.communt.mapper.PublishModeExtMapper;
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

    @Autowired
    private PublishModeExtMapper publishModeExtMapper;

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

    /**
     * 根据id 查询 信息
     * 组合数据
     * @param id
     * @return
     */
    public PublishDto selectByIdInfo(long id) {

        PublishMode publishMode=publishMapper.selectByPrimaryKey(id);
        if (publishMode==null){
            throw new AcmeException(AcmeExceptionCode.Question_ERROR_MESSAGE);
        }
        PublishDto publishDto = new PublishDto();
        BeanUtils.copyProperties(publishMode, publishDto);
        User user = userService.findUserId(publishDto.getCreatId());
        publishDto.setUser(user);
        return publishDto;
    }

    /**
     * 根据id 查询 信息
     * 然后更新信息
     * @param id
     * @return
     */
    public PublishMode createOrUpdate(long id) {

        PublishMode publishMode=new PublishMode();
        if (id!=0){
            //更新信息
            PublishMode publishModeDto=publishMapper.selectByPrimaryKey(id);
            if (publishModeDto!=null){
                BeanUtils.copyProperties(publishModeDto, publishMode);
            }else{
                throw new AcmeException(AcmeExceptionCode.Question_ERROR_MESSAGE);
            }
        }
        return publishMode;
    }

    /**
     * 累加评论
     */
    public void incView(long id) {
        PublishMode publishMode = new PublishMode();
        publishMode.setId(id);
        publishMode.setViewCount(1);
        publishModeExtMapper.incView(publishMode);
    }
}
