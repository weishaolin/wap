$(function(){
	$("#backTop").each(function(){
		$(this).find(".btn-top").click(function(){
			$("html, body").animate({
				"scroll-top":0
			},"fast");
		});
	});
	var lastRmenuStatus=false;
	$(window).scroll(function(){//bug
		var _top=$(window).scrollTop();
		if(_top>200){
			$("#backTop").data("expanded",true);
		}else{
			$("#backTop").data("expanded",false);
		}
		if($("#backTop").data("expanded")!==lastRmenuStatus){
			lastRmenuStatus=$("#backTop").data("expanded");
			if(lastRmenuStatus){
				$("#backTop .btn-top").slideDown();
			}else{
				$("#backTop .btn-top").slideUp();
			}
		}
	});
});