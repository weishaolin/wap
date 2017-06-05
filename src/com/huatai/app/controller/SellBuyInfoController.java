package com.huatai.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatai.app.util.PostUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/sellBuyInfo")
public class SellBuyInfoController {

	@Resource
	private PostUtil postUtil;
	
	//list界面
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public  String prolist(Model model){
		HashMap<String, Object> map = new HashMap<String, Object>();
		//map.put("currentUserId", "1");
		map.put("requestType","SELL");//只查询供应数据
		String formDataPost = postUtil.formDataPostSellBuyInfoList(map);
		System.out.println("formDataPost："+formDataPost);
		JSONObject json = JSONObject.fromObject(formDataPost);
		model.addAttribute("prolist", json);
		System.out.println("model:"+model);
		return "fivepage/sellBuyInfoList";
	} 
	
	//list界面
	@RequestMapping(value="/list/material",method = RequestMethod.GET)
	public  String productListByMaterial(@RequestParam(value="classificationId") String classificationId,
			@RequestParam(value="classificationName") String classificationName,Model model){
//				HashMap<String, Object> map = new HashMap<String, Object>();
//				map.put("currentUserId", "1");
//				map.put("classificationId", classificationId);
//				map.put("requestType","SELL");//只查询供应数据
//				String formDataPost = postUtil.formDataPostSellBuyInfoList(map);
//				System.out.println("formDataPost："+formDataPost);
//				JSONObject json = JSONObject.fromObject(formDataPost);
////				JSONArray jsonArray = json.getJSONArray(json);
//				model.addAttribute("prolist", json);
//				model.addAttribute("classificationId", classificationId);
//				model.addAttribute("classificationName", classificationName);
//				System.out.println("model:"+model);
				return "fivepage/sellBuyInfoList";
			}
	@RequestMapping(value="/list/material/{mobile}",method = RequestMethod.GET)
	public  String productListByMaterial4Supplier(@PathVariable("mobile") String mobile,@RequestParam(value="classificationId") String classificationId,
			@RequestParam(value="classificationName") String classificationName,Model model){
//				System.out.println("進入");
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("currentUserId", "1");
				map.put("classificationId", classificationId);
				map.put("requestType","SELL");//只查询供应数据
				if(StringUtils.isNumeric(mobile)){
					Long i = Long.valueOf(mobile.trim())/2;
					mobile = i.toString();
				}
				String formDataPost = postUtil.formDataPostSupplierSellBuyInfoList(map, mobile);
				System.out.println("formDataPost："+formDataPost);
				JSONObject json = JSONObject.fromObject(formDataPost);
//				JSONArray jsonArray = json.getJSONArray(json);
				model.addAttribute("prolist", json);
				model.addAttribute("classificationId", classificationId);
				model.addAttribute("classificationName", classificationName);
				System.out.println("model:"+model);
				return "fivepage/sellBuyInfoList4Supplier";
			} 
		//长度最长
		@RequestMapping(value="/sortProperty",method = RequestMethod.GET)
		public  String sortProperty(@RequestParam(value="sortProperty") String sortProperty, 
				@RequestParam(value="materialId") String materialId,Model model){
//			System.out.println("進入:"+sortProperty);
//			HashMap<String, Object> map = new HashMap<String, Object>();
//			map.put("currentUserId", "1");
//			map.put("sortProperty", sortProperty);
//			map.put("material", materialId);
//			map.put("requestType","SELL");//只查询供应数据
//			String formDataPost = postUtil.formDataPostSellBuyInfoList(map);
//			System.out.println("formDataPost："+formDataPost);
//			JSONObject json = JSONObject.fromObject(formDataPost);
//			model.addAttribute("prolist", json);
//			model.addAttribute("sortProperty", map);
//			model.addAttribute("materialId", materialId);
//			System.out.println("model:"+model);
			return "fivepage/sellBuyInfoList";
		}
		
