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
<title>${materialName}${prolist.total }片 大板现货产品</title>
<link rel="stylesheet" type="text/css" href="${ctx}/scripts/fivestyle/css/style.css">
<link rel="icon" href="${ctx}/favicon.ico" />
<style type="text/css">
#wrapperscr {
	position:absolute; z-index:1;
	top:280px; bottom:48px; left:0;
	width:100%;
	 /* background:#555; */
	overflow:auto;
}
#scroller {

	 position:absolute;  z-index:1;
/*	-webkit-touch-callout:none;*/
	 -webkit-tap-highlight-color:rgba(0,0,0,0); 
	width:100%;
	 padding:0; 
}
 #scroller ul {
	position:relative;
	list-style:none;
	padding:0;
	margin:0;
	width:100%;
	text-align:left;
}
/** 
 * 
 * scroll styles 
 * 
 */
#scroller #pullDown{
/* padding:30px 30px 30px 30px; */
margin:0px 0px; 
} 
#pullDown,#pullUp {  
    background:#fff;  
    height:60px;  
    line-height:40px;  
    padding:0px 230px;
    border-bottom:1px solid #ccc;  
    font-weight:bold;  
    font-size:14px;  
    color:#888;
	text-align:center; /*水平居中*/
}  
#pullDown .pullDownIcon,#pullUp .pullUpIcon  { 
    display:block; float:left;  
    width:40px; height:40px;  
    background:url(${ctx}/scripts/fivestyle/image/pull-icon.png) 0 0 no-repeat;  
    -webkit-background-size:40px 80px; background-size:40px 80px;  
    -webkit-transition-property:-webkit-transform;  
    -webkit-transition-duration:250ms;  
}
#pullDown .pullDownIcon {
	-webkit-transform:rotate(0deg) translateZ(0);
}    
#pullUp .pullUpIcon  {  
    -webkit-transform:rotate(-180deg) translateZ(0);  
}
#pullDown.flip .pullDownIcon {
	-webkit-transform:rotate(-180deg) translateZ(0);
}
#pullUp.flip .pullUpIcon {  
    -webkit-transform:rotate(0deg) translateZ(0);  
}  
#pullDown.loading .pullDownIcon,#pullUp.loading .pullUpIcon {  
    background-position:0 100%;  
    -webkit-transform:rotate(0deg) translateZ(0);  
    -webkit-transition-duration:0ms;  
    -webkit-animation-name:loading;  
    -webkit-animation-duration:2s;  
    -webkit-animation-iteration-count:infinite;  
    -webkit-animation-timing-function:linear; 
}   
@-webkit-keyframes loading {  
    from { -webkit-transform:rotate(0deg) translateZ(0); }  
    to { -webkit-transform:rotate(360deg) translateZ(0); }  
} 

</style>
</head>
<body>
<input type="hidden" name="beginLength" id="beginLength" value="${transmit.beginLength }" /> 
<input type="hidden" name="endLength" id="endLength" value="${transmit.endLength }" /> 
<input type="hidden" name="beginWidth" id="beginWidth" value="${transmit.beginWidth }" /> 
<input type="hidden" name="endWidth" id="endWidth" value="${transmit.endWidth }" />
<input type="hidden" name="beginHeight" id="beginHeight" value="${transmit.beginHeight }" /> 
<input type="hidden" name="endHeight" id="endHeight" value="${transmit.endHeight }" /> 
<input type="hidden" name="edgeShape" id="edgeShape" value="${transmit.edgeShape }" />
<input type="hidden" name="sortProperty" id="sortProperty" value="${sortProperty.sortProperty }" /> 
<input type="hidden" name="searchStr" id="searchStr" value="${searchString }" />  
<input type="hidden" name="pageSize" id="pageSize" value="0" />   
<!-- header start -->
<header id="header">
	<%-- <a href="${ctx }/category/list" class="back">&lt;</a> --%>
	<h1>大板现货<span>${materialName}${prolist.total }</span></h1>
</header>
 
