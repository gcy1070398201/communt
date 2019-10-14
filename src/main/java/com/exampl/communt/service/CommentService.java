package com.exampl.communt.service;

import com.exampl.communt.dto.CommentDto;
import com.exampl.communt.exception.AcmeException;
import com.exampl.communt.exception.AcmeExceptionCode;
import com.exampl.communt.mapper.CommentMapper;
import com.exampl.communt.mode.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    public void insert(CommentDto commentDto) {
        if (commentDto.getParentId()==null || commentDto.getParentId()==0){

            throw new AcmeException(AcmeExceptionCode.COMMENT_ERROR_MESSAGE);
        }
        Comment comment=new Comment();
        comment.setParentId(commentDto.getParentId());
        comment.setContent(commentDto.getContent());
        comment.setType(commentDto.getType());
        comment.setCommentator(1);
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setLikeCount(0L);
        commentMapper.insert(comment);

    }
}
