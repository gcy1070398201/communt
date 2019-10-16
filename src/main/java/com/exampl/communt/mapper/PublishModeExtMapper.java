package com.exampl.communt.mapper;

import com.exampl.communt.mode.PublishMode;
import com.exampl.communt.mode.PublishModeExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * PublishModeMapper 扩展mapper
 */
public interface PublishModeExtMapper {
    /**
     * 页面游览次数
     * @param record
     * @return
     */
    int incView(PublishMode record);
    /**
     * 信息回复次数
     * @param record
     * @return
     */
    int incComment(PublishMode record);
}