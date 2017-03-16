<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript">
	if(/Android (\d+\.\d+)/.test(navigator.userAgent)){
		var version = parseFloat(RegExp.$1);
		if(version>2.3){
			var phoneScale = parseInt(window.screen.width)/750;
			document.write('<meta name="viewport" content="width=750, minimum-scale = '+ phoneScale +', maximum-scale = '+ phoneScale +', target-densitydpi=device-dpi">');
		}else{
			document.write('<meta name="viewport" content="width=750, target-densitydpi=device-dpi">');
		}
	}else{
		document.write('<meta name="viewport" content="width=750, user-scalable=no, target-densitydpi=device-dpi">');
	};
</script>
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="description" content="">
<title>现货网站系统-大板现货</title>
<link rel="stylesheet" type="text/css" href="${ctx}/scripts/fivestyle/css/style.css">
</head>
<body>
<!-- header start -->
<header id="header">
	<a href="#" class="back">&lt;</a>
	<h1>现货产品分类</h1>
</header>

<!-- wrap start -->
<div id="wrapper" class="wrap">
	<ul class="class_list clearFix">
	<c:forEach items="${categoryList.data}" var="ca">
		<c:if test="${ ca.productCount>0}">
		<li>
			<a href="${ctx}/product/list/material/${mobile}?materialId=${ca.id}&materialName=${ca.name }">${ca.name } ${ca.productCount}<span>查看更多></span></a>
		</li>
	</c:if>
	</c:forEach>	
	<%-- <c:forEach items="${sellBuyList.data}" var="ca">
		<c:if test="${ ca.productCount>0}">
		<li>
			<a href="${ctx}/sellBuyInfo/list/material?classificationId=${ca.id}&classificationName=${ca.name }">${ca.name } ${ca.productCount}<span>查看更多></span></a>
		</li>
	</c:if>
	</c:forEach> --%>
	<%-- <c:if test="${ sellBuyList.total>0}">
		<li>
			<a href="${ctx}/sellBuyInfo/list">其他产品  ${sellBuyList.total}<span>查看更多></span></a>
		</li>
	</c:if> --%>
	</ul>
</div>
<!-- wrap end -->
<script type="text/javascript" src="${ctx}/scripts/fivestyle/js/jquery-2.1.3.min.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/fivestyle/js/common.js" ></script>
<img src="http://s95.cnzz.com/z_stat.php?id=1259853994&web_id=1259853994" width="0" height="0" style="position:absolute; left:-10000px;">
</body>
</html>
