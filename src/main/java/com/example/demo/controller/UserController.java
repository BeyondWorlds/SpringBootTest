package com.example.demo.controller;

import com.example.demo.bean.ResultBean;
import com.example.demo.bean.User;
import com.example.demo.bean.UserInfo;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user")
    public User createUser(User user) {
        System.out.println(user.getCreateTime().toString());
//        return "Create User success";
        return user;
    }

    @PostMapping("/addUser")
    public String addUser(@Valid User user) {

        return "success";
    }

    /**
     * 传参是json格式的
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody @Valid User user) {

        return "success";
    }

    @PostMapping("/insertUser")
    public int insertUserInfo(UserInfo userInfo){
        return userService.insertUser(userInfo);
    }
}
