package com.wyy.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
//    解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        获取请求中的国际化参数
        String language = httpServletRequest.getParameter("l");
//        默认地区
        Locale locale = Locale.getDefault();
//        如果请求的链接参数不为空，携带了国际化参数
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");//zh_CN（语言-地区）
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
