package com.wyy.service;

import com.wyy.pojo.Log;

import java.util.List;

public interface LogService {
    //    查询所有的日志
    List<Log> queryAllLog();
    //    添加日志
    int addLog(Log log);
}
