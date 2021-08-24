package com.wyy.mapper;

import com.wyy.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
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
