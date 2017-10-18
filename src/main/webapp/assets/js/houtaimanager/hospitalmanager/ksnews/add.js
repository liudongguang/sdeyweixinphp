jQuery(document).ready(function() {
	// 回调方法
	function excuteResponse(data) {
		// 刷新列表
		jumpPage('/hospitalmanager/getKsNewsListForHospitalManager', $("#neirong"));
	}
	initAjaxForm(excuteResponse);
	initSelect();
});
