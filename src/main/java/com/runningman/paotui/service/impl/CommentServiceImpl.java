package com.runningman.paotui.service.impl;

import com.runningman.paotui.mapper.CommentMapper;
import com.runningman.paotui.pojo.Comment;
import com.runningman.paotui.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: http://www.tanwei.com
 * @Date: 2019/11/7
 * @Description: com.runningman.paotui.service.impl
 * @versio: 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void insertComment(Comment comment) {
        commentMapper.insertComment(comment);
    }
}