<!-- wrap start -->
<div id="wrapper" class="wrap">		
	<ul class="pro_select clearFix">
			<li class="pro_sort">排序<i></i></li>
			<li class="pro_screen">筛选<i></i></li>
		</ul><!-- end select -->
	<div class="sel_wrap tab_sort">
			<ul class="sel_cont">
				<li><a href="${ctx}/product/sortProperty?sortProperty=LENGTH&materialId=${materialId}">长度最长</a></li>
				<li><a href="${ctx}/product/sortProperty?sortProperty=PRICE&materialId=${materialId}">立方最贵</a></li>
				<li><a href="${ctx}/product/sortProperty?sortProperty=MODIFIEDTIME&materialId=${materialId}">最多人看</a></li>
				<li><a href="${ctx}/product/sortProperty?sortProperty=VIEWCOUNT&materialId=${materialId}">最新发布</a></li>
			</ul>
		</div>
	<div class="sel_wrap tab_screen">
			<div class="screen_list">
				<h1>长度区间（cm）</h1>
				<ul class="clearFix" id="lengthId">
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
				<p>自定义：<input id="bl" type="text">&nbsp;&nbsp;--&nbsp;&nbsp;<input id="el" type="text"></p>
			</div>
			<div class="screen_list">
				<h1>宽度区间（cm）</h1>
				<ul id="widthId" class="clearFix">
					<li><a href="javascript:;">80以下</a></li>
					<li><a href="javascript:;">80-90</a></li>
					<li><a href="javascript:;">90-100</a></li>
					<li><a href="javascript:;">100-110</a></li>
					<li><a href="javascript:;">110-120</a></li>
					<li><a href="javascript:;">120以上</a></li>
				</ul>
				<!-- <p>自定义：<input id="bw" type="text">&nbsp;&nbsp;--&nbsp;&nbsp;<input id="ew" type="text"></p> -->
			</div>
			<div class="screen_list">
				<h1>厚度区间（cm）</h1>
				<ul id="heigthId" class="clearFix">
					<li><a href="javascript:;">8以下</a></li>
					<li><a href="javascript:;">8-10</a></li>
					<li><a href="javascript:;">10-12</a></li>
					<li><a href="javascript:;">12以上</a></li>
				</ul>
				<!-- <p>自定义：<input id="bh" type="text">&nbsp;&nbsp;--&nbsp;&nbsp;<input id="eh" type="text"></p> -->
			</div>
			<div class="screen_list">
				<h1>边型</h1>
				<ul id="edgeShapeId" class="clearFix">
					<li value="1"><a href="javascript:;">全方</a></li>
					<li value="2"><a href="javascript:;">半方</a></li>
					<li value="3"><a href="javascript:;">自然边</a></li>
				</ul>
			</div>
			<div class="screenBtn">
				<a class="btn floatL" href="javascript:;" id="del">清空条件</a>
				<a id="submit" class="btn floatR" href="javascript:;">确定</a>
			</div>
		</div>
	
	<div class="product_search">
	<c:if test="${not empty searchString }">
		<input id="searchInput" type="text" value="${searchString }" placeholder="请输入商品名称/长度/宽度/厚度">
		<a href="#" id="searchString"><h1>搜索</h1></a>
	</c:if> 
	 <c:if test="${empty searchString }">
		<input id="searchInput" type="text"  placeholder="请输入商品名称/长度/宽度/厚度">
		<a href="#" id="searchString"><h1>搜索</h1></a>
	 </c:if> 
	</div><!-- end search -->
	
	<div id="wrapperscr" style="overflow: hidden; left: 0px;">  
	<div id="scroller" >
	<div id="pullDown">
			<span class="pullDownIcon"></span><span class="pullDownLabel">下拉刷新...</span>
	</div>
	<div class="pro_details" id="ulid">
		<c:forEach items="${prolist.data}" var="pl">
		<div class="pro_pic">	
			<h1>${fn:replace(pl.materialName,'南美','')} 
					长:${pl.length}宽:${pl.widthName}厚:${pl.height}</h1>
			<c:if test="${pl.status=='BOOKING'}">
					<span class="pro_status">待定</span>
			</c:if>
			<a href="${ctx}/product/info?uid=${pl.id}">
			<img src="http://112.74.213.8:82${fn:replace(pl.productFirstAlbum,'_small','')}"/>
			</a>
		</div>	
		</c:forEach>
	
	</div>
	<c:if test="${not empty prolist.data  && fn:length(prolist.data)>=0}">
	 <div id="pullUp">  
            <span class="pullUpIcon"></span><span class="pullUpLabel">上拉加载更多...</span>  
        </div>  
	</div>
	</c:if>
	<c:if test="${empty prolist.data}">
	 <div id="pullUp">  
            <span class="pullUpLabel">暂无更多数据...</span>  
        </div>  
	</div>
	</c:if>
	</div>
	<!-- backTop -->
	<div id="backTop"><a href="javascript:;" class="btn-top"></a></div>
