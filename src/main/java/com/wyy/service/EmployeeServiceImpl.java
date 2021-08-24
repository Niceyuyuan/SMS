package com.wyy.service;


import com.wyy.mapper.EmployeeMapper;
import com.wyy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //    调用mapper层
    @Autowired
    private EmployeeMapper employeeMapper;

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> queryAllEmp() {
        return employeeMapper.queryAllEmp();
    }


    @Override
    public int addEmp(Employee employee) {
        return employeeMapper.addEmp(employee);
    }

    @Override
    public int updateEmp(Employee employee) {
        return employeeMapper.updateEmp(employee);
    }

    @Override
    public List<Employee> queryByName(String name) {
        return employeeMapper.queryByName(name);
    }

    @Override
    public List<Employee> queryByDepart(String edName) {
        return employeeMapper.queryByDepart(edName);
    }

    @Override
    public int deleteEmp(Integer id) {
        return employeeMapper.deleteEmp(id);
    }

    @Override
    public Employee queryById(Integer id) {
        return employeeMapper.queryById(id);
    }
}
