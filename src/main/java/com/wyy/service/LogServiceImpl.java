package com.wyy.service;

import com.wyy.mapper.LogMapper;
import com.wyy.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    public void setLogMapper(LogMapper logMapper){
        this.logMapper = logMapper;
    }
    @Override
    public List<Log> queryAllLog() {
        return logMapper.queryAllLog();
    }

    @Override
    public int addLog(Log log) {
        return logMapper.addLog(log);
    }
}
