package com.example.demo.service;

import com.example.demo.bean.UserInfo;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(UserInfo userInfo) {
        return userMapper.addUser(userInfo);
    }

    @Override
    public int deleteUser(String id) {
        return 0;
    }

    @Override
    public int updateUser(UserInfo user) {
        return 0;
    }

    @Override
    public UserInfo getUser(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return null;
    }
}
