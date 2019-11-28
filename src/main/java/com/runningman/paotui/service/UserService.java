package com.runningman.paotui.service;

import com.runningman.paotui.pojo.AuthInfo;
import com.runningman.paotui.pojo.User;

public interface UserService {

    User getUser(String username);

    void addUser(User user);

    boolean checkUser(User user);

    Integer getUserAuth(String username);

    AuthInfo getUserAuthInfo(String username);

    void changeUserInfo(String username,String name ,String password);
}
