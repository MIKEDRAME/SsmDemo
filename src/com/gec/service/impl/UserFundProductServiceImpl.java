package com.gec.service.impl;

import com.gec.bean.FundProductExample;
import com.gec.bean.UserFundProduct;
import com.gec.bean.UserFundProductExample;
import com.gec.mapper.UserFundProductMapper;
import com.gec.service.UserFundProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFundProductServiceImpl implements UserFundProductService {


    @Autowired
    UserFundProductMapper userFundProductMapper;

    @Override
    public boolean insertUserFundProduct(UserFundProduct UserFundProduct) {
        return userFundProductMapper.insertSelective(UserFundProduct) > 0 ? true : false;
    }

    @Override
    public List<UserFundProduct> queryUserFundProduct() {
        return userFundProductMapper.selectByExample(new UserFundProductExample());
    }

    @Override
    public UserFundProduct queryId(int id) {
        return userFundProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateUserFundProduct(UserFundProduct UserFundProduct) {
        return userFundProductMapper.updateByPrimaryKeySelective(UserFundProduct)>0?true:false;
    }

    @Override
    public boolean deleteUserFundProduct(int id) {
        return userFundProductMapper.deleteByPrimaryKey(id)>0?true:false;
    }
}
