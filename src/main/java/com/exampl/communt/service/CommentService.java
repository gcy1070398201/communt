package com.exampl.communt.service;

import com.exampl.communt.dto.CommentDto;
import com.exampl.communt.enums.CommentEnums;
import com.exampl.communt.exception.AcmeException;
import com.exampl.communt.exception.AcmeExceptionCode;
import com.exampl.communt.mapper.CommentMapper;
import com.exampl.communt.mapper.PublishModeExtMapper;
import com.exampl.communt.mapper.PublishModeMapper;
import com.exampl.communt.mode.Comment;
import com.exampl.communt.mode.PublishMode;
import com.exampl.communt.mode.PublishModeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    PublishModeMapper modeMapper;

    @Autowired
    PublishModeExtMapper publishModeExtMapper;

    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {

            throw new AcmeException(AcmeExceptionCode.COMMENT_ERROR_MESSAGE);
        }
        if (StringUtils.isEmpty(comment.getContent())) {
            throw new AcmeException(AcmeExceptionCode.COMMENT_ERROR_CONTENT);
        }
        if (comment.getType() == null && CommentEnums.isEmpty(comment.getType())) {
            throw new AcmeException(AcmeExceptionCode.COMMENT_ERROR_TYPE);
        }
        if (comment.getType() == CommentEnums.COMMIT.getType()) {
            //回复评论
            Comment iCommentDto = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (iCommentDto == null) {
                throw new AcmeException(AcmeExceptionCode.COMMENT_NOT_FIND);
            }
            commentMapper.insert(comment);
        } else {
            //回复问题
            PublishMode publishMode = modeMapper.selectByPrimaryKey(comment.getParentId());
            if (publishMode == null) {
                throw new AcmeException(AcmeExceptionCode.COMMENT_NOT_FIND);
            }
            commentMapper.insert(comment);
            publishMode.setReplyCount(1);
            publishModeExtMapper.incComment(publishMode);

        }

        commentMapper.insert(comment);

    }
}
