package com.gec.controller;

import com.gec.bean.User;
import com.gec.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//使用注解标识为控制层的代码
@Controller
public class UserController {

    //获取业务层的操作对象
    @Autowired
    UserService userService;


    //定义登录操作的请求方法
    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request)  {
        //调用业务层进行登录校验
        User nowUser = userService.login(name, password);
        //作出响应
        if (nowUser != null) {
            //清空session
            request.getSession().invalidate();

            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("nowUser", nowUser);

            return "index";
        } else {//登陆失败的处理
            //把信息保存在请求作用域内，目的给jsp页面获取并提示
            request.setAttribute("name",name);
            request.setAttribute("password",password);
            request.setAttribute("message","用户名或密码错误");

            return "login";
        }
    }

    //定义注册操作的请求方法
    @RequestMapping("/register")
    public String register(User user, HttpServletRequest request) {
        //调用业务层进行添加
        boolean isok = userService.register(user);
        //作出响应
        if (isok) {
            return "login";
        } else {
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("user",user);
            request.setAttribute("message","注册失败，请重新操作！");
            return "register";
        }
    }
    //定义查询操作的请求方法
    @RequestMapping("/query")
    public String query(@RequestParam(required = false,defaultValue ="1")Integer pageNo, HttpServletRequest request) {
        //调用业务层进行添加
        //开启分页操作  （当前页码，每页显示记录条数）
        PageHelper.startPage(pageNo,10);
        List<User>list=userService.query();
        //生成page分页模型的信息
        PageInfo pageInfo=new PageInfo(list);
        //把信息保存在请求作用域中，目的给jsp页面获取并显示
        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo);
        return "userList";
    }
    //定义查询id操作的请求方法
    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(Integer id,HttpServletRequest request) {
        //调用业务层进行查询，并且得到结果
        User updateUser = userService.queryId(id);
        //把信息保存在请求作用域中，目的给jsp页面获取并显示
        request.setAttribute("updateUser", updateUser);
        //跳转到jsp页面获取并显示
        return "UserUpdate";
    }
    //定义修改操作的请求方法
    @RequestMapping("/updateUser")
    public String updateUser(User user, HttpServletRequest request) {
        //调用业务层进行添加
        boolean isok = userService.updateUser(user);
        //作出响应
        if (isok) {
            //修改成功则重新查询数据
            return "redirect:/query";
        } else {
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("updateUser", user);
            request.setAttribute("message", "修改失败，请重新操作！");
            return "UserUpdate";
        }
    }
    //定义删除操作的请求方法
    @RequestMapping("/deleteUser")
    public String deleteUser(int id) {
        //调用业务层进行添加
        userService.deleteUser(id);
        //删除成功
        return "redirect:/query";
    }



}
