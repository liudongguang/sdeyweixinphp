jQuery(document).ready(function() {
	// 回调方法
	function excuteResponse(data) {
		// 刷新列表
		jumpPage('/hospitalmanager/getDoctorListForHospitalManager', $("#neirong"));
	}
	initAjaxForm(excuteResponse);
	initDisplayImg('file_input', 'imgDIV');
	initSelect();
});
