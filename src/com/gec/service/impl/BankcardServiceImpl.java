package com.gec.service.impl;

import com.gec.bean.*;
import com.gec.mapper.BankcardMapper;
import com.gec.mapper.UserMapper;
import com.gec.service.BankcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//业务层的实现类
//标识为业务层的代码
@Service
public class BankcardServiceImpl implements BankcardService {

    //IOC获取userMapper的对象
    @Autowired
    BankcardMapper bankcardMapper;

    @Override
    public boolean insertBankcard(Bankcard bankcard){
        return bankcardMapper.insertSelective(bankcard)>0?true:false;
    }
    @Override
    public List<Bankcard>queryBankcard(){
        return bankcardMapper.selectByExample(new BankcardExample());
    }
    @Override
    public Bankcard queryId(int id){
        return bankcardMapper.selectByPrimaryKey(id);
    }
    @Override
    public boolean updateBankcard(Bankcard bankcard) {
        return bankcardMapper.updateByPrimaryKeySelective(bankcard)>0?true:false;
    }
    public boolean deleteBankcard(int id){
        return bankcardMapper.deleteByPrimaryKey(id)>0?true:false;
    }

}
