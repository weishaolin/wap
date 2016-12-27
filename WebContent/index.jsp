<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%-- <script src="${ctx}/js/jquery-2.1.3.min.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	 function ck(){
		 var ColumnList=new Object();
		 var arrayColumn=new Array();
		 ColumnList.currentlevel="222";
		 arrayColumn.push(ColumnList);
		        console.log(JSON.stringify(arrayColumn));
		        $.ajax({  
                    type:"POST",  //提交方式  
                    //async:false,  
                    //url : "http://10.100.1.125:7003/fw-app/app/cmc/mySalary",//路径  
                    url:"http://10.100.3.114:7003/fw-app/app/cmc/mySalary",
                    //dataType:'JSON', 
                    data:JSON.stringify(arrayColumn),//数据，这里使用的是Json格式进行传输  
                    contentType : "application/json",
                   // jsonp:'jsonpcallback', 
                    success : function(data) {//返回数据根据结果进行相应的处理  
                    	$("#storng").text(data);
                    } ,
                    error:function(){
                    	alert('fail');
                    	 //$("p").text(result.age); 
                    }
                }); 
		    }

	</script>
</head>
<body>
<span>数据：</span><strong id="storng">${ctx}</strong> <br/>
<a class="countBtn" onclick='ck()'>测试</a>
</body>
</html>