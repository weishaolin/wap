package com.huatai.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        // 1. 获取域名
        String serverName = request.getServerName();
        // 2. 根据域名查找手机号
        System.out.println(serverName);
        // 3. 重定向到分类列表
        String mobile = "18705928704";

        return "redirect:/category/list/" + Long.valueOf(mobile) * 2;
    }


}
