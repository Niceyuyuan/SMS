package com.wyy.mapper;

import com.wyy.pojo.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {
//    查询所有的日志
    List<Log> queryAllLog();
//    添加日志
    int addLog(Log log);
}
