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
<title>产品列表</title>
<link rel="stylesheet" type="text/css" href="${ctx}/scripts/H5pages/css/style.css">
</head>
<body>
<!-- header start -->
<header id="header">
	<a href="pro_class_list.html" class="back">&lt;</a>
	<h1>巴花现货<span>（230）</span></h1>
</header>

<!-- wrap start -->
<div id="wrapper" class="wrap">
	<ul class="pro_select clearFix">
			<li class="pro_sort">排序<i></i></li>
			<li class="pro_screen">筛选<i></i></li>
		</ul><!-- end select -->
		<div class="sel_wrap tab_sort">
			<ul class="sel_cont">
				<li><a href="#">长度最长</a></li>
				<li><a href="#">立方最贵</a></li>
				<li><a href="#">最多人看</a></li>
				<li><a href="#">最新发布</a></li>
			</ul>
		</div>
		<div class="sel_wrap tab_screen">
			<div class="screen_list">
				<h1>长度区间（cm）</h1>
				<ul class="clearFix">
					<li><a href="javascript:;">150以下</a></li>
					<li><a href="javascript:;">150-180</a></li>
					<li><a href="javascript:;">180-210</a></li>
					<li><a href="javascript:;">210-240</a></li>
					<li><a href="javascript:;">240-270</a></li>
					<li><a href="javascript:;">270-300</a></li>
					<li><a href="javascript:;">300-350</a></li>
					<li><a href="javascript:;">350-450</a></li>
					<li><a href="javascript:;">450以上</a></li>
				</ul>
				<p>自定义：<input type="text">&nbsp;&nbsp;--&nbsp;&nbsp;<input type="text"></p>
			</div>
			<div class="screen_list">
				<h1>宽度区间（cm）</h1>
				<ul class="clearFix">
					<li><a href="javascript:;">150以下</a></li>
					<li><a href="javascript:;">150-180</a></li>
					<li><a href="javascript:;">180-210</a></li>
					<li><a href="javascript:;">210-240</a></li>
					<li><a href="javascript:;">240-270</a></li>
					<li><a href="javascript:;">270-300</a></li>
				</ul>
				<p>自定义：<input type="text">&nbsp;&nbsp;--&nbsp;&nbsp;<input type="text"></p>
			</div>
			<div class="screen_list">
				<h1>厚度区间（cm）</h1>
				<ul class="clearFix">
					<li><a href="javascript:;">150以下</a></li>
					<li><a href="javascript:;">150-180</a></li>
					<li><a href="javascript:;">180-210</a></li>
					<li><a href="javascript:;">210-240</a></li>
				</ul>
				<p>自定义：<input type="text">&nbsp;&nbsp;--&nbsp;&nbsp;<input type="text"></p>
			</div>
			<div class="screen_list">
				<h1>边型</h1>
				<ul class="clearFix">
					<li><a href="javascript:;">全方</a></li>
					<li><a href="javascript:;">半方</a></li>
					<li><a href="javascript:;">自然边</a></li>
				</ul>
			</div>
			<div class="screenBtn">
				<a class="btn floatL" href="javascript:;" id="del">清空条件</a>
				<a class="btn floatR" href="javascript:;">确定</a>
			</div>
		</div>

	<div class="product_search">
		<input type="text" placeholder="请输入商品名称">
		<a href="#">搜索</a>
	</div><!-- end search -->
	
	<ul class="pro_list">
	<c:forEach items="${prolist}" var="pl">
		<li>
			<a href="pro_details.html">
				<div class="pro_pic">
					<img src="http://112.74.213.8:83/genu-wss-app${pl.productFirstAlbum}"/>
				</div>
				<div class="pro_info">
					<h1>${pl.materialName}</h1>
					<p>长：${pl.length}</p>
					<p>宽：${pl.width}</p>
					<p>厚：${pl.height}</p>
				</div>
				
			</a>
		</li>
		</c:forEach>
	</ul>
	
	<!-- backTop -->
	<div id="backTop">
		<a href="javascript:;" class="btn-top">
			
		</a>
	</div>
</div>
<!-- wrap end -->
<script type="text/javascript" src="${ctx}/scripts/H5pages/js/jquery-2.1.3.min.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/H5pages/js/common.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/H5pages/js/backtop.js" ></script>
</body>
</html>
