package com.wyy.service;

import com.wyy.mapper.AdminMapper;
import com.wyy.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    //    调用mapper层
    private AdminMapper adminMapper;

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Admin> queryAlladmin() {
        return adminMapper.queryAlladmin();
    }

    @Override
    public Admin queryAdmin(String username, String password) {
        return adminMapper.queryAdmin(username, password);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public int deleteAdmin(Integer admin_id) {
        return adminMapper.deleteAdmin(admin_id);
    }
}
