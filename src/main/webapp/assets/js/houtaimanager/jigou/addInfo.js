jQuery(document).ready(function() {
	// 回调方法
	function excuteResponse(data) {
		// 刷新列表
		jumpPage('/sdeymanager/getHospitalList', $("#neirong"));
	}
	initAjaxForm(excuteResponse);
});
