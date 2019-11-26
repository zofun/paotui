package com.runningman.paotui.mapper;

import com.runningman.paotui.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 通过order的id查询是否做过该订单的评价
     * @param order_id
     * @return
     */
    List<Comment> qurryCommentByOrder_Id(@Param("order_id") int order_id);
}
