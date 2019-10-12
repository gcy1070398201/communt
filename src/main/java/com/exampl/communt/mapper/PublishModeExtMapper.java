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

    int incView(PublishMode record);
}