package com.runningman.paotui.mapper;

import com.runningman.paotui.pojo.AuthInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AuthMapper {
    int queryCountByStudentId(@Param("stuId") String stuId);

    void insert(AuthInfo authInfo);
}
