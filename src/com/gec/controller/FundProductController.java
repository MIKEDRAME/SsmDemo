package com.gec.controller;

import com.gec.bean.FundProduct;
import com.gec.service.FundProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//使用注解标识为控制层的代码
@Controller
public class FundProductController {

    //获取业务层的操作对象
    @Autowired
    FundProductService fundProductService;

    //定义一个方法返回所有基金的收益的数据
    @RequestMapping("/queryFundData")
    @ResponseBody
    public HashMap queryFundData() {
        //调用业务层进行查询，并且得到结果
        //开启分页操作   当页页码，每页显示记录条数
        List<FundProduct> list = fundProductService.queryFundProduct();
        // 从基金集合中抽取基金名【数组】
        List<String> xData = list.stream().map(entiy -> {
            //返回了每一个基金的名称
            return entiy.getFunddesc();
        }).collect(Collectors.toList());//collect方法是将返回的数据包装在一个集合中
        //  从基金集合中抽取基金的收益【数组】
        List<String> yData = list.stream().map(entiy -> {
            return entiy.getProfit() + "";
        }).collect(Collectors.toList());//collect方法是将返回的数据包装在一个集合中
        //生成page分页模型的信息
        HashMap map = new HashMap();
        map.put("xData",xData);
        map.put("yData",yData);
        //跳转到jsp页面获取并显示
        return map;
    }

    //定义插入操作的请求方法
    @RequestMapping("/insertFundProduct")
    public String insertFundProduct(@RequestParam(required = false,defaultValue ="1")Integer pageNo, FundProduct fundProduct, HttpServletRequest request) {
        //调用业务层进行添加
        boolean isok = fundProductService.insertFundProduct(fundProduct);
        //作出响应
        if (isok) {
            PageHelper.startPage(pageNo,10);
            List<FundProduct>list=fundProductService.queryFundProduct();
            //生成page分页模型的信息
            PageInfo pageInfo=new PageInfo(list);
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("list",list);
            request.setAttribute("pageInfo",pageInfo);
            return "FundProductList";
        } else {
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("fundProduct",fundProduct);
            request.setAttribute("message","插入失败，请重新操作！");
            return "insertFundProduct";
        }
    }
    //定义查询操作的请求方法
    @RequestMapping("/queryFundProduct")
    public String queryFundProduct(@RequestParam(required = false,defaultValue ="1")Integer pageNo, HttpServletRequest request) {
        //调用业务层进行添加
        //开启分页操作  （当前页码，每页显示记录条数）
        PageHelper.startPage(pageNo,10);
        List<FundProduct>list=fundProductService.queryFundProduct();
        //生成page分页模型的信息
        PageInfo pageInfo=new PageInfo(list);
        //把信息保存在请求作用域中，目的给jsp页面获取并显示
        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo);
        return "fundProductList";
    }
    //定义查询操作的请求方法
    @RequestMapping("/userQueryFundProduct")
    public String userQueryFundProduct(@RequestParam(required = false,defaultValue ="1")Integer pageNo, HttpServletRequest request) {
        //调用业务层进行添加
        //开启分页操作  （当前页码，每页显示记录条数）
        PageHelper.startPage(pageNo,10);
        List<FundProduct>list=fundProductService.queryFundProduct();
        //生成page分页模型的信息
        PageInfo pageInfo=new PageInfo(list);
        //把信息保存在请求作用域中，目的给jsp页面获取并显示
        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo);
        return "fundProductList";
    }
    //定义查询id操作的请求方法
    @RequestMapping("/toUpdateFundProduct")
    public String toUpdateFundProduct(Integer id,HttpServletRequest request) {
        //调用业务层进行查询，并且得到结果
        FundProduct updateFundProduct = fundProductService.queryId(id);
        //把信息保存在请求作用域中，目的给jsp页面获取并显示
        request.setAttribute("updateFundProduct", updateFundProduct);
        //跳转到jsp页面获取并显示
        return "FundProductUpdate";
    }
    //定义修改操作的请求方法
    @RequestMapping("/updateFundProduct")
    public String updateFundProduct(FundProduct fundProduct, HttpServletRequest request) {
        //调用业务层进行添加
        boolean isok = fundProductService.updateFundProduct(fundProduct);
        //作出响应
        if (isok) {
            //修改成功则重新查询数据
            return "redirect:/queryFundProduct";
        } else {
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("updateFundProduct", fundProduct);
            request.setAttribute("message", "修改失败，请重新操作！");
            return "FundProductUpdate";
        }
    }
    //定义删除操作的请求方法
    @RequestMapping("/deleteFundProduct")
    public String deleteFundProduct(int id) {
        //调用业务层进行添加
        fundProductService.deleteFundProduct(id);
        //删除成功
        return "redirect:/queryFundProduct";
    }



}
