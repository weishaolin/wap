package com.huatai.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huatai.app.util.PostUtil;

@Controller("/app")
public class MyWageController {

	@Resource
	public PostUtil postUtil;
	
	@RequestMapping("/myWage")
	public String myWage(){
		//postUtil.post(postUrl, param);
		return "";
	}
}
