package com.runningman.paotui.mapper;

import com.runningman.paotui.pojo.Chat;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ChatMapper {
    void insert(Chat chat);
}
