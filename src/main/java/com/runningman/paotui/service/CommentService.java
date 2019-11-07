package com.runningman.paotui.service;

import com.runningman.paotui.pojo.Comment;

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
}
