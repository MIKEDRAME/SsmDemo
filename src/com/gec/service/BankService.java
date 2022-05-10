package com.gec.service;

import com.gec.bean.Bank;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//业务层的抽象接口及方法定义
public interface BankService {
    //银行插入功能
    public boolean insertBank(Bank bank);
    //查询功能
    public List<Bank>queryBank();
    //根据id查询功能
    public Bank queryId(int id);
    //根据id修改功能
    public boolean updateBank(Bank bank);
    //根据id删除功能
    public boolean deleteBank(int id);
}