</div>
<!-- wrap end -->
<script type="text/javascript" src="${ctx}/scripts/fivestyle/js/jquery-2.1.3.min.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/fivestyle/js/common.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/fivestyle/js/backtop.js" ></script>
<script type="text/javascript" src="${ctx}/scripts/fivestyle/js/iscroll.js" ></script>
<script type="text/javascript">
  
var range = {
	'length':'',
	'width': '',
	'Height':'',
	'beginLength':'',
	'endLength':'',
	'beginWidth':'',
	'endWidth':'',
	'beginHeight':'',
	'endHeight':'',
	'edgeShape':'',
	'pageSize':''
};

var sear=new RegExp('-');
	$("#searchString").click(function(){
		var inputVal=$("#searchInput").val();
		var result=new Object();
		 result.beginLength=range.beginLength
		 result.endLength=range.endLength
		 result.beginWidth=range.beginWidth
		 result.endWidth=range.endWidth
		 result.beginHeight=range.beginHeight
		 result.endHeight=range.endHeight
		 result.edgeShape=range.edgeShape
		 result.material = "${materialId}";
		 result.searchString = inputVal;
		 var pro = JSON.stringify(result);
		//location.href = "${ctx}/product/searchString?searchString="+pro;
		 location.href = "${ctx}/product/screen?data="+pro;
	});
	//长
	$("#lengthId li").click(function(){
		//alert($(this).text());
		range.length=$(this).text();
		if(sear.test(range.length)){
		}else{
			if(range.length.substring(0,3)=="150"){
				range.length="0-150";
			}else{
				range.length="450-1000";
			}
		}
		var lgi=range.length.split('-');
		//长度开始
		range.beginLength=lgi[0];
		//长度结束
		range.endLength=lgi[1];
		});
	//宽
	$("#widthId li").click(function(){
		//alert($(this).text());
		range.width=$(this).text();
		if(sear.test(range.width)){
		}else{
			if(range.width.substring(0,2)=="80"){
				range.width="0-80";
			}else{
				range.width="120-1000";
			}
		}
		var wdi=range.width.split('-');
		//长度开始
		range.beginWidth=wdi[0];
		//长度结束
		range.endWidth=wdi[1];
		});
	//厚
	$("#heigthId li").click(function(){
		//alert($(this).text());
		range.Height=$(this).text();
		if(sear.test(range.Height)){
		}else{
			if(range.Height.substring(0,1)=="8"){
				range.Height="0-8";
			}else{
				range.Height="12-1000";
			}
		}
		var hgi=range.Height.split('-');
		//长度开始
		range.beginHeight=hgi[0];
		//长度结束
		range.endHeight=hgi[1];
		});
	//边型
	$("#edgeShapeId li").click(function(){
		range.edgeShape=$(this).val();
		if(range.edgeShape=="1"){
			range.edgeShape="WHOLE_EDGE";
		}else if(range.edgeShape=="2"){
			range.edgeShape="HALF_EDGE";
		}else{
			range.edgeShape="NATURAL_EDGE";
		}
		});
	$("#submit").click(function(){
		//自定义长度输入框
		if($.trim($('#bl').val())!="" && $.trim($('#el').val())!=""){
			range.beginLength=$.trim($('#bl').val());
			range.endLength=$.trim($('#el').val());
		}
		//自定义宽度输入框
		if($.trim($('#bw').val())!="" && $.trim($('#ew').val())!=""){
			range.beginWidth=$.trim($('#bw').val());
			range.endWidth=$.trim($('#ew').val());
		}
		//自定义厚度输入框
		if($.trim($('#bh').val())!="" && $.trim($('#eh').val())!=""){
			range.beginHeight=$.trim($('#bh').val());
			range.endHeight=$.trim($('#eh').val());
		}
		 var result=new Object();
		 result.beginLength=range.beginLength
		 result.endLength=range.endLength
		 result.beginWidth=range.beginWidth
		 result.endWidth=range.endWidth
		 result.beginHeight=range.beginHeight
		 result.endHeight=range.endHeight
		 result.edgeShape=range.edgeShape
		 result.material = "${materialId}";
		 result.searchString=$("#searchStr").val();
		 var pro = JSON.stringify(result);
		 location.href = "${ctx}/product/screen?data="+pro;
	 	  /*$.post("${ctx}/screen",pro,function(data,status){
		        alert("Data: " + pro + "nStatus: " + status);
		    }); */
		  /* $.ajax({  
             type : "POST",  //提交方式  
             async:false,  
             url : "${ctx}/screen",//路径  
             //dataType:'JSON', 
             data :pro,//数据，这里使用的是Json格式进行传输  
             contentType : "application/json",
            // jsonp:'jsonpcallback', 
             success : function(data) {//返回数据根据结果进行相应的处理  
             	$("#storng").text(data);
             } ,
             error:function(){
             	alert('fail');
             	 //$("p").text(result.age); 
             }
         });  */
		});
