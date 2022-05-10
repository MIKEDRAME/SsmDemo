package com.gec.service.impl;

import com.gec.bean.Admin;
import com.gec.bean.AdminExample;
import com.gec.mapper.AdminMapper;
import com.gec.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//业务层的实现类
//标识为业务层的代码
@Service
public class AdminServiceImpl implements AdminService {

    //IOC获取adminMapper的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pass) {
        //创建模板对象
        AdminExample example = new AdminExample();
        //添加查询条件(名字and密码)
        example.createCriteria().andUsernameEqualTo(name).andPasswordEqualTo(pass);
        //执行查询
        List<Admin> list = adminMapper.selectByExample(example);
        //集合不为空
        if (list != null && !list.isEmpty() && list.size() > 0) {
            return list.get(0);
        }
        //结果为空则返回null
        return null;
    }
    @Override
    public boolean register(Admin admin){
        return adminMapper.insertSelective(admin)>0?true:false;
    }
    @Override
    public List<Admin>query(){
        return adminMapper.selectByExample(new AdminExample());
    }
    @Override
    public Admin queryId(int id){
        return adminMapper.selectByPrimaryKey(id);
    }
    @Override
    public boolean updateAdmin(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin)>0?true:false;
    }
    @Override
    public boolean deleteAdmin(int id){
        return adminMapper.deleteByPrimaryKey(id)>0?true:false;
    }

}
