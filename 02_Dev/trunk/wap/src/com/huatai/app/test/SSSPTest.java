package com.huatai.app.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.hibernate.ejb.QueryHints;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.huatai.app.util.PostUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SSSPTest<E> {
	
	/*private ApplicationContext ctx = null;
	private DepartmentRepository departmentRepository;
	private EntityManagerFactory entityManagerFactory;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		departmentRepository = ctx.getBean(DepartmentRepository.class);
		entityManagerFactory = ctx.getBean(EntityManagerFactory.class);
	}
	
	@Test
	public void testJpaSecondLevelCache(){
		String jpql = "FROM Department d";
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery(jpql);
		List<Department> departments = query.setHint(QueryHints.HINT_CACHEABLE, true).getResultList();
		
		entityManager.close();
		
		entityManager = entityManagerFactory.createEntityManager();
		query = entityManager.createQuery(jpql);
		departments = query.setHint(QueryHints.HINT_CACHEABLE, true).getResultList();
		entityManager.close();
	}
	
	@Test
	public void testRepositorySecondLevelCache(){
		List<Department> departments = departmentRepository.getAll();
		departments = departmentRepository.getAll();
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}*/

	@Test
	public void testt(){
		//请求转发
			String url="";
			try {
				Properties pro = new Properties();
				FileInputStream in = new FileInputStream("./src/forwardConnect.properties");
				pro.load(in);
				url=pro.getProperty("GsTestUrl");
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(url);
			RestTemplate restTemplate = new RestTemplate();
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			
			/*List messageConverters=new ArrayList();
			  messageConverters.add(new SourceHttpMessageConverter());
			  messageConverters.add(new FormHttpMessageConverter());
			  messageConverters.add(new MappingJackson2HttpMessageConverter());
			  restTemplate.setMessageConverters(messageConverters);*/
			
			map.put("policyCode", "1111");
			//JSONObject jsonObj = JSONObject.fromObject(map);
			JSONArray jsonObj=JSONArray.fromObject(map);
			System.out.println("jsonObj:" + jsonObj);
			// url="http://192.168.3.103:8080/jdev/gs/month/schedulConcludeRate/gstest?pageNumber=2";
//			String Controllerurl=url+"/app/cmc/mySalary";
			String Controllerurl="http://192.168.0.89:8080/fw-app/app/cmc/mySalary";
			//String url = "http://192.168.3.134:8080/jdev/app/cmc/test";
			String result = restTemplate.postForObject(Controllerurl, jsonObj, String.class);
			System.out.println("result:" + result);
	}
	
	
	@Test
	public void test2(){
		RestTemplate restTemplate = new RestTemplate();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("currentUserId", "11");
		JSONArray jsonObj = JSONArray.fromObject(map);
		String Controllerurl = "http://112.74.213.8:83/genu-wss-app/product/tableborder/list";
		String result = restTemplate.postForObject(Controllerurl, jsonObj, String.class);
		System.out.println(result);
	}
	@Test
	public void test3() throws Exception{
		String url="http://112.74.213.8:83/genu-wss-app/product/tableborder/list";
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
	          
	       /* for(int i = 0; i < len; i++) {*/  
	            buffer.append("------footfoodapplicationrequestnetwork\r\n");  
	            buffer.append("Content-Disposition: form-data; name=\"");  
	            buffer.append("currentUserId");  
	            buffer.append("\"\r\n\r\n");  
	            buffer.append("1");  
	            buffer.append("\r\n");  
	       /* }  */
	      /*  if(parameter != null)  */
	            buffer.append("------footfoodapplicationrequestnetwork--\r\n");  
	        try {  
	        	outputStream = connection.getOutputStream();
				outputStream.write(buffer.toString().getBytes());  
	            connection.connect();  
	            if(connection.getResponseCode() == 200) {  
//	                rs = getWebSource(connection.getInputStream());  
	            	rs=connection.getInputStream().toString();
	            	BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
	                String line="";
	                String res = "";
//	                System.out.println(reader.readLine());
	                while ((line = reader.readLine()) != null){
	                	res += line;
	                }
//	                System.out.println(res);
	              JSONObject json = JSONObject.fromObject(res);
	              //	                System.out.println(json);
	         /*       System.out.println(json.getString("data"));
	                JSONArray jsonArray = json.getJSONArray("data");
	                for (int i = 0; i < jsonArray.size(); i++) {
						System.out.println(jsonArray.get(i));
					}
	                System.out.println(jsonArray.get(0));*/
	               System.out.println(json.get("data"));
	         /*       Iterator iter = json.keySet().iterator();  
	                Map<String,String> map = new HashMap<String,String>();  
	                while (iter.hasNext()) {  
	                 String key = (String) iter.next();  
	                 String value = json.getString(key);  
	                 map.put(key, value);  
	                }  
	                System.out.println("map:"+map);*/
	               
	               
	                
	                reader.close();
	            }  
	        }  
	        catch (Exception e) {  
	            rs = null;  
	        }  
	          
//	        return res; 
	       
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
	}
	
	@Test
	public void tes(){
	/*	PostUtil postUtil = new PostUtil();
		String formDataPost = postUtil.formDataPost();
		System.out.println(formDataPost);*/
		HashMap<String, Object> map = new HashMap<String, Object>();
		 List arrayList = new ArrayList<>();
		String ss="/down/201610/d1727d10-bc42-4ea3-a192-3dcc5b57e55b.jpg,/down/201610/edfeabbd-2a7a-4d59-90c4-ba760074986b.jpg,/down/201610/0f2c3a5a-43e0-4b42-9e12-3285303af351.jpg,/down/201610/d12e29ab-ecbb-4ade-858a-c8bda9c1ecee.jpg,/down/201610/f05de7f5-cf7a-4b2c-ae69-65a630c25aff.jpg,/down/201610/d054fac3-be00-4322-87c2-367a2c1d26fc.jpg,/down/201610/08726025-0e2e-47aa-8647-edee91943261.jpg,/down/201610/3f0ddfb6-636c-4198-b4ca-5daadf7b7f26.jpg,/down/201610/4e2d7b23-e8b7-4442-b3a6-5e95e751ca13.jpg";
		   String[] sourceStrArray = ss.split(",");
	        for (int i = 0; i < sourceStrArray.length; i++) {
	            System.out.println(sourceStrArray[i]);
	            map.put("image", sourceStrArray[i]);
	            JSONObject jb=JSONObject.fromObject(map);
	            arrayList.add(jb);
	        }
	        System.out.println(arrayList);
	}
}
