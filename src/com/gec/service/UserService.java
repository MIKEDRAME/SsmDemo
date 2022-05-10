package com.gec.service;

import com.gec.bean.User;

import java.util.List;

//业务层的抽象接口及方法定义
public interface UserService {

    //用户登录功能
    public User login(String name,String pass);
    //用户注册功能
    public boolean register(User user);
    //用户查询功能
    public List<User>query();
    //用户根据id查询功能
    public User queryId(int id);
    //用户根据id修改功能
    public boolean updateUser(User user);
    //用户根据id删除功能
    public boolean deleteUser(int id);
}
