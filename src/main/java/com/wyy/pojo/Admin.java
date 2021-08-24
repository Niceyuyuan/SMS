package com.wyy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
//管理员表
public class Admin implements Serializable {
    private Integer admin_id;//管理员id
    private String admin_name;//管理员姓名
    private String username;//管理员用户名
    private String password;//管理员登录密码
    private String departname;//管理员所属部门
    private String createdBy;//创建者
    private Timestamp createdDate;//创建日期
    private String modifyBy;//修改者
    private Timestamp modifyDate;//修改日期

    private Department department;
}
