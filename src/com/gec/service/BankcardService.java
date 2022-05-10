package com.gec.service;
import com.gec.bean.Bankcard;

import java.util.List;

//业务层的抽象接口及方法定义
public interface BankcardService {
    //银行插入功能
    public boolean insertBankcard(Bankcard bankcard);
    //查询功能
    public List<Bankcard>queryBankcard();
    //根据id查询功能
    public Bankcard queryId(int id);
    //根据id修改功能
    public boolean updateBankcard(Bankcard bankcard);
    //根据id删除功能
    public boolean deleteBankcard(int id);
}
