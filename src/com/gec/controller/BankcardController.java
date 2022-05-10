package com.gec.controller;
import com.gec.bean.Bank;
import com.gec.bean.Bankcard;
import com.gec.service.BankcardService;
import com.gec.service.BankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//使用注解标识为控制层的代码
@Controller
public class BankcardController {

    //获取业务层的操作对象
    @Autowired
    BankcardService bankcardService;
    @Autowired
    BankService bankService;

    //定义插入操作的请求方法
    @RequestMapping("/toInsertBankcard")
    public String toInsertBankcard( HttpServletRequest request) {
        //调用业务层查询所有的银行
        List <Bank>banks = bankService.queryBank();
        //保存
        request.setAttribute("banks",banks);
        return "insertBankcard";
    }
    //定义插入操作的请求方法
    @RequestMapping("/insertBankcard")
    public String insertBankcard(@RequestParam(required = false,defaultValue ="1")Integer pageNo, Bankcard bankcard, HttpServletRequest request) {
        //调用业务层进行添加
        boolean isok = bankcardService.insertBankcard(bankcard);
        //作出响应
        if (isok) {
            PageHelper.startPage(pageNo,10);
            List<Bankcard>list=bankcardService.queryBankcard();
            //生成page分页模型的信息
            PageInfo pageInfo=new PageInfo(list);
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("list",list);
            request.setAttribute("pageInfo",pageInfo);
            return "bankcardList";
        } else {
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("bankcard",bankcard);
            request.setAttribute("message","插入失败，请重新操作！");
            return "insertBankcard";
        }
    }
    //定义查询操作的请求方法
    @RequestMapping("/queryBankcard")
    public String queryBankcard(@RequestParam(required = false,defaultValue ="1")Integer pageNo, HttpServletRequest request) {
        //调用业务层进行添加
        //开启分页操作  （当前页码，每页显示记录条数）
        PageHelper.startPage(pageNo,10);
        List<Bankcard>list=bankcardService.queryBankcard();
        //生成page分页模型的信息
        PageInfo pageInfo=new PageInfo(list);
        //把信息保存在请求作用域中，目的给jsp页面获取并显示
        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo);
        return "bankcardList";
    }
    //定义查询操作的请求方法
    @RequestMapping("/userQueryBankcard")
    public String userQueryBankCard(@RequestParam(required = false,defaultValue ="1")Integer pageNo, HttpServletRequest request) {
        //调用业务层进行添加
        //开启分页操作  （当前页码，每页显示记录条数）
        PageHelper.startPage(pageNo,10);
        List<Bankcard>list=bankcardService.queryBankcard();
        //生成page分页模型的信息
        PageInfo pageInfo=new PageInfo(list);
        //把信息保存在请求作用域中，目的给jsp页面获取并显示
        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo);
        return "bankcardList";//这里千万不要用重定向！！！
    }
    //定义查询id操作的请求方法
    @RequestMapping("/toUpdateBankcard")
    public String toUpdateBankcard(Integer id,HttpServletRequest request) {
        //调用业务层进行查询，并且得到结果
        Bankcard updateBankcard = bankcardService.queryId(id);

        List<Bank>banks=bankService.queryBank();
        //保存
        request.setAttribute("banks", banks);
        //把信息保存在请求作用域中，目的给jsp页面获取并显示
        request.setAttribute("updateBankcard", updateBankcard);
        //跳转到jsp页面获取并显示
        return "BankcardUpdate";
    }
    //定义修改操作的请求方法
    @RequestMapping("/updateBankcard")
    public String updateBankcard(Bankcard bankcard, HttpServletRequest request) {
        //调用业务层进行添加
        boolean isok = bankcardService.updateBankcard(bankcard);
        //作出响应
        if (isok) {
            //修改成功则重新查询数据
            return "redirect:/queryBankcard";
        } else {
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("updateBankcard", bankcard);
            request.setAttribute("message", "注册失败，请重新操作！");
            return "BankcardUpdate";
        }
    }
    //定义删除操作的请求方法
    @RequestMapping("/deleteBankcard")
    public String deleteBankcard(int id) {
        //调用业务层进行添加
        bankcardService.deleteBankcard(id);
        //删除成功
        return "redirect:/queryBankcard";
    }



}
