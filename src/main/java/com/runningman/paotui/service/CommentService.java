package com.runningman.paotui.service;

import com.runningman.paotui.pojo.Comment;

import java.util.List;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/7
 * @Description: com.runningman.paotui.service
 * @versio: 1.0
 */
public interface CommentService {
    /**
     * 用户为每一份跑腿评分
     * @param comment
     */
    void insertComment(Comment comment);

    /**
     * 通过order的id查询是否为该订单评过分
     * @param order_id
     * @return
     */
    List<Comment> qurryCommentByOrder_Id(int order_id);
}
