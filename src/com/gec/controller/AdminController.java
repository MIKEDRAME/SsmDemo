package com.gec.controller;

import com.gec.bean.Admin;
import com.gec.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//使用注解标识为控制层的代码
@Controller
public class AdminController {

    //获取业务层的操作对象
    @Autowired
    AdminService adminService;


    //定义登录操作的请求方法
    @RequestMapping("/loginAdmin")
    public String login(String name, String password, HttpServletRequest request) {
        //调用业务层进行登录校验
        Admin nowAdmin = adminService.login(name, password);
        //作出响应
        if (nowAdmin != null) {
//            session.setAttribute("name",name);

            //清空session
            request.getSession().invalidate();

            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("nowAdmin", nowAdmin);

            return "index"; //管理员页面首页--查询所有用户信息
        } else {//登陆失败的处理
            //把信息保存在请求作用域内，目的给jsp页面获取并提示
            request.setAttribute("name",name);
            request.setAttribute("password",password);
            request.setAttribute("message","用户名或密码错误");
            return "loginAdmin";
        }
    }
    //定义注册操作的请求方法
    @RequestMapping("/registerAdmin")
    public String register(Admin admin, HttpServletRequest request) {
        //调用业务层进行添加
        boolean isok = adminService.register(admin);
        //作出响应
        if (isok) {
            return "login";
        } else {
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("admin",admin);
            request.setAttribute("message","注册失败，请重新操作！");
            return "register";
        }
    }
    //定义查询操作的请求方法
    @RequestMapping("/queryAdmin")
    public String query(@RequestParam(required = false,defaultValue ="1")Integer pageNo, HttpServletRequest request) {
        //调用业务层进行添加
        //开启分页操作  （当前页码，每页显示记录条数）
        PageHelper.startPage(pageNo,3);
        List<Admin>list=adminService.query();
        //生成page分页模型的信息
        PageInfo pageInfo=new PageInfo(list);
        //把信息保存在请求作用域中，目的给jsp页面获取并显示
        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo);
        return "adminList";
    }
    //定义查询id操作的请求方法
    @RequestMapping("/toUpdateAdmin")
    public String toUpdateAdmin(Integer id,HttpServletRequest request) {
        //调用业务层进行查询，并且得到结果
        Admin updateAdmin = adminService.queryId(id);
        //把信息保存在请求作用域中，目的给jsp页面获取并显示
        request.setAttribute("updateAdmin", updateAdmin);
        //跳转到jsp页面获取并显示
        return "AdminUpdate";
    }
    //定义修改操作的请求方法
    @RequestMapping("/updateAdmin")
    public String updateAdmin(Admin admin, HttpServletRequest request) {
        //调用业务层进行添加
        boolean isok = adminService.updateAdmin(admin);
        //作出响应
        if (isok) {
            //修改成功则重新查询数据
            return "redirect:/queryAdmin";
        } else {
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("updateAdmin", admin);
            request.setAttribute("message", "修改失败，请重新操作！");
            return "AdminUpdate";
        }
    }
    //定义删除操作的请求方法
    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(int id) {
        //调用业务层进行添加
        adminService.deleteAdmin(id);
        //删除成功
        return "redirect:/queryAdmin";
    }



}
