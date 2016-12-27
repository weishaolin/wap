$(function(){
	/*tab切换*/
	$(".pro_sort").on('click',function(){
		var $this = $(this);
		setTimeout(function(){
			if($this.hasClass('act')){
				$this.removeClass('act');
				$('.tab_sort').hide();
				$('body').css("overflow","auto");
				return;
			}
			$(".sel_wrap").hide();
			$('.tab_sort').show();
			$('body').css("overflow","hidden");
			$('.pro_select li').removeClass('act');
			$this.addClass('act');
		},200)
	});
	$(".pro_screen").on('click',function(){
		var $this = $(this);
		setTimeout(function(){
			if($this.hasClass('act')){
				$this.removeClass('act');
				$('.tab_screen').hide();
				$('body').css("overflow","auto");
				return;
			}
			$(".sel_wrap").hide();
			$('.tab_screen').show();
			$('body').css("overflow","hidden");
			$('.pro_select li').removeClass('act');
			$this.addClass('act');
		},200)
	});
	/*选择条件*/
	$('.screen_list ul li').on('click',function(){
		if($(this).hasClass('active')){
			$(this).removeClass('active');
			return;
		}
		$(this).addClass('active').siblings().removeClass('active');
	})
	/*清除条件*/
	$('#del').on('click',function(){
		$('.screen_list ul li').removeClass('active')
	})
})
