package com.runningman.paotui.service;

import com.runningman.paotui.pojo.User;

public interface AuthService {

    /**
     * 检查认证的学号的有效性
     * @param studentId
     * @return
     */
    boolean checkStudentId(String studentId);


    /**
     * 完成认证信息持久化
     * @param user
     * @param realName
     * @param stuId
     */
    void makeAuth(User user,String realName,String stuId);
}
