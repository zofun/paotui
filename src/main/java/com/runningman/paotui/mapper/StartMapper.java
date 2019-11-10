package com.runningman.paotui.mapper;

import com.runningman.paotui.pojo.CommentUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StartMapper {
    /**
     * 用户查看自己的信誉分
     * @param username
     * @param page
     * @param limit
     * @return
     */
    List<CommentUser> queryReputation(String username, int page, int limit);

    /**
     * 显示用户被星级评价数
     * @return
     */
    int getUserStartCount(String username);

    /**
     * 显示用户总信誉分
     * @return
     */
    int SumUserStart(String username);

}
