package com.huatai.app.controller;

import com.huatai.app.util.PostUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private PostUtil postUtil;

    //list界面--可以看到所有产品
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String prolist(Model model) {
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("page", "0");
//		String formDataPost = postUtil.formDataPostCategoryList(map);
//		System.out.println("formDataPost："+formDataPost);
//		JSONObject json = JSONObject.fromObject(formDataPost);
//		model.addAttribute("categoryList", json);
//		
//		//加入供求产品栏目
//		map.put("requestType","SELL");//只查询供应数据
//		String formDataPostSellBuy = postUtil.formDataPostSellBuyInfoCategory(map);
//		System.out.println("formDataPost："+formDataPost);
//		JSONObject jsonSellBuy = JSONObject.fromObject(formDataPostSellBuy);
//		model.addAttribute("sellBuyList", jsonSellBuy);
        return "fivepage/categoryList";
    }

    //list界面--可以看到所有产品
    @RequestMapping(value = "/list/{mobile}", method = RequestMethod.GET)
    public String getSupplierCategory(@PathVariable("mobile") String mobile, Model model) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("page", "0");
        if (StringUtils.isNumeric(mobile)) {
            Long i = Long.valueOf(mobile.trim()) / 2;
            mobile = i.toString();
        }
        String formDataPost = postUtil.formDataPostSupplierCategoryList(map, mobile);
        System.out.println("formDataPost：" + formDataPost);
        JSONObject json = JSONObject.fromObject(formDataPost);
        model.addAttribute("categoryList", json);
        model.addAttribute("mobile", mobile);

        //加入供求产品栏目
        map.put("requestType", "SELL");//只查询供应数据
        String formDataPostSellBuy = postUtil.formDataPostSupplierSellBuyInfoCategory(map, mobile);
        if (StringUtils.isNotBlank(formDataPostSellBuy)) {
            System.out.println("formDataPostSellBuy：" + formDataPostSellBuy);
            JSONObject jsonSellBuy = JSONObject.fromObject(formDataPostSellBuy);
//			JSONArray jsonArray = json.getJSONArray(json);
            model.addAttribute("sellBuyList", jsonSellBuy);
        }
        return "fivepage/categoryList4Supplier";
    }
}
