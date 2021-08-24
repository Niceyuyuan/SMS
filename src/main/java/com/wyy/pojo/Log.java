package com.wyy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable {
    private String operator;//操作者
    private String description;//操作描述
    private Timestamp time;//操作时间
}
