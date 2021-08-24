package com.wyy.service;

import com.wyy.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    //    查询全部员工
    List<Employee> queryAllEmp();

    //    增加员工
    int addEmp(Employee employee);

    //    根据id删除员工
    int deleteEmp(Integer id);

    //    修改员工信息
    int updateEmp(Employee employee);

    //    根据员工名字搜索员工
    List<Employee> queryByName(String name);

    //    根据部门显示员工
    List<Employee> queryByDepart(String edName);

    //    根据员工ID获取员工
    Employee queryById(Integer id);
}
