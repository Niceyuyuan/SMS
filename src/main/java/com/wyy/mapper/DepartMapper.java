package com.wyy.mapper;

import com.wyy.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartMapper {
    //    查询全部部门
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