</script>
<script type="text/javascript">
var myScroll,  
pullDownEl, pullDownOffset,  
pullUpEl, pullUpOffset,  
generatedCount = 0;  

var rangeTwo={
		'beginLength':'',
		'endLength':'',
		'beginWidth':'',
		'endWidth':'',
		'beginHeight':'',
		'endHeight':'',
		'edgeShape':'',
		'pageSize':'0'
}
/* $(document).ready(function(){
	rangeTwo.beginLength=${transmit.beginLength };
	rangeTwo.endLength=${transmit.endLength };
	rangeTwo.beginWidth=${transmit.beginWidth };
	rangeTwo.endWidth=${transmit.endWidth };
	rangeTwo.beginHeight=${transmit.beginHeight };
	rangeTwo.endHeight=${transmit.endHeight };
	rangeTwo.edgeShape=${transmit.edgeShape };
}); */
function pullDownAction () {  
   /*  $.ajax({  
    url:"刷新的ajax请求",  
    type:"POST",  
    success:function(json){  
        //使用ajax请求刷新列表数据，这块肯定得自己写  
        //...  
        myScroll.refresh();//刷新滑动区域  
    }  
});   */
	location.href = "${ctx}/product/list/material?materialId=${materialId}&materialName=${materialName}";
}   

