package com.example.demo.service;

import com.example.demo.bean.UserInfo;

import java.util.List;

public interface UserService {

    int insertUser(UserInfo userInfo);
    int deleteUser(String id);
    int updateUser(UserInfo user);
    UserInfo getUser(String id);

    List<UserInfo> getAllUsers();
}