		//长度最长
		@RequestMapping(value="/sortProperty/{mobile}",method = RequestMethod.GET)
		public  String sortProperty4Supplier(@PathVariable("mobile") String mobile,@RequestParam(value="sortProperty") String sortProperty, 
				@RequestParam(value="materialId") String materialId,Model model){
			System.out.println("進入:"+sortProperty);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("currentUserId", "1");
			map.put("sortProperty", sortProperty);
			map.put("material", materialId);
			map.put("requestType","SELL");//只查询供应数据
			if(StringUtils.isNumeric(mobile)){
				Long i = Long.valueOf(mobile.trim())/2;
				mobile = i.toString();
			}
			String formDataPost = postUtil.formDataPostSupplierSellBuyInfoList(map, mobile);
			System.out.println("formDataPost："+formDataPost);
			JSONObject json = JSONObject.fromObject(formDataPost);
			model.addAttribute("prolist", json);
			model.addAttribute("sortProperty", map);
			model.addAttribute("materialId", materialId);
			System.out.println("model:"+model);
			return "fivepage/sellBuyInfoList4Supplier";
		}		
		
		//排序
		@RequestMapping(value="/searchString",method = RequestMethod.GET)
		public  String searchString(@RequestParam(value="searchString") String searchString, Model model){
//			System.out.println("進入:"+searchString);
//			HashMap<String, Object> map = new HashMap<String, Object>();
//			map.put("currentUserId", "1");
//			map.put("searchString", searchString);
//			map.put("requestType","SELL");//只查询供应数据
//			String formDataPost = postUtil.formDataPostSellBuyInfoList(map);
//			System.out.println("formDataPost："+formDataPost);
//			JSONObject json = JSONObject.fromObject(formDataPost);
//			model.addAttribute("prolist", json);
//			model.addAttribute("searchString", map);
//			System.out.println("model:"+model);
			return "fivepage/sellBuyInfoList";
		}
		//排序
		@RequestMapping(value="/searchString/{mobile}",method = RequestMethod.GET)
		public  String searchString4Supplier(@PathVariable("mobile") String mobile,@RequestParam(value="searchString") String searchString, Model model){
			System.out.println("進入:"+searchString);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("currentUserId", "1");
			map.put("searchString", searchString);
			map.put("requestType","SELL");//只查询供应数据
			if(StringUtils.isNumeric(mobile)){
				Long i = Long.valueOf(mobile.trim())/2;
				mobile = i.toString();
			}
			String formDataPost = postUtil.formDataPostSupplierSellBuyInfoList(map,mobile);
			System.out.println("formDataPost："+formDataPost);
			JSONObject json = JSONObject.fromObject(formDataPost);
			model.addAttribute("prolist", json);
			model.addAttribute("searchString", map);
			System.out.println("model:"+model);
			return "fivepage/sellBuyInfoList4Supplier";
		}		
		//筛选
		@RequestMapping(value="/screen")
		public  String screen(@RequestParam(value="data") String data, Model  model){
//			System.out.println("進入:"+data);
//			JSONObject jb=JSONObject.fromObject(data);
//			HashMap<String, Object> map = new HashMap<String, Object>();
//			map.put("currentUserId", "1");
//			if(jb.getString("beginLength").length()>0 && jb.getString("endLength").length()>0){
//				map.put("beginLength", jb.getString("beginLength"));
//				map.put("endLength", jb.getString("endLength"));
//			}
//			if(jb.getString("beginWidth").length()>0 && jb.getString("endWidth").length()>0){
//				map.put("beginWidth",jb.getString("beginWidth"));
//				map.put("endWidth", jb.getString("endWidth"));
//			}
//			if(jb.getString("beginHeight").length()>0 && jb.getString("endHeight").length()>0){
//				map.put("beginHeight", jb.getString("beginHeight"));
//				map.put("endHeight", jb.getString("endHeight"));
//			}
//			if(jb.getString("edgeShape").length()>0){
//				map.put("edgeShape",jb.getString("edgeShape"));
//			}
//			if(jb.getString("edgeShape").length()>0){
//				map.put("edgeShape",jb.getString("edgeShape"));
//			}
//			if(jb.getString("material").length()>0){
//				map.put("material",jb.getString("material"));
//			}
//			if(jb.getString("searchString").length()>0){
//				map.put("searchString", jb.getString("searchString"));
//				model.addAttribute("searchString", jb.getString("searchString"));
//			}
//			System.out.println("map:"+map);
//			map.put("requestType","SELL");//只查询供应数据
//			String formDataPost = postUtil.formDataPostSellBuyInfoList(map);
//			System.out.println("formDataPost："+formDataPost);
//			JSONObject json = JSONObject.fromObject(formDataPost);
//			model.addAttribute("prolist", json);
//			model.addAttribute("materialId", jb.getString("material"));
//			JSONObject transmit = JSONObject.fromObject(map);
//			System.out.println("transmit:"+transmit);
//			model.addAttribute("transmit", transmit);
			return "fivepage/sellBuyInfoList";
		}
			//筛选
		@RequestMapping(value="/screen/{mobile}")
		public  String screen4Supplier(@PathVariable("mobile") String mobile,@RequestParam(value="data") String data, Model  model){
//			System.out.println("進入:"+data);
			JSONObject jb=JSONObject.fromObject(data);
//			System.out.println("jb:"+jb.getString("beginWidth").length());
//			System.out.println("jb2:"+jb.getString("beginLength").length());
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("currentUserId", "1");
			if(jb.getString("beginLength").length()>0 && jb.getString("endLength").length()>0){
				map.put("beginLength", jb.getString("beginLength"));
				map.put("endLength", jb.getString("endLength"));
			}
			if(jb.getString("beginWidth").length()>0 && jb.getString("endWidth").length()>0){
				map.put("beginWidth",jb.getString("beginWidth"));
				map.put("endWidth", jb.getString("endWidth"));
//				System.out.println("width:"+"jjjjjjjjjjjjjjjjjj");
			}
			if(jb.getString("beginHeight").length()>0 && jb.getString("endHeight").length()>0){
				map.put("beginHeight", jb.getString("beginHeight"));
				map.put("endHeight", jb.getString("endHeight"));
			}
			if(jb.getString("edgeShape").length()>0){
				map.put("edgeShape",jb.getString("edgeShape"));
			}
			if(jb.getString("edgeShape").length()>0){
				map.put("edgeShape",jb.getString("edgeShape"));
			}
			if(jb.getString("material").length()>0){
				map.put("material",jb.getString("material"));
			}
			if(jb.getString("searchString").length()>0){
				map.put("searchString", jb.getString("searchString"));
				model.addAttribute("searchString", jb.getString("searchString"));
			}
			System.out.println("map:"+map);
			map.put("requestType","SELL");//只查询供应数据
			if(StringUtils.isNumeric(mobile)){
				Long i = Long.valueOf(mobile.trim())/2;
				mobile = i.toString();
			}
			String formDataPost = postUtil.formDataPostSupplierSellBuyInfoList(map,mobile);
			System.out.println("formDataPost："+formDataPost);
			JSONObject json = JSONObject.fromObject(formDataPost);
			model.addAttribute("prolist", json);
			model.addAttribute("materialId", jb.getString("material"));
			JSONObject transmit = JSONObject.fromObject(map);
			System.out.println("transmit:"+transmit);
			model.addAttribute("transmit", transmit);
			return "fivepage/sellBuyInfoList4Supplier";
		}
		
