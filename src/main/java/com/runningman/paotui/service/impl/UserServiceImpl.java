package com.runningman.paotui.service.impl;

import com.runningman.paotui.mapper.UserMapper;
import com.runningman.paotui.pojo.User;
import com.runningman.paotui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
        User user=userMapper.getUserByUsername(username);
        System.out.println("username = [" + username + "]");
        return user;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public boolean checkUser(User user) {
        User u = userMapper.getUserByUsername(user.getUsername());

        if(u==null||user.getPassword()==null||!user.getPassword().equals(u.getPassword())){
            return  false;
        }
        user.setName(u.getName());
        return true;


    }

    @Override
    public Integer getUserAuth(String username) {
        return userMapper.getUserAuth(username);
    }
}
