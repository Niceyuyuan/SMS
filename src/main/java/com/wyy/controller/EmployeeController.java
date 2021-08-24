package com.wyy.controller;


import com.wyy.pojo.Admin;
import com.wyy.pojo.Department;
import com.wyy.pojo.Employee;
import com.wyy.pojo.Log;
import com.wyy.service.DepartService;
import com.wyy.service.EmployeeService;
import com.wyy.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartService departService;

    @Autowired
    private LogService logService;

    //    进入员工管理页面，展示员工列表
    @RequestMapping("/emps")
    public String gotoEmps(Model model) {
        List<Employee> employeeList = employeeService.queryAllEmp();
        model.addAttribute("emps", employeeList);
//        按部门展示功能需要展示部门名
        List<Department> departments = departService.queryAllDeparts();
        model.addAttribute("departs", departments);
        return "emp/emps";
    }

    //按部门名字展示员工列表
    @RequestMapping("/queryByDname")
    public String queryByDname(Model model, String edName) {
        List<Employee> employeeList = employeeService.queryByDepart(edName);
        model.addAttribute("emps", employeeList);
//        按部门展示功能需要展示部门名
        List<Department> departments = departService.queryAllDeparts();
        model.addAttribute("departs", departments);
        return "emp/emps";
    }

//    通过用户输入的员工名搜索员工
    @RequestMapping("/queryByName")
    public String queryByName(Employee employee,Model model,String name){
        List<Employee> employeeList = employeeService.queryByName(name);
        model.addAttribute("emps", employeeList);
        List<Department> departments = departService.queryAllDeparts();
        model.addAttribute("departs", departments);
        return "emp/emps";
    }

    //进入员工添加页面
    @RequestMapping("/gotoAddEmps")
    public String goAddEmps(HttpSession session, Model model) {
//        返回给前端页面的部门信息
        List<Department> departments = departService.queryAllDeparts();
        model.addAttribute("departs", departments);
        return "emp/addEmps";
    }

    //    添加数据到数据库
    @RequestMapping("/addEmps")
    public String addEmps(Employee employee, Log log, Model model, HttpSession session) {
        //        获取回session里的管理员信息，一定要转换类型
        Admin admin = (Admin) session.getAttribute("user");
        String adminName = admin.getAdmin_name();
//        不经过前端用户输入，直接赋值给数据库
        employee.setCreatedBy(adminName);
        employeeService.addEmp(employee);

//        同时添加操作信息到操作日志
        log.setOperator(adminName);
        log.setDescription("添加了ID为：" + employee.getEmployee_id() + "的员工");
        logService.addLog(log);
        return "redirect:/emps";//添加完成重定向到/emps,刷新列表
    }



    //    进入修改员工页面
    @RequestMapping("/goUpdateEmps")
    public String goUpdateEmps(Integer id, Model model) {
//        查询指定id的员工，添加到empByID中，用于前端接收
        Employee employee = employeeService.queryById(id);
        model.addAttribute("empByID", employee);
        List<Department> departments = departService.queryAllDeparts();
        model.addAttribute("departs", departments);
        return "emp/updateEmps";
    }

    @PostMapping("/updateEmps")
    public String updateEmps(Employee employee, Log log, HttpSession session) {
        //        获取回session里的管理员信息，一定要转换类型
        Admin admin = (Admin) session.getAttribute("user");
        String adminName = admin.getAdmin_name();
//        Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        设置操作者的名字和修改时间
        employee.setModifyBy(adminName);
        employee.setModifyDate(timestamp);
        employeeService.updateEmp(employee);

        //        同时添加操作信息到操作日志
        log.setOperator(adminName);
        log.setDescription("修改了ID为：" + employee.getEmployee_id() + "的员工");
        logService.addLog(log);

        return "redirect:/emps";
    }

    @RequestMapping("/deleteEmps")
    public String deleteEmps(int id,Log log,HttpSession session) {
        //        获取回session里的管理员信息，一定要转换类型
        Admin admin = (Admin) session.getAttribute("user");
        String adminName = admin.getAdmin_name();
        employeeService.deleteEmp(id);

        //        同时添加操作信息到操作日志
        log.setOperator(adminName);
        log.setDescription("删除了ID为：" + id + "的员工");
        logService.addLog(log);
        return "redirect:/emps";//添加完成重定向到/emps,刷新列表
    }
}
