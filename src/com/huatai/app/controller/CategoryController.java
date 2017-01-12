package com.huatai.app.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.data.annotation.Reference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;	
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.huatai.app.entity.ProlistEntity;
import com.huatai.app.util.PostUtil;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Resource
	private PostUtil postUtil;
	
	//list界面
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public  String prolist(Model model){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("page", "0");
		String formDataPost = postUtil.formDataPostCategoryList(map);
		System.out.println("formDataPost："+formDataPost);
		JSONObject json = JSONObject.fromObject(formDataPost);
		model.addAttribute("categoryList", json);
		
		//加入供求产品栏目
		map.put("requestType","SELL");//只查询供应数据
		String formDataPostSellBuy = postUtil.formDataPostSellBuyInfoList(map);
		System.out.println("formDataPost："+formDataPost);
		JSONObject jsonSellBuy = JSONObject.fromObject(formDataPostSellBuy);
//		JSONArray jsonArray = json.getJSONArray(json);
		model.addAttribute("sellBuyList", jsonSellBuy);
		return "fivepage/categoryList";
	} 
}
