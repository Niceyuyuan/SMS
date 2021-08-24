package com.wyy.service;

import com.wyy.pojo.Admin;

import java.util.List;

public interface AdminService {
    //    查询所有的管理员名单
    List<Admin> queryAlladmin();

    //  登录功能：根据用户名查询管理员信息
    Admin queryAdmin(String username,String password);

    //    添加管理员
    int addAdmin(Admin admin);

    //   修改管理员信息
    int updateAdmin(Admin admin);

    //   删除管理员
    int deleteAdmin(Integer admin_id);
}
