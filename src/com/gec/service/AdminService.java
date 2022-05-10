package com.gec.service;

import com.gec.bean.Admin;

import java.util.List;

//业务层的抽象接口及方法定义
public interface AdminService {

    //用户登录功能
    public Admin login(String name,String pass);
    //用户注册功能
    public boolean register(Admin admin);
    //用户查询功能
    public List<Admin>query();
    //用户根据id查询功能
    public Admin queryId(int id);
    //用户根据id修改功能
    public boolean updateAdmin(Admin admin);
    //用户根据id删除功能
    public boolean deleteAdmin(int id);
}