		@RequestMapping(value="/pullUp",produces="text/html;charset=UTF-8")
		@ResponseBody
		public  String pullUp(@RequestParam(value="pullUp") String pullUp, Model model){
			System.out.println("進入:"+pullUp);
			JSONObject jb=JSONObject.fromObject(pullUp);
			System.out.println("jb:"+jb.getString("beginWidth").length());
			System.out.println("jb2:"+jb.getString("beginLength").length());
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("currentUserId", "1");
			if(jb.getString("beginLength").length()>0 && jb.getString("endLength").length()>0){
				map.put("beginLength", jb.getString("beginLength"));
				map.put("endLength", jb.getString("endLength"));
			}
			if(jb.getString("beginWidth").length()>0 && jb.getString("endWidth").length()>0){
				map.put("beginWidth",jb.getString("beginWidth"));
				map.put("endWidth", jb.getString("endWidth"));
				System.out.println("width:"+"jjjjjjjjjjjjjjjjjj");
			}
			if(jb.getString("beginHeight").length()>0 && jb.getString("endHeight").length()>0){
				map.put("beginHeight", jb.getString("beginHeight"));
				map.put("endHeight", jb.getString("endHeight"));
			}
			if(jb.getString("edgeShape").length()>0){
				map.put("edgeShape",jb.getString("edgeShape"));
			}
			if(jb.getString("pageSize").length()>0){
				map.put("page", jb.getString("pageSize"));
			}
			if(jb.getString("sortProperty").length()>0){
				map.put("sortProperty",jb.getString("sortProperty"));
			}
			if(jb.getString("searchString").length()>0){
				map.put("searchString",jb.getString("searchString"));
			}
			if(jb.getString("material").length()>0){
				map.put("material",jb.getString("material"));
			}
			System.out.println("map:"+map);
			map.put("requestType","SELL");//只查询供应数据
			String formDataPost = postUtil.formDataPostSellBuyInfoList(map);
			System.out.println("formDataPost："+formDataPost);
			JSONObject json = JSONObject.fromObject(formDataPost);
			model.addAttribute("prolist", json);
			model.addAttribute("materialId", jb.getString("material"));
	/*		JSONObject transmit = JSONObject.fromObject(map);
			System.out.println("transmit:"+transmit);
			model.addAttribute("transmit", transmit);*/
			return formDataPost;
		}
		
