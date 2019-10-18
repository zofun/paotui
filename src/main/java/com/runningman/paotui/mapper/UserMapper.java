package com.runningman.paotui.mapper;


import com.runningman.paotui.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    User getUserByUsername(String username);
}
