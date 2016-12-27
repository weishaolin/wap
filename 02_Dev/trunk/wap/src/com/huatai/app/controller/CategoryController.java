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
		System.out.println("進入");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("page", "0");
		String formDataPost = postUtil.formDataPostCategoryList(map);
		System.out.println("formDataPost："+formDataPost);
		JSONObject json = JSONObject.fromObject(formDataPost);
//		JSONArray jsonArray = json.getJSONArray(json);
		model.addAttribute("categoryList", json);
		System.out.println("model:"+model);
		return "fivepage/categoryList";
	} 
}
