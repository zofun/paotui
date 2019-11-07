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

    /**
     * 修改用户的信誉积分
     * @param user
     * @param start
     */
    void changeAuthStart(@Param("user") String user, @Param("start") int start);

    /**
     * 获取用户的信誉积分
     * @param user
     * @return
     */
    int getAuthStart(@Param("user") String user);
}
