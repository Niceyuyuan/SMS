package com.wyy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

//员工表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private Integer employee_id;//员工id
    private String employee_name;//员工名称
    private String employee_job;//员工所属岗位
    private Integer ed_id;//员工所属部门id
    private Integer gender;//性别，0:女 1：男
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;//生日日期
    private String phone;//电话号码
    private String address;//地址
    private String createdBy;//创建者
    private Timestamp createdDate;//创建日期
    private String modifyBy;//修改者
    private Timestamp modifyDate;//修改日期


    private Department department;//调用Department类，获取关联的部门信息
    private String department_name;//因为表employee里只有部门id，没有部门名称，而前端显示需要部门名称
//    故需在此类设与表department部门名称department_name字段相同的属性

}
