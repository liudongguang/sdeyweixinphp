jQuery(document).ready(function() {
	$("#inputfile").fileinput({
		language : 'zh', // 设置语言
		showUpload : false
	});
	// 回调方法
	function excuteResponse(data) {
		// 刷新列表
		jumpPageForWX('/weixinConfig/getSuCaiList', $("#mainDIVID"));
	}
	initAjaxForm(excuteResponse);
	$("#backBT").click(function() {
		jumpPageForWX("/weixinConfig/getSuCaiList", $("#mainDIVID"));
	})
});