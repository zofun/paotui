package com.runningman.paotui.service.impl;

import com.runningman.paotui.mapper.AuthMapper;
import com.runningman.paotui.mapper.UserMapper;
import com.runningman.paotui.pojo.AuthInfo;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.AuthService;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkStudentId(String studentId) {
        if(authMapper.queryCountByStudentId(studentId)==0){
            return  true;
        }
        return false;
    }

    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    @Override
    public void makeAuth(User user, String realName, String stuId) {
        AuthInfo authInfo = new AuthInfo();
        authInfo.setStart(100);
        authInfo.setRealName(realName);
        authInfo.setStudentId(stuId);
        authInfo.setTime(new Date());

        authMapper.insert(authInfo);

        userMapper.updateAuth(user.getUsername(),authInfo.getId());


    }
}
