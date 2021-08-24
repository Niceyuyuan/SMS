package com.wyy.service;

import com.wyy.mapper.DepartMapper;
import com.wyy.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {
//    调用mapper层
    private DepartMapper departMapper;

    @Autowired
    public void setDepartMapper(DepartMapper departMapper){
        this.departMapper = departMapper;
    }

    @Override
    public Department queryDepartByID(Integer id) {
        return departMapper.queryDepartByID(id);
    }

    @Override
    public List<Department> queryAllDeparts() {
        return departMapper.queryAllDeparts();
    }

    @Override
    public int addDepart(Department department) {
        return departMapper.addDepart(department);
    }

    @Override
    public int updateDepart(Department department) {
        return departMapper.updateDepart(department);
    }

    @Override
    public int deleteDepart(Integer id) {
        return departMapper.deleteDepart(id);
    }
}
