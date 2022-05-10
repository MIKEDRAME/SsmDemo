package com.gec.service;

import com.gec.bean.FundProduct;

import java.util.List;

//业务层的抽象接口及方法定义
public interface FundProductService {
    //基金理财产品插入功能
    public boolean insertFundProduct(FundProduct fundProduct);
    //查询功能
    public List<FundProduct>queryFundProduct();
    //根据id查询功能
    public FundProduct queryId(int id);
    //根据id修改功能
    public boolean updateFundProduct(FundProduct fundProduct);
    //根据id删除功能
    public boolean deleteFundProduct(int id);
}
