package com.huatai.app.controller;

import com.huatai.app.util.PostUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        String mobile = "13959171556";
        try {
            // 1. 获取域名
            String serverName = request.getServerName();

            // 2. 根据域名查找手机号
            HashMap<String, Object> params = new HashMap<>();
            params.put("domain", serverName);
            PostUtil postUtil = new PostUtil();
            String formDataPost = postUtil.getMobileByDomain(params);
            if (StringUtils.isNotBlank(formDataPost)) {
                System.out.println("formDataPost：" + formDataPost);
                JSONObject json = JSONObject.fromObject(formDataPost);
                System.out.println(serverName);

                // 3. 重定向到分类列表
                Object data = json.get("data");

                if (data != null) {
                    mobile = data.toString();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/category/list/" + Long.valueOf(mobile) * 2;
    }


}
