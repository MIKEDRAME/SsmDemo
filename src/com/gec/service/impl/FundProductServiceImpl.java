package com.gec.service.impl;

import com.gec.bean.FundProduct;
import com.gec.bean.FundProductExample;

import com.gec.mapper.FundProductMapper;
import com.gec.service.FundProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//业务层的实现类
//标识为业务层的代码
@Service
public class FundProductServiceImpl implements FundProductService {

    //IOC获取userMapper的对象
    @Autowired
    FundProductMapper fundProductMapper;
    @Override
    public boolean insertFundProduct(FundProduct fundProduct){
        return fundProductMapper.insertSelective(fundProduct)>0?true:false;
    }
    @Override
    public List<FundProduct> queryFundProduct() {
        return fundProductMapper.selectByExample(new FundProductExample());
    }




    @Override
    public FundProduct queryId(int id){
        return fundProductMapper.selectByPrimaryKey(id);
    }
    @Override
    public boolean updateFundProduct(FundProduct fundProduct) {
        return fundProductMapper.updateByPrimaryKeySelective(fundProduct)>0?true:false;
    }
    @Override
    public boolean deleteFundProduct(int id){
        return fundProductMapper.deleteByPrimaryKey(id)>0?true:false;
    }

}
