package com.wyy.controller;

import com.wyy.pojo.Admin;
import com.wyy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class AdminController {
    //    controller调service层
    @Autowired
    private AdminService adminService;

    //    登录页面初始化
    @RequestMapping("/tologin")
    public String initLogin() {
        return "index";
    }

    //    处理登录功能
    @RequestMapping("/login")
    public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        Admin admin = adminService.queryAdmin(username, password);
        if (admin != null && password.equals(admin.getPassword())) {
//            用户名和密码正确，可以登录，将登录信息放在Session中
            model.addAttribute("msg", "登录成功！");
            session.setAttribute("user", admin);
            return "redirect:main";
        } else {
            model.addAttribute("msg", "用户名或密码不正确！");
        }
        return "index";
    }


    //    注销登录
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();//销毁session
        return "index";
    }

//进入账户管理页面
    @RequestMapping("/account")
    public String gotoAccount(HttpSession session, Model model) {
        Admin admin = (Admin) session.getAttribute("user");
        model.addAttribute("admin", admin);
        return "account/account";
    }

    //    进入修改用户名和密码页面
    @RequestMapping("/goUpdateUser")
    public String goUpdate(Model model,HttpSession session) {
        Admin admin = (Admin) session.getAttribute("user");
        model.addAttribute("admin", admin);
        return "account/updateAccount";
    }

    //    修改用户名和密码功能
    @PostMapping("/updateUser")
    public String update(HttpSession session, Admin admin) {
        adminService.updateAdmin(admin);
        return "redirect:/account";
    }

}