function pullUpAction () { 
	 $("#pageSize").val(parseInt($("#pageSize").val())+1);
	 var object=new Object();
	 object.beginLength=$("#beginLength").val();
	 object.endLength=$("#endLength").val();
	 object.beginWidth=$("#beginWidth").val();
	 object.endWidth=$("#endWidth").val();
	 object.beginHeight=$("#beginHeight").val();
	 object.endHeight=$("#endHeight").val();
	 object.beginLength=$("#beginLength").val();
	 object.edgeShape=$("#edgeShape").val();
	 object.pageSize=$("#pageSize").val();
	 object.material = "${materialId}";
	 object.sortProperty=$("#sortProperty").val();
	 object.searchString=$("#searchStr").val();
	var obj= JSON.stringify(object);
	var content=""; 
   $.ajax({  
    url:"${ctx}/product/pullUp?pullUp="+obj,  
    type:"POST",  
   // data :obj,//数据，这里使用的是Json格式进行传输  
    contentType : "application/json",
    success:function(data){  
        //使用ajax请求返回的数据追加到列表后面，这块肯定得自己写  
        //...  
        var obj= JSON.stringify(data);
        var c =$.parseJSON( data );
        if(c.data.length<10){
        	$("#pullUp").hide();
        }
        if(c.data.length==0){
        	 $("#pullUp").hide();
        	 $("#pageSize").val(parseInt($("#pageSize").val())-1);
        }
        $.each(eval("("+data+")").data, function(i, item) {
        	content=content  
            +   '<div class="pro_pic">'	
            +   '<h1>'+item.materialName.replace('南美','')
            +   '长:'+item.length+'宽:'+item.widthName+'厚:'+item.height+'</h1>'
            /*  if(item.status==='BOOKING')
            +   '<span>待定</span>' */
            +   '<a href="${ctx}/product/info?uid='+item.id+'">' 
            +   '<img src="http://112.74.213.8:82'+item.productFirstAlbum.replace("_small","")+'"/>' 
            +   '</a>'
            +   '</div>	'
            
			 });
	 	/* var uid = document.getElementById("ulid");
		uid.innerHtml=content;  */
       $("#ulid").append(content);
        myScroll.refresh();//刷新滑动区域  
    },
    error:function(){
    	alert('服务器错误！');
    }
});   
myScroll.refresh();//刷新滑动区域  
}  

function loaded() {  
pullDownEl = document.getElementById('pullDown');  
pullDownOffset = pullDownEl.offsetHeight;   
pullUpEl = document.getElementById('pullUp');     
if(pullUpEl==null) pullUpOffset = 90;
else
pullUpOffset = pullUpEl.offsetHeight;  
  
myScroll = new iScroll('wrapperscr', {  
    useTransition: true,  
    topOffset: pullDownOffset,  
    onRefresh: function () {//myScroll刷新时触发  
         if (pullDownEl.className.match('loading')) {  
            pullDownEl.className = '';  
            pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';  
        } else  if (pullUpEl.className.match('loading')) {  
            pullUpEl.className = '';  
            pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';  
        }  
    },  
    onScrollMove: function () {//上下滑动时触发  
         if (this.y > 5 && !pullDownEl.className.match('flip')) {  
            pullDownEl.className = 'flip';  
            pullDownEl.querySelector('.pullDownLabel').innerHTML = '释放立即加载...';  
            this.minScrollY = 0;  
        } else if (this.y < 5 && pullDownEl.className.match('flip')) {  
            pullDownEl.className = '';  
            pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';  
            this.minScrollY = -pullDownOffset;  
        } else  if (this.y < (this.maxScrollY - 5) && !pullUpEl.className.match('flip')) {  
            pullUpEl.className = 'flip';  
            pullUpEl.querySelector('.pullUpLabel').innerHTML = '释放立即加载...';  
            this.maxScrollY = this.maxScrollY;  
        } else if (this.y > (this.maxScrollY + 5) && pullUpEl.className.match('flip')) {  
            pullUpEl.className = '';  
            pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';  
            this.maxScrollY = pullUpOffset;  
        }  
    },  
    onScrollEnd: function () {//上下滑到底部时触发  
         if (pullDownEl.className.match('flip')) {  
            pullDownEl.className = 'loading';  
            pullDownEl.querySelector('.pullDownLabel').innerHTML = '加载中...';                  
            pullDownAction();//在这里定义下拉时的行为  
        } else  if (pullUpEl.className.match('flip')) {  
            pullUpEl.className = 'loading';  
            pullUpEl.querySelector('.pullUpLabel').innerHTML = '加载中...';                  
            pullUpAction();//在这里定义上拉时的行为  
        }  
    }  
});
setTimeout(function () { document.getElementById('wrapperscr').style.offsetleft = '10'; }, 800); 
}  

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);  

window.addEventListener('load', function () { setTimeout(loaded, 200); }, false);  	
</script>
<script src="http://s95.cnzz.com/z_stat.php?id=1259853994&web_id=1259853994" language="JavaScript"></script>

</body>
</html>
