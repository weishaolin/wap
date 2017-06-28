<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<script src="http://s95.cnzz.com/z_stat.php?id=1259853994&web_id=1259853994" language="JavaScript"></script>
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
<title>
<c:if test="${prolist.data.productType =='TABLE_BORDER' }">
${prolist.data.materialName}${prolist.data.length}*${prolist.data.widthName}*${prolist.data.height}
</c:if>
<c:if test="${prolist.data.productType =='WOOD' }">
${prolist.data.materialName}${prolist.data.length}米*${prolist.data.diameter}厘米
</c:if>
</title>
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
			<h1>${prolist.data.materialName}
			&emsp;状态:
			<c:if test="${prolist.data.status =='READY_SALES' }"><span style="color: green;">上架</span></c:if>
			<c:if test="${prolist.data.status =='BOOKING' }"><span style="color: red;">待定</span></c:if>
			<c:if test="${prolist.data.status =='OUT_SALES' }"><span style="color: red;">已下架</span></c:if>
			<c:if test="${prolist.data.status =='SOLD' }"><span style="color: red;">已售</span></c:if>
			</h1>
			<c:if test="${prolist.data.productType =='TABLE_BORDER' }">
			<p>尺寸：${prolist.data.length}*${prolist.data.widthName}*${prolist.data.height}&emsp;编号：${prolist.data.serialNo}</p>
			</c:if>
			<c:if test="${prolist.data.productType =='WOOD' }">
			<p>尺寸：${prolist.data.length}米*${prolist.data.diameter}厘米&emsp;编号：${prolist.data.serialNo}</p>
			</c:if>
		</div>
		<ul class="info_list">
		 <%-- <c:if test="${prolist.data.productType =='TABLE_BORDER' }">
			<li><span>长&emsp;度（cm）</span>${prolist.data.length}</li>
			<li><span>宽&emsp;度（cm）</span>${prolist.data.widthName}</li>
			<li><span>厚&emsp;度（cm）</span>${prolist.data.height}</li>
			<li><span>立方数（m<font>3</font>）</span>${prolist.data.cubage}</li> 
			<li><span>状&emsp;态：</span>
			<c:if test="${prolist.data.status =='READY_SALES' }"><span style="color: green;">上架</span></c:if>
			<c:if test="${prolist.data.status =='BOOKING' }"><span style="color: red;">待定</span></c:if>
			<c:if test="${prolist.data.status =='OUT_SALES' }"><span style="color: red;">已下架</span></c:if>
			<c:if test="${prolist.data.status =='SOLD' }"><span style="color: red;">已售</span></c:if>
			</li>
		</c:if>--%>
		<%-- <c:if test="${prolist.data.productType =='WOOD' }">
			<li><span>长&emsp;度（米）</span>${prolist.data.length}</li>
			<li><span>直径（cm）</span>${prolist.data.diameter}</li>
			<li><span>立方数（m<font>3</font>）</span>${prolist.data.cubage}</li>
			<li><span>重&emsp;量（kg）${prolist.data.weight}</span></li>
		</c:if> --%>
		</ul>
		<div class="pro_pic">
			<h1>产品图片</h1>
			<c:forEach items="${productAlbum}" var="pa">
			<img src="http://112.74.213.8:83/genu-wss-app${pa.image}"/>
			<a href="http://112.74.213.8:83/genu-wss-app${pa.image}">
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
