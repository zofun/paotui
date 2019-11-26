package com.runningman.paotui.service;

import com.runningman.paotui.pojo.AuthInfo;
import com.runningman.paotui.pojo.User;

import java.util.List;

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

    /**
     * 修改跑腿员信誉积分
     * @param user
     * @param start
     */
    void changeAuthStart(String user,int start);

    /**
     * 根据用户名获取用户信誉积分
     * @param user
     * @return
     */
    int getAuthStart(String user);

    /**
     * 根据用户名获取用户认证信息
     * @param user
     * @return
     */
    List<AuthInfo> getAuthInfo(String user);
}
