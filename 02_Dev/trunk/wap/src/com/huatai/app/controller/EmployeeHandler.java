package com.huatai.app.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class EmployeeHandler {
	
	
//    final static String url = "";  
//    final static String params = "{\"id\":\"12345\"}";  
  
    /** 
     * 发送HttpPost请求 
     *  
     * @param strURL 
     *            服务地址 
     * @param params 
     *            json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/> 
     * @return 成功:返回json字符串<br/> 
     */  
	@RequestMapping("/post")
	@ResponseBody
    public  String post() {  
    	String strURL="http://10.100.3.114:7003/fw-app/app/cmc/mySalary";
    	String params="[{\"currentlevel\":\"12345\"}]";
        System.out.println(strURL);  
        System.out.println(params);  
        try {  
            URL url = new URL(strURL);// 创建连接  
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);  
            connection.setUseCaches(false);  
            connection.setInstanceFollowRedirects(true);  
            connection.setRequestMethod("POST"); // 设置请求方式  
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式  
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式  
            connection.connect();  
            OutputStreamWriter out = new OutputStreamWriter(  
                    connection.getOutputStream(), "UTF-8"); // utf-8编码  
            out.append(params);  
            
            out.flush();  
            out.close();  
            // 读取响应  
            int length = (int) connection.getContentLength();// 获取长度  
            InputStream is = connection.getInputStream();  
            if (length != -1) {  
                byte[] data = new byte[length];  
                byte[] temp = new byte[512];  
                int readLen = 0;  
                int destPos = 0;  
                while ((readLen = is.read(temp)) > 0) {  
                    System.arraycopy(temp, 0, data, destPos, readLen);  
                    destPos += readLen;  
                }  
                String result = new String(data, "UTF-8"); // utf-8编码  
                System.out.println(result);  
                return result;  
            }  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
        	return e.getMessage();
           // e.printStackTrace();
        }  
        return "error"; // 自定义错误信息  
    }  

	// 请求转发
	@RequestMapping("/forwardConnect")
	@ResponseBody
	public String forwardConnect() {
		String url = "";
		try {

			// System.out.println(path);
			Properties pro = new Properties();
			InputStream in = null;
			in = this.getClass().getResourceAsStream("/forwardConnect.properties");
			pro.load(in);
			url = pro.getProperty("GsTestUrl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// System.out.println(url);
		RestTemplate restTemplate = new RestTemplate();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("policyCode", "11");
		JSONArray jsonObj = JSONArray.fromObject(map);
		// url="http://192.168.3.103:8080/jdev/gs/month/schedulConcludeRate/gstest?pageNumber=2";
		String Controllerurl = url + "/app/cmc/mySalary";
		// String
		// Controllerurl="http://192.168.0.89:8080/fw-app/app/cmc/mySalary";
		// http://10.100.1.125:7003/fw-app/app/cmc/mySalary
		//http: // 10.100.1.125:7003/fw-app/app/cmc/mySalary
		// String url = "http://192.168.3.134:8080/jdev/app/cmc/test";
		System.out.println(Controllerurl);

		/*
		 * List messageConverters=new ArrayList(); messageConverters.add(new
		 * SourceHttpMessageConverter()); messageConverters.add(new
		 * FormHttpMessageConverter()); messageConverters.add(new
		 * MappingJackson2HttpMessageConverter());
		 * restTemplate.setMessageConverters(messageConverters);
		 */

		System.out.println(jsonObj);
		String result="";
		try {
			 result = restTemplate.postForObject(Controllerurl, jsonObj, String.class);
		} catch (Exception e) {
			// TODO: handle exception
		return	e.getMessage();
		}
//		 result = restTemplate.postForObject(Controllerurl, jsonObj, String.class);
		System.out.println("result:" + result);
		return result;
		// return "";
	}

	@RequestMapping("/getUrl")
	@ResponseBody
	public String getUrl() {
		String url = "";
		try {

			// System.out.println(path);
			Properties pro = new Properties();
			InputStream in = null;
			in = this.getClass().getResourceAsStream("/forwardConnect.properties");
			pro.load(in);
			url = pro.getProperty("GsTestUrl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;

	}

	@RequestMapping("/getSj")
	@ResponseBody
	public String getSj() {
		RestTemplate restTemplate = new RestTemplate();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("currentlevel", "11");
		JSONArray jsonObj = JSONArray.fromObject(map);
		String Controllerurl = "http://10.100.3.114:7003/fw-app/app/cmc/mySalary";
		String result = restTemplate.postForObject(Controllerurl, jsonObj, String.class);
		return result;

	}
	
	@RequestMapping("/getSS")
	@ResponseBody
	public String getSS() {
		RestTemplate restTemplate = new RestTemplate();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("policyCode", "11");
		JSONArray jsonObj = JSONArray.fromObject(map);
		String Controllerurl = "http://111.205.18.36:7003/fw-app-iparent/getTest";
		String result = restTemplate.postForObject(Controllerurl, jsonObj, String.class);
		return result;

	}
	
	@RequestMapping("/getCs")
	@ResponseBody
	public String getCs() {
		RestTemplate restTemplate = new RestTemplate();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("policyCode", "11");
		JSONArray jsonObj = JSONArray.fromObject(map);
		return jsonObj.toString();
	}

	@RequestMapping("/getTest")
	public String getTest() {
//		String test="Test one ";
		return "emp/myWage";
	}
	@RequestMapping("/gggg")
	public String gggg(){
		return "huatai/myWage";
	}
	@RequestMapping("/ipPing")
	@ResponseBody
	public String    ipPing(){
		boolean status = false;  
		 try {
			status = InetAddress.getByName("10.100.1.125").isReachable(3000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 String result="";
		 if (status) {
			 result="success";
		}else{
			 result="error";
		}
		return result;
	}
	
	@RequestMapping("/pingIpTwo")
	@ResponseBody
	public String pingIpTwo(){
		// 方法一 最常用的 PING 方法
		  Runtime runtime = Runtime.getRuntime(); // 获取当前程序的运行进对象
		  Process process = null; // 声明处理类对象
		  String line = null; // 返回行信息
		  InputStream is = null; // 输入流
		  InputStreamReader isr = null; // 字节流
		  BufferedReader br = null;
		  String ip = "10.100.1.125";
		  boolean res = false;// 结果
		  try {
		   process = runtime.exec("ping " + ip); // PING

		   is = process.getInputStream(); // 实例化输入流
		   isr = new InputStreamReader(is);// 把输入流转换成字节流
		   br = new BufferedReader(isr);// 从字节中读取文本
		   while ((line = br.readLine()) != null) {
		    if (line.contains("TTL")) {
		     res = true;
		     break;
		    }
		   }
		   is.close();
		   isr.close();
		   br.close();
		   if (res) {
		    System.out.println("ping 通  ...");
		    return "success";
		   } else {
		    System.out.println("ping 不通...");
		    return "error";
		   }
		  } catch (IOException e) {
		   System.out.println(e);
		   
		   runtime.exit(1);
		   return e.toString();
		  }

	}
	
	@RequestMapping("/ky")
	@ResponseBody
	public String ky(){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("policyCode", "11");
		
		RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
         headers.setContentType(type);
         headers.add("Accept", MediaType.APPLICATION_JSON.toString());
         headers.setOrigin("Access-Control-Allow-Origin");
         JSONObject jsonObj = JSONObject.fromObject(map);

       HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
       String url = "http://10.100.1.125:7003/fw-app/app/cmc/mySalary";
        String result = restTemplate.postForObject(url, formEntity, String.class);
		return result;
		}
	
	@RequestMapping("/kyTwo")
	@ResponseBody
	public String kyTwo(){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("policyCode", "11");
		
		RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
         headers.setContentType(type);
         headers.add("Accept", MediaType.APPLICATION_JSON.toString());
         headers.add("Access-Control-Allow-Origin","*");
         headers.add("Access-Control-Allow-Methods", "POST");
         headers.add("Access-Control-Max-Age", "3628800");
         headers.add("Access-Control-Allow-Headers","x-requested-with");
         JSONObject jsonObj = JSONObject.fromObject(map);

       HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
       String url = "http://10.100.1.125:7003/fw-app/app/cmc/mySalary";
        String result = restTemplate.postForObject(url, formEntity, String.class);
		return result;
		}
}
