package com.wyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class indexController {

    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }
}
