package com.gec.service;

import com.gec.bean.FundProduct;
import com.gec.bean.UserFundProduct;

import java.util.List;

//用户-基金记录业务
public interface UserFundProductService {

    //基金添加功能
    public boolean insertUserFundProduct(UserFundProduct UserFundProduct);

    //基金列表查询功能
    public List<UserFundProduct> queryUserFundProduct();

    //基金根据id查询功能
    public UserFundProduct queryId(int id);

    //基金根据id修改功能
    public boolean updateUserFundProduct(UserFundProduct UserFundProduct);

    //根据主键删除基金功能
    public boolean deleteUserFundProduct(int id);

}