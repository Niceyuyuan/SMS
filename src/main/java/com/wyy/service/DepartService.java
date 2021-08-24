package com.wyy.service;


import com.wyy.pojo.Department;

import java.util.List;

public interface DepartService {
    //    查询全部部门(关联员工所属部门id)
    List<Department> queryAllDeparts();
    //    根据部门id查询部门
    Department queryDepartByID(Integer id);
    //    增加部门
    int addDepart(Department department);
    //    修改部门
    int updateDepart(Department department);
    //    删除部门
    int deleteDepart(Integer id);
}
