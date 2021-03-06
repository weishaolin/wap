package com.huatai.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.stereotype.Component;

//工具类
@Component
public class PostUtil {
//	private final static String SERVER_URL="http://112.74.213.8:82";//生产
	private final static String SERVER_URL="http://112.74.213.8:83/genu-wechat";//生产
//	private final static String SERVER_URL="http://10.173.187.179:83/genu-wechat";//阿里内网生产
//	private final static String SERVER_URL="http://47.92.69.17:8080/genu-wss-app";//test
//	private final static String SERVER_URL="http://localhost:82";//local
//	private final static String SERVER_URL="http://112.74.213.8:83/genu-wss-app";//测试

	public  String post(String postUrl,String param) {  
    	String strURL=postUrl;
    	String params=param;
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
	
	public String getForwardConnect(){
		String url = "";
		try {

			// System.out.println(path);
			Properties pro = new Properties();
			InputStream in = null;
			in = this.getClass().getResourceAsStream("/forwardConnect.properties");
			pro.load(in);
			url = pro.getProperty("Url");
		} catch (Exception e) {
			return e.getMessage();
		}
		return url;
	}
	//产品列表
	public String formDataPost(HashMap<String, Object> map){
		String url= SERVER_URL + "/product/tableborder/list";
		String rs = formDataPostMethod(map,url);
		return rs; 
	}
	
	//产品列表--根据供应商电话获取
	public String formProductDataPost(HashMap<String, Object> map,String mobile){
		String url=SERVER_URL + "/product/web/tableborder/list/"+mobile;
		String rs = formDataPostMethod(map,url);
		return rs; 
	}	
	
	//产品详情页面url
	public String formDataPostInfo(HashMap<String, Object> map){
		String url=SERVER_URL + "/product/info";
		String rs = formDataPostMethod(map,url);
		return rs; 
	}
	
	//木种列表
	public String formDataPostCategoryList(HashMap<String, Object> map){
		String url=SERVER_URL + "/category/web/list";
		String rs = formDataPostMethod(map,url);
		return rs; 
	}
	
	//木种列表--根据供应商电话获取
	public String formDataPostSupplierCategoryList(HashMap<String, Object> map,String mobile){
			String url=SERVER_URL + "/category/web/list/"+mobile;
		    String rs = formDataPostMethod(map,url);
			return rs; 
	}
	//供求列表
	public String formDataPostSellBuyInfoList(HashMap<String, Object> map){
			String url=SERVER_URL + "/sellBuyInfo/new/list";
			String rs = formDataPostMethod(map,url);
			return rs; 
		}
	//供求列表--根据供应商电话获取
	public String formDataPostSupplierSellBuyInfoList(HashMap<String, Object> map,String mobile){
		String url=SERVER_URL + "/product/web/sellBuyInfo/list/"+mobile;
		String rs = formDataPostMethod(map,url);
		return rs; 	
	}
	//供求列表
	public String formDataPostSellBuyInfoCategory(HashMap<String, Object> map){
		String url=SERVER_URL + "/category/web/top/level";
		String rs = formDataPostMethod(map,url);
		return rs; 		
	}	
	//供求列表--根据供应商电话获取
	public String formDataPostSupplierSellBuyInfoCategory(HashMap<String, Object> map,String mobile){
		String url=SERVER_URL + "/category/web/top/level/"+mobile;
		String rs = formDataPostMethod(map,url);
		return rs; 		
	}		
	//供求详情页面url
	public String formDataPostSellBuyInfo(HashMap<String, Object> map){
		String url=SERVER_URL + "/sellBuyInfo/new/info";
		String rs = formDataPostMethod(map,url);
		return rs; 	
	}

	/**
	 * 根据域名获取手机号
	 * @param map
	 * @return
	 */
	public String getMobileByDomain(HashMap<String, Object> map){
		String url=SERVER_URL + "/customer/get-mobile-by-domain";
		return formDataPostMethod(map,url);
	}
	
	public String formDataPostMethod(HashMap<String, Object> map,String requestUrl){
		String url= requestUrl;
	    HttpURLConnection connection = null;  
	    OutputStream outputStream = null;  
	    String rs = null;  
	    try { 
	    	URL urls = new URL(url); 
	        connection = (HttpURLConnection) urls.openConnection();  
	        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----footfoodapplicationrequestnetwork");  
	        connection.setDoOutput(true);  
	        connection.setDoInput(true);  
	        connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");  
	        connection.setRequestProperty("Accept", "*/*");  
	        connection.setRequestProperty("Range", "bytes="+"");  
	        connection.setConnectTimeout(8000);  
	        connection.setReadTimeout(20000);  
	        connection.setRequestMethod("POST");  
	        StringBuffer buffer = new StringBuffer();  
	        int len = 0;  
	       /* if(parameter != null)  
	            len = parameter.size();  */
	          
	        Iterator<Entry<String, Object>> it = map.entrySet().iterator();
	        while(it.hasNext()){
	        	java.util.Map.Entry entry = (java.util.Map.Entry)it.next();
	        	 buffer.append("------footfoodapplicationrequestnetwork\r\n");  
		            buffer.append("Content-Disposition: form-data; name=\"");  
		            buffer.append(entry.getKey());  
		            
		            buffer.append("\"\r\n\r\n");  
		            buffer.append(entry.getValue());
		           
		            buffer.append("\r\n");
	        	}
	        
	            buffer.append("------footfoodapplicationrequestnetwork--\r\n");  
	        try {  
	        	outputStream = connection.getOutputStream();
				outputStream.write(buffer.toString().getBytes());  
	            connection.connect();  
	            if(connection.getResponseCode() == 200) {   
	            	rs=connection.getInputStream().toString();
	            	BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
	                String line="";
	                String res = "";
//	                System.out.println(reader.readLine());
	                while ((line = reader.readLine()) != null){
	                	res += line;
	                }
	                reader.close();
	                return res;
	            }  
	        }  
	        catch (Exception e) {  
	            rs = null;  
	        }  
	       
	    }catch (Exception e) {
		}
	    finally {  
	        try {  
	            outputStream.close();  
	        }  
	        catch (Exception e) {  
	        }  
	        outputStream = null;  
	          
	        if(connection != null)  
	            connection.disconnect();  
	        connection = null;  
	    }
		return rs; 
	}
	
}
