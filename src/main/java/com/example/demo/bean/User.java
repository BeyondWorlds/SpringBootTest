package com.example.demo.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    @NotNull(message = "用户账号不能为空")
    private String username;
    @NotNull(message = "用户密码不能为空")
    @Size(min=6,max=11,message="密码长度必须是6-16个字符")
    private String password;
    private Date createTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
