package com.gec.service.impl;

import com.gec.bean.Bank;
import com.gec.bean.BankExample;
import com.gec.mapper.BankMapper;
import com.gec.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//业务层的实现类
//标识为业务层的代码
@Service
public class BankServiceImpl implements BankService {

    //IOC获取userMapper的对象
    @Autowired
    BankMapper bankMapper;
    @Override
    public boolean insertBank(Bank bank){
        return bankMapper.insertSelective(bank)>0?true:false;
    }
    @Override
    public List<Bank>queryBank(){
        return bankMapper.selectByExample(new BankExample());
    }
    @Override
    public Bank queryId(int id){
        return bankMapper.selectByPrimaryKey(id);
    }
    @Override
    public boolean updateBank(Bank bank) {
        return bankMapper.updateByPrimaryKeySelective(bank)>0?true:false;
    }
    @Override
    public boolean deleteBank(int id){
        return bankMapper.deleteByPrimaryKey(id)>0?true:false;
    }

}
