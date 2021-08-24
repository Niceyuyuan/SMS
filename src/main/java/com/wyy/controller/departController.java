package com.wyy.controller;

import com.wyy.pojo.Admin;
import com.wyy.pojo.Department;
import com.wyy.pojo.Log;
import com.wyy.service.DepartService;
import com.wyy.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class departController {

    @Autowired
    private DepartService departService;

    @Autowired
    private LogService logService;

    //    进入展示部门列表页面
    @RequestMapping("/departs")
    public String gotoDepart(Model model) {
        List<Department> departments = departService.queryAllDeparts();
        model.addAttribute("departs", departments);
        return "depart/departs";
    }

    //    进入添加部门页面
    @RequestMapping("/goAddDeparts")
    public String goAddDeparts() {
        return "depart/addDepart";
    }

    //    添加部门功能
    @RequestMapping("/addDepart")
    public String addDeparts(Department department, Log log, HttpSession session) {
//        获取当前操作的管理员名称
        Admin admin = (Admin) session.getAttribute("user");
        String adminName = admin.getAdmin_name();
        department.setCreatedBy(adminName);
        departService.addDepart(department);

        //        同时添加操作信息到操作日志
        log.setOperator(adminName);
        log.setDescription("添加了ID为：" + department.getDepartment_id() + "的部门");
        logService.addLog(log);

        return "redirect:/departs";//重定向到部门列表页面，刷新
    }

    //    进入修改部门页面
    @RequestMapping("/goUpdateDepart")
    public String goUpdateDepart(Integer id, Model model) {
//        根据前端传来的部门ID查询到该部门的信息
        Department department = departService.queryDepartByID(id);
//        再将部门信息返回到前端页面
        model.addAttribute("depart", department);
        return "depart/updateDepart";
    }

    @PostMapping("/updateDepart")
    public String updateDepart(Department department, Log log, HttpSession session) {
        Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
        Admin admin = (Admin) session.getAttribute("user");
        String adminName = admin.getAdmin_name();
        department.setModifyBy(adminName);
        department.setModifyDate(timestamp);

        departService.updateDepart(department);

        //        同时添加操作信息到操作日志
        log.setOperator(adminName);
        log.setDescription( "修改了ID为：" + department.getDepartment_id() + "的部门");
        logService.addLog(log);
        return "redirect:/departs";//重定向到部门列表页面，刷新
    }

    @RequestMapping("/deleteDepart")
    public String deleteEmps(Log log, int id, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("user");
        String adminName = admin.getAdmin_name();

        departService.deleteDepart(id);
        //        同时添加操作信息到操作日志
        log.setOperator(adminName);
        log.setDescription("删除了ID为：" + id + "的部门");
        logService.addLog(log);
        return "redirect:/departs";//重定向到部门列表页面，刷新
    }

}