		@RequestMapping(value="/pullUp/{mobile}",produces="text/html;charset=UTF-8")
		@ResponseBody
		public  String pullUp4Supplier(@PathVariable("mobile") String mobile,@RequestParam(value="pullUp") String pullUp, Model model){
			System.out.println("進入:"+pullUp);
			JSONObject jb=JSONObject.fromObject(pullUp);
			System.out.println("jb:"+jb.getString("beginWidth").length());
			System.out.println("jb2:"+jb.getString("beginLength").length());
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("currentUserId", "1");
			if(jb.getString("beginLength").length()>0 && jb.getString("endLength").length()>0){
				map.put("beginLength", jb.getString("beginLength"));
				map.put("endLength", jb.getString("endLength"));
			}
			if(jb.getString("beginWidth").length()>0 && jb.getString("endWidth").length()>0){
				map.put("beginWidth",jb.getString("beginWidth"));
				map.put("endWidth", jb.getString("endWidth"));
				System.out.println("width:"+"jjjjjjjjjjjjjjjjjj");
			}
			if(jb.getString("beginHeight").length()>0 && jb.getString("endHeight").length()>0){
				map.put("beginHeight", jb.getString("beginHeight"));
				map.put("endHeight", jb.getString("endHeight"));
			}
			if(jb.getString("edgeShape").length()>0){
				map.put("edgeShape",jb.getString("edgeShape"));
			}
			if(jb.getString("pageSize").length()>0){
				map.put("page", jb.getString("pageSize"));
			}
			if(jb.getString("sortProperty").length()>0){
				map.put("sortProperty",jb.getString("sortProperty"));
			}
			if(jb.getString("searchString").length()>0){
				map.put("searchString",jb.getString("searchString"));
			}
			if(jb.getString("classificationId").length()>0){
				map.put("classificationId",jb.getString("classificationId"));
			}
			System.out.println("map:"+map);
			map.put("requestType","SELL");//只查询供应数据
			if(StringUtils.isNumeric(mobile)){
				Long i = Long.valueOf(mobile.trim())/2;
				mobile = i.toString();
			}
			String formDataPost = postUtil.formDataPostSupplierSellBuyInfoList(map,mobile);
			System.out.println("formDataPost："+formDataPost);
			JSONObject json = JSONObject.fromObject(formDataPost);
			model.addAttribute("prolist", json);
			model.addAttribute("classificationId", jb.getString("classificationId"));
	/*		JSONObject transmit = JSONObject.fromObject(map);
			System.out.println("transmit:"+transmit);
			model.addAttribute("transmit", transmit);*/
			return formDataPost;
		}
		
	//详情界面
	@RequestMapping(value="/info")
	public  String productinfo(@RequestParam(value="uid") String uid, Model  model){
		System.out.println("進入:"+uid);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		String formDataPost = postUtil.formDataPostSellBuyInfo(map);
		System.out.println("formDataPost："+formDataPost);
		JSONObject json = JSONObject.fromObject(formDataPost);
		//开始解析  图片地址
		List arrayList = new ArrayList<>();
		String data = json.getString("data");
		JSONObject jsondata = JSONObject.fromObject(data);
		String productAlbum = jsondata.getString("sellBuyAlbum");
		System.out.println("========"+productAlbum.length());
		 String[] sourceStrArray = productAlbum.split(",");
		 System.out.println("sourceStrArray.length:"+sourceStrArray.length);
	        for (int i = 0; i < sourceStrArray.length; i++) {
	            System.out.println(sourceStrArray[i]);
	            map.put("image", sourceStrArray[i]);
	            JSONObject jb=JSONObject.fromObject(map);
	            arrayList.add(jb);
	        }
		System.out.println("arrayList:"+arrayList);
		JSONArray jsonarry=JSONArray.fromObject(arrayList);
		//解析结束
		model.addAttribute("prolist", json);
		model.addAttribute("productAlbum", jsonarry);
		return "fivepage/sellBuyInfoDetails";
	}
}
