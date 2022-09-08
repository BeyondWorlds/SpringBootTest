package com.example.demo.mapper;

import com.example.demo.bean.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    UserInfo getUserById(String id);

    @Insert("insert into user(id,userName,email) values(#{id},#{userName},#{email})")
    int addUser(UserInfo userInfo);
}
