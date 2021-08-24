package com.wyy.controller;

import com.wyy.pojo.Log;
import com.wyy.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LogController {

    @Autowired
    private LogService logService;

//    进入操作日志页面
    @RequestMapping("/goLog")
    public String goLog(Model model){
        List<Log> logs = logService.queryAllLog();
        model.addAttribute("logs",logs);
        return "myLog/log";
    }
}
