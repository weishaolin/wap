<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>现货网站系统</title>
<link rel="stylesheet" type="text/css" href="${ctx}/scripts/fivestyle/css/style.css">
</head>
<body>
<!-- header start -->
<header id="header">
	<!-- <a href="#" class="back"  onclick="self.location=document.referrer;">&lt;</a> -->
	<h1>产品详情</h1>
</header>

<!-- wrap start -->
<div id="wrapper" class="wrap">
	<div class="pro_details">
		<div class="detail_title">
		<c:if test="${prolist.data.requestType =='BUY'}">
	 		<h1>求购</h1>
		</c:if>
		<c:if test="${prolist.data.requestType =='SELL'}">
	 		<h1>供应</h1>
		</c:if>
		<%-- ${prolist.data.content} --%>
			<p>${prolist.data.classificationName} ${prolist.data.materialName}
			${prolist.data.length}*${prolist.data.width}*${prolist.data.height} cm</p>
		</div>
		<ul class="info_list">
			<li><span>长&emsp;度（cm）</span>${prolist.data.length}</li>
			<li><span>宽&emsp;度（cm）</span>${prolist.data.width}</li>
			<li><span>厚&emsp;度（cm）</span>${prolist.data.height}</li>
			<li><span>供求数量</span>${prolist.data.number}</li>
			<%-- <li><span>重&emsp;量（kg）${prolist.data.weight}</span></li> --%>
		</ul>
		<div class="pro_pic">
			<h1>供求图片</h1>
			<c:forEach items="${productAlbum}" var="pa">
			<img src="http://112.74.213.8:82${pa.image}"/>
			<a href="http://112.74.213.8:82${pa.image}">
			看大图
			</a>
			</c:forEach>
		</div>
	</div>
	<!-- backTop -->
	<div id="backTop"><a href="javascript:;" class="btn-top"></a></div>
</div>
<!-- wrap end -->
<script type="text/javascript" src="${ctx}/scripts/fivestyle/js/jquery-2.1.3.min.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/fivestyle/js/common.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/fivestyle/js/backtop.js" ></script>
</body>
</html>
