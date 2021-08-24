package com.wyy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

//部门表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {
    private Integer department_id;//部门id
    private String department_name;//部门名称
    private String PrincipalUser;//部门主管
    private String createdBy;//创建者
    private Timestamp createdDate;//创建日期
    private String modifyBy;//修改者
    private Timestamp modifyDate;//修改日期

    private Integer num;//部门人数

}


