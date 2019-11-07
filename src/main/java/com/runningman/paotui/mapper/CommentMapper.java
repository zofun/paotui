package com.runningman.paotui.mapper;

import com.runningman.paotui.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/7
 * @Description: com.runningman.paotui.mapper
 * @versio: 1.0
 */
@Repository
@Mapper
public interface CommentMapper {
    /**
     * 评分
     * @param comment
     */
    void insertComment(Comment comment);
}
